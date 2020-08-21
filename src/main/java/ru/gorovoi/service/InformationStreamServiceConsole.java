package ru.gorovoi.service;

import org.springframework.stereotype.Service;
import java.util.Scanner;

@Service
public class InformationStreamServiceConsole implements InformationStreamService {
    @Override
    public void output(String textMessage) {
        System.out.println(textMessage);
    }

    @Override
    public String input() {
        Scanner scannerExam = new Scanner(System.in);
        return scannerExam.nextLine();
    }
}
