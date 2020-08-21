package ru.gorovoi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.gorovoi.dao.QuestionDao;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

@Service
@PropertySource("application.resources")
public class Quiz {
    @Value("${passedPoints}")
    private int passedPoints;

    private final InformationStreamService infoStreamService;
    private final QuestionDao questionDao;
    private final QuestionService questionService;
    private final MessageSource messageSource;

    public Quiz(InformationStreamService infoStreamService, QuestionDao questionDao, QuestionService questionService, MessageSource messageSource) {
        this.infoStreamService = infoStreamService;
        this.questionDao = questionDao;
        this.questionService = questionService;
        this.messageSource = messageSource;
    }


    public void startQuiz() throws IOException {

        String questionText;
        String answerText;

        infoStreamService.output(messageSource.getMessage("enter.firstName", null, Locale.getDefault()));
        String firstName = infoStreamService.input();
        infoStreamService.output(messageSource.getMessage("enter.lastName", null, Locale.getDefault()));
        String secondName = infoStreamService.input();

        TreeMap<String, String> questionAndAnswer = questionDao.readQuestions();
        int i = 1;
        int trueAnswer = 0;
        for (Map.Entry<String, String> e : questionAndAnswer.entrySet()) {
            questionText = e.getKey();
            answerText = e.getValue();

            infoStreamService.output("");
            infoStreamService.output(messageSource.getMessage("number.question", null, Locale.getDefault()) + i);
            trueAnswer = trueAnswer + questionService.askQuestion(questionText, answerText);
            i++;
        }


        if (trueAnswer>=passedPoints){
            infoStreamService.output(firstName + " " + secondName + " " + messageSource.getMessage("test.passed", null, Locale.getDefault()) + " " + trueAnswer + " / " + questionAndAnswer.size());
        }
        else {
            infoStreamService.output(firstName + " " + secondName + " " + messageSource.getMessage("test.failed", null, Locale.getDefault()) + " " + trueAnswer + " / " + questionAndAnswer.size());
        }

    }

}
