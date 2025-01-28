import java.util.Map;

public class MultipleChoiceQuestion extends Question {
    public MultipleChoiceQuestion(int iD, String questionText, Map<String, Integer> answers) {
        super(iD, questionText, answers);
    }

    @Override
    public void displayQuestion() {
        System.out.println(questionText);
        for (Map.Entry<String, Integer> entry : answers.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

}
