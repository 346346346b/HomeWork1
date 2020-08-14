package service;

public class QuestionServiceImpl implements QuestionService {
    private final InformationStreamService info;

    public QuestionServiceImpl(InformationStreamService info) {
        this.info = info;
    }

    @Override
    public int askQuestion(String question, String answer) {
        info.output("Вопрос: " + question + "\nВведите в консоль ответ на вопрос");
        if (info.input().equals(answer)) {
            info.output("Ответ верный");
            return 1;
        } else {
            info.output("Ответ не верный. " + " Верный ответ" + answer);
            return 0;
        }
    }
}
