package service;

import java.util.Scanner;

public class AskQuestionImpl implements AskQuestion {
    private final SendMessage sendMes;

    public AskQuestionImpl(SendMessage sendMes) {
        this.sendMes = sendMes;
    }

    @Override
    public int askQuestion(Scanner scanner, String question, String answer) {
        
        sendMes.sendMessage("Вопрос: " + question + "\nВведите в консоль ответ на вопрос");
        if (scanner.next().equals(answer)){
            sendMes.sendMessage("Ответ верный");
            return 1;
        }
        else {
            sendMes.sendMessage("Ответ не верный. " + " Верный ответ" +  answer);
            return 0;
        }
    }
}
