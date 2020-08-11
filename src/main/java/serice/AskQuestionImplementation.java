package serice;

import java.util.Scanner;

import static serice.SendMessage.sendMessage;


public class AskQuestionImplementation implements AskQuestion {

    @Override
    public int askQuestion(Scanner scanner, String question, String answer) {
        sendMessage("Вопрос: " + question + "\nВведите в консоль ответ на вопрос");
        if (scanner.next().equals(answer)){
            sendMessage("Верный ответ");
            return 1;
        }
        else {
            sendMessage("Ответ не верный");
            return 0;
        }
    }
}
