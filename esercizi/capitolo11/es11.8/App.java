import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner tastira = new Scanner(System.in);
        Organismo[][] mondo = new Organismo[20][20];
        for (int i = 0; i < 5; i++) {
            mondo[rand.nextInt(0, 20)][rand.nextInt(0, 20)] = new Predatore();
        }
        for (int i = 0; i < 100; i++) {
            int x = rand.nextInt(0, 20);
            int y = rand.nextInt(0, 20);
            if (mondo[x][y] == null)
                mondo[x][y] = new Preda();
        }

        for (int i = 0; i < mondo.length; i++) {
            for (int j = 0; j < mondo[i].length; j++) {
                System.out.print(mondo[i][j] + "|");
            }
            System.out.println();
        }
    }
}
