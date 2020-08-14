package service;

import dao.QuestionDao;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Quiz {

    private final InformationStreamService infoStream;
    private final QuestionDao questionDao;
    private final QuestionService askQuestion;

    public Quiz(InformationStreamService infoStream, QuestionDao questionDao, QuestionService askQuestion) {
        this.infoStream = infoStream;
        this.questionDao = questionDao;
        this.askQuestion = askQuestion;
    }

    public void startQuiz() throws IOException {

        String questionText;
        String answerText;

        infoStream.output("Введите имя");
        String firstName = infoStream.input();
        infoStream.output("Введите фамилию");
        String secondName = infoStream.input();

        TreeMap<String,String> questionAndAnswer = questionDao.readQuestions();
        int i = 1;
        int trueAnswer = 0;
        for (Map.Entry<String, String> e : questionAndAnswer.entrySet()) {
            questionText = e.getKey();
            answerText = e.getValue();

            infoStream.output("");
            infoStream.output("Вопрос номер: " + i);
            trueAnswer = trueAnswer + askQuestion.askQuestion(questionText, answerText);
            i++;
        }
        infoStream.output(firstName + " " + secondName + " тест окончен. Правильных ответов " + trueAnswer + " из " + questionAndAnswer.size());
    }

}
