package serice;

import java.util.Scanner;

public class AskQuestionImplementation implements AskQuestion {
    private final SendMessageToConsole sendMes;

    public AskQuestionImplementation(SendMessageToConsole sendMes) {
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
            sendMes.sendMessage("Ответ не верный");
            return 0;
        }
    }
}
