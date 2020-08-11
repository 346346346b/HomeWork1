package dao;

import liquibase.util.csv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ReadQuestionsCSV implements ReadQuestions {
    @SuppressWarnings("resource")
    public Map readQuestions() throws IOException {
            Map<String, String> questionAndAnswer = new TreeMap<>();
            CSVReader reader = new CSVReader(new FileReader("question.csv"), ',', '"', 1);
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine != null) {
                    System.out.println(Arrays.toString(nextLine));
                    String[] string = Arrays.toString(nextLine).substring(1).replaceAll("]", "").split(";");
                    questionAndAnswer.put(string[0], string[1]);
                }
            }
            return questionAndAnswer;
    }
}