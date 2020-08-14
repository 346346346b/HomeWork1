package service;

import dao.QuestionDao;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Quiz {

    private final InformationStreamService inf;
    private final QuestionDao dao;
    private final QuestionService question;

    public Quiz(InformationStreamService inf, QuestionDao dao, QuestionService question) {
        this.inf = inf;
        this.dao = dao;
        this.question = question;
    }

    public void startQuiz() throws IOException {

        String questionText;
        String answerText;

        inf.output("Введите имя");
        String firstName = inf.input();
        inf.output("Введите фамилию");
        String secondName = inf.input();

        TreeMap<String,String> questionAndAnswer = dao.readQuestions();
        int i = 1;
        int trueAnswer = 0;
        for (Map.Entry<String, String> e : questionAndAnswer.entrySet()) {
            questionText = e.getKey();
            answerText = e.getValue();

            inf.output("");
            inf.output("Вопрос номер: " + i);
            trueAnswer = trueAnswer + question.askQuestion(questionText, answerText);
            i++;
        }
        inf.output(firstName + " " + secondName + " тест окончен. Правильных ответов " + trueAnswer + " из " + questionAndAnswer.size());
    }

}
