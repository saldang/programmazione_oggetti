import java.util.Scanner;

/**
Esempio di metodo che ritorna un array.
*/
public class RitornoDiArrayDemo {

    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Inserire il voto dell�esame 1:");
        int punteggioIniziale = tastiera.nextInt();
        int[] punteggioSeguente = new int[3];

        for (int i = 0; i < punteggioSeguente.length; i++)
            punteggioSeguente[i] = punteggioIniziale + 5 * i;

        double[] punteggioMedio = ottieniArrayDiMedie(punteggioIniziale, punteggioSeguente);

        for (int i = 0; i < punteggioSeguente.length; i++) {
            System.out.println("Se il voto all'esame 2 sara' " + punteggioSeguente[i]);
            System.out.println("la media sara' uguale a " + punteggioMedio[i]);
        }
        tastiera.close();
    }

    public static double[] ottieniArrayDiMedie(int punteggioIniziale, int[] punteggioSeguente) {
        double[] temp = new double[punteggioSeguente.length];

        for (int i = 0; i < temp.length; i++)
            temp[i] = getMedia(punteggioIniziale, punteggioSeguente[i]);

        return temp;
    }

    public static double getMedia(int n1, int n2) {
        return (n1 + n2) / 2.0;
    }
}
