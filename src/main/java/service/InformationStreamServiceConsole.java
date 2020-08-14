package service;

import java.util.Scanner;

public class InformationStreamServiceConsole implements InformationStreamService {
    @Override
    public void output(String textMessage) {
        System.out.println(textMessage);
    }

    @Override
    public String input() {
        Scanner scannerExam = new Scanner(System.in);
        String string = scannerExam.next();
        return string;
    }
}
