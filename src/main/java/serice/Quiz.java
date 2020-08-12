package serice;

import dao.ReadQuestions;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Quiz  {
    private final ReadQuestions quizRead;
    private final SendMessage quizSend;
    private AskQuestion quizGetQuestion = null;

    private String questionText;
    private String answerText;

    public Quiz(ReadQuestions quizRead, SendMessage quizSend, AskQuestion quizAskQuestion) {
        this.quizRead = quizRead;
        this.quizSend = quizSend;
        this.quizGetQuestion = quizGetQuestion;
    }

    public void startQuiz() throws IOException {
        Map <String,String> map = quizRead.readQuestions();
        Scanner scanner = new Scanner(System.in);//TODO Корректное ли решение?

        quizSend.sendMessage("Введите имя");
        String firstName = scanner.next();
        quizSend.sendMessage("Введите фамилию");
        String secondName = scanner.next();
        int i = 1;
        int trueAnswer = 0;
        for (Map.Entry<String, String> e : map.entrySet()) {
            questionText = e.getKey();
            answerText = e.getValue();

            quizSend.sendMessage("");
            quizSend.sendMessage("Вопрос номер: " + i);

            quizGetQuestion.askQuestion(scanner, questionText, answerText);
            //System.out.println("Внимание, вопрос: " + e.getKey() + "\n" + "Введите ответ в консоль");
            //String answerUser = scanner.next();
            //if(answerUser.equals(e.getValue())){
            //    sendMesQuiz.sendMessage("Ответ верный");
            //    trueAnswer++;
            //}else{
            //    sendMesQuiz.sendMessage("Ваш ответ не правильный");
            //    sendMesQuiz.sendMessage("Верный варинат ответа: " + e.getValue());
            //}
            i++;
        }
        quizSend.sendMessage(firstName + " " + secondName + " тест окончен. Правильных ответов " + trueAnswer + " из " + map.size());
    }

}
