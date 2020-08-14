import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Quiz;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        Quiz quiz = context.getBean(Quiz.class);
        quiz.startQuiz();
    }
}
