import java.security.SecureRandom;

import javax.swing.DefaultSingleSelectionModel;

public class Craps {
    private static final SecureRandom random = new SecureRandom();

    private enum Status {
        WIN, CONTINUE, LOST
    };

    private static int punteggio;
    private static final int DUE = 2;
    private static final int TRE = 3;
    private static final int SETTE = 7;
    private static final int UNDICI = 11;
    private static final int DODICI = 12;

    public static void main(String[] args) {
        Status gameStatus;
        punteggio = lanciaDadi();
        switch (punteggio) {
            case DUE:
            case TRE:
            case DODICI:
                gameStatus = Status.LOST;
                break;
            case SETTE:
            case UNDICI:
                gameStatus = Status.WIN;
                break;
            default:
                gameStatus = Status.CONTINUE;
                break;
        }

        while (gameStatus == Status.CONTINUE) {
            System.out.println("Il tuo punteggio e' " + punteggio);
            int score = lanciaDadi();
            if (score == SETTE) {
                gameStatus = Status.LOST;
            } else if (score == punteggio) {
                gameStatus = Status.WIN;
            }
        }

        if (gameStatus == Status.WIN) {
            System.out.println("Hai vinto!");
        } else if (gameStatus == Status.LOST) {
            System.out.println("Hai perso!");
        }

    }

    private static int lanciaDadi() {
        int dado1 = 1 + random.nextInt(6);
        int dado2 = 1 + random.nextInt(6);

        System.out.printf("Lancio: Dado1 - %d Dado2 - %d\n", dado1, dado2);
        System.out.println("Somma lancio:" + (dado1 + dado2));
        return dado1 + dado2;
    }
}
