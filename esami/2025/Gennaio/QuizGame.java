import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class QuizGame {
    public ArrayList<Question> questions;
    public int totalScore;

    public QuizGame() {
        questions = new ArrayList<Question>();
        totalScore = 0;
    }

    private void loadQuestions(String filePath) {
        try (// Load questions from a file
                BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skip the header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\",\"");
                int iD = Integer.parseInt(parts[0].replace("\"", ""));
                String questionText = parts[2].replace("\"", "");
                if (parts[1].replace("\"", "").equalsIgnoreCase("MC")) {
                    // Multiple choice question
                    Map<String, Integer> answers = new LinkedHashMap<String, Integer>();// LinkedHashMap to maintain the
                                                                                        // order of insertion
                    char letter = 'a';
                    char correctAnswer = parts[7].replace("\"", "").charAt(0);
                    int value = Integer.parseInt(parts[8].replace("\"", ""));
                    for (int i = 3; i < 7; i++) {
                        answers.put(letter + "." + parts[i].replace("\"", ""), correctAnswer == letter ? value : 0);
                        letter++;
                    }

                    MultipleChoiceQuestion question = new MultipleChoiceQuestion(iD, questionText, answers);
                    questions.add(question);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void startGame(String filePath) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the quiz game!");
        System.out.println("Loading questions...");
        loadQuestions(filePath);
        System.out.println("Questions loaded successfully!");
        System.out.println("-----------------------------");
        for (Question question : questions) {
            question.displayQuestion();
            System.out.println("Enter your answer: ");
            String choice = scanner.next();
            String answer="";
            for (Map.Entry<String, Integer> entry : question.answers.entrySet()) {
                if (entry.getKey().toLowerCase().startsWith(choice.toLowerCase())) {
                    answer = entry.getKey();
                    break;
                }
            }
            if (answer.isEmpty()) {
                System.out.println("Invalid answer. Skipping question...");
                continue;
            } else if (question.evaluateAnswer(answer)) {
                totalScore += question.getScore(answer);
            }
        }
        scanner.close();
    }

    public int diplayScore() {
        return totalScore;
    }
}
