package ru.gorovoi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final InformationStreamService info;

    public QuestionServiceImpl(InformationStreamService info) {
        this.info = info;
    }

    @Autowired
    private MessageSource messageSource;

    @Override
    public int askQuestion(String question, String answer) {
        info.output(messageSource.getMessage("question.text", null, Locale.getDefault()) + question + "\n" + messageSource.getMessage("enter.answer", null, Locale.getDefault()));
        if (info.input().equals(answer)) {
            info.output(messageSource.getMessage("true.answer", null, Locale.getDefault()));
            return 1;
        } else {
            info.output( messageSource.getMessage("false.answer", null, Locale.getDefault())+ " " + messageSource.getMessage("true.answer", null, Locale.getDefault()) + answer);
            return 0;
        }
    }
}
