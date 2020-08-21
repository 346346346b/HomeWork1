package service;

import dao.QuestionDao;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Quiz {

    private final InformationStreamService infoStreamService;
    private final QuestionDao questionDao;
    private final QuestionService questionService;

    public Quiz(InformationStreamService infoStreamService, QuestionDao questionDao, QuestionService questionService) {
        this.infoStreamService = infoStreamService;
        this.questionDao = questionDao;
        this.questionService = questionService;
    }

    public void startQuiz() throws IOException {

        String questionText;
        String answerText;

        infoStreamService.output("Введите имя");
        String firstName = infoStreamService.input();
        infoStreamService.output("Введите фамилию");
        String secondName = infoStreamService.input();

        TreeMap<String,String> questionAndAnswer = questionDao.readQuestions();
        int i = 1;
        int trueAnswer = 0;
        for (Map.Entry<String, String> e : questionAndAnswer.entrySet()) {
            questionText = e.getKey();
            answerText = e.getValue();

            infoStreamService.output("");
            infoStreamService.output("Вопрос номер: " + i);
            trueAnswer = trueAnswer + questionService.askQuestion(questionText, answerText);
            i++;
        }
        infoStreamService.output(firstName + " " + secondName + " тест окончен. Правильных ответов " + trueAnswer + " из " + questionAndAnswer.size());
    }

}
