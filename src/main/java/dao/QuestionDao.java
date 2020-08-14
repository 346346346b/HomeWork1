package dao;

import java.io.IOException;
import java.util.TreeMap;

public interface QuestionDao {
    TreeMap readQuestions() throws IOException;
}
