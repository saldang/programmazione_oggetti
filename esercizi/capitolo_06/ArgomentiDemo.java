import java.util.Scanner;

/**
 * Utilizzo di variabili indicizzte.
 */
public class ArgomentiDemo {

    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Inserire il voto dell'esame 1:");
        int punteggioIniziale = tastiera.nextInt();
        int[] punteggioSeguente = new int[3];

        for (int i = 0; i < punteggioSeguente.length; i++)
            punteggioSeguente[i] = punteggioIniziale + 5 * i;

        for (int i = 0; i < punteggioSeguente.length; i++) {
            double possibileMedia = getMedia(punteggioIniziale, punteggioSeguente[i]);
            System.out.println("Se il voto all'esame 2 sara' " + punteggioSeguente[i]);
            System.out.println("la media sara' uguale a " + possibileMedia);
        }
        tastiera.close();
    }

    public static double getMedia(int n1, int n2) {
        return (n1 + n2) / 2.0;
    }
}
