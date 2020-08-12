import org.springframework.context.support.ClassPathXmlApplicationContext;
import serice.Quiz;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        Quiz service = context.getBean(Quiz.class);
        service.startQuiz();
    }
}
