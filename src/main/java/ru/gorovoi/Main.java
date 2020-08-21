package ru.gorovoi;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.gorovoi.service.Quiz;

import java.io.IOException;
import java.util.Locale;

@ComponentScan
public class Main {
    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/message");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        Quiz quiz = context.getBean(Quiz.class);
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Current Locale: " + Locale.getDefault());
        quiz.startQuiz();
    }
}
