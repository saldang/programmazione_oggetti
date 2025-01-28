import java.util.Map;

public class Question implements Scorable {

    public int iD;
    public String questionText;
    public Map<String, Integer> answers;

    public Question(int iD, String questionText, Map<String, Integer> answers) {
        this.iD = iD;
        this.questionText = questionText;
        this.answers = answers;
    }

    public void displayQuestion() {
        System.out.println(iD + ". " + questionText);
        for (Map.Entry<String, Integer> entry : answers.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

    public boolean evaluateAnswer(String answer) {
        if (answers.get(answer) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int getScore(String answer) {
        return answers.get(answer);
    }

}