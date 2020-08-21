package dao;

import liquibase.util.csv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeMap;

public class QuestionDaoCSV implements QuestionDao {
    public TreeMap<String,String> readQuestions() throws IOException {
        TreeMap<String, String> questionAndAnswer = new TreeMap<>();
        CSVReader reader = new CSVReader(new FileReader("src\\main\\resources\\question.csv"), ';', '"', 1);
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            String[] string = Arrays.toString(nextLine).replaceAll("[\\[\\]]", "").split(",");
            questionAndAnswer.put(string[0].trim(), string[1].trim());
        }
        return questionAndAnswer;
    }
}
