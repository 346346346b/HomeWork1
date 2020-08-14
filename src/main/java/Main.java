import dao.ReadQuestions;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AskQuestion;
import service.Quiz;
import service.SendMessage;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        ReadQuestions readQuestions =context.getBean(ReadQuestions.class);
        SendMessage sendMessage = context.getBean(SendMessage.class);
        AskQuestion askQuestion = context.getBean(AskQuestion.class);
        Scanner scanner = new Scanner(System.in);
        Quiz quiz = context.getBean(Quiz.class);
        quiz.startQuiz(readQuestions,sendMessage,askQuestion,scanner);
    }
}
