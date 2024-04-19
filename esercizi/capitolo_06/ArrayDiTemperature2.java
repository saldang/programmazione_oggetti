
/**
Legge I valori di 7 temperature inserite dall'utente e mostra quail di
Queste sono al di sopra e al di sotto della meda delle temperature stesse.
*/
import java.util.Scanner;

public class ArrayDiTemperature2 {

    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Quante temperature si devono inserire?");
        int dimensione = tastiera.nextInt();
        double[] temperatura = new double[dimensione];

        // Lettura delle temperature e calcolo della loro media:
        System.out.println("Inserire " + temperatura.length + " temperature:");
        double somma = 0;

        for (int indice = 0; indice < temperatura.length; indice++) {
            temperatura[indice] = tastiera.nextDouble();
            somma = somma + temperatura[indice];
        }

        double media = somma / temperatura.length;
        System.out.println("La temperatura media e' " + media);

        // Mostra ogni temperatura e la relazione rispetto alla temperatura media:
        System.out.println("Le " + temperatura.length + " temperature sono");

        for (int indice = 0; indice < temperatura.length; indice++) {
            if (temperatura[indice] < media)
                System.out.println(temperatura[indice] + " sotto la media");
            else if (temperatura[indice] > media)
                System.out.println(temperatura[indice] + " sopra la media");
            else // temperatura[indice] == media
                System.out.println(temperatura[indice] + " pari alla media");
        }
        System.out.println("Buona settimana.");
        tastiera.close();

    }
}