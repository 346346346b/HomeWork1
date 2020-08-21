package ru.gorovoi.dao;

import liquibase.util.csv.CSVReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeMap;

@Component
@PropertySource("application.resources")
public class QuestionDaoCSV implements QuestionDao {
    @Value("${pathQuestion}")
    private String pathQuestion;
    public TreeMap<String,String> readQuestions() throws IOException {
        TreeMap<String, String> questionAndAnswer = new TreeMap<>();
        CSVReader reader = new CSVReader(new FileReader(pathQuestion), ';', '"', 1);
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            String[] string = Arrays.toString(nextLine).replaceAll("[\\[\\]]", "").split(",");
            questionAndAnswer.put(string[0].trim(), string[1].trim());
        }
        return questionAndAnswer;
    }
}
