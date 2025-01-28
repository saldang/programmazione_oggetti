public class Main {
    public static void main(String[] args) {
        QuizGame game = new QuizGame();
        String filePath = "./quiz.csv";
        game.startGame(filePath);
        System.out.println("Your total score is: " + game.diplayScore());
    }
}
