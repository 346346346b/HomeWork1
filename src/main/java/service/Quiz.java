package service;

import dao.ReadQuestions;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

@Component
public class Quiz {

    public void startQuiz(ReadQuestions readQuestionsInst, SendMessage quizSendInst, AskQuestion askQuestionInst, Scanner scanner) throws IOException {
        String questionText;
        String answerText;

        quizSendInst.sendMessage("Введите имя");
        String firstName = scanner.next();
        quizSendInst.sendMessage("Введите фамилию");
        String secondName = scanner.next();

        TreeMap<String,String> questionAndAnswer = readQuestionsInst.readQuestions();
        int i = 1;
        int trueAnswer = 0;
        for (Map.Entry<String, String> e : questionAndAnswer.entrySet()) {
            questionText = e.getKey();
            answerText = e.getValue();

            quizSendInst.sendMessage("");
            quizSendInst.sendMessage("Вопрос номер: " + i);
            trueAnswer = trueAnswer + askQuestionInst.askQuestion(scanner, questionText, answerText);
            i++;
        }
        quizSendInst.sendMessage(firstName + " " + secondName + " тест окончен. Правильных ответов " + trueAnswer + " из " + questionAndAnswer.size());
    }

}
