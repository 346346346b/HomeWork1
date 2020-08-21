package ru.gorovoi.dao;

import java.io.IOException;
import java.util.TreeMap;

public interface QuestionDao {
    TreeMap<String,String> readQuestions() throws IOException;
}
