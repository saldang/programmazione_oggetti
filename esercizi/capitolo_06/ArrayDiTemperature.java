/**
Legge I valori di 7 temperature inserite dall�utente e mostra quail di
Queste sono al di sopra e al di sotto della meda delle temperature stesse.
*/
import java.util.Scanner;

public class ArrayDiTemperature {

    public static void main(String[] args) {       
        double[] temperatura = new double[7];

        // Lettura delle temperature e calcolo della loro media:
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Inserire 7 temperature:");
        double somma = 0;

        for (int indice = 0; indice < 7; indice++) {
            temperatura[indice] = tastiera.nextDouble();
            somma = somma + temperatura[indice];
        }

        double media = somma / 7;
        System.out.println("La temperatura media e' " + media);

        // Mostra ogni temperatura e la relazione rispetto alla temperatura media:
        System.out.println("Le 7 temperature sono");
        for (int indice = 0; indice < 7; indice++) {

            if (temperatura[indice] < media)
                System.out.println(temperatura[indice] + " sotto la media");

            else if (temperatura[indice] > media)
                System.out.println(temperatura[indice] + " sopra la media");

            else //temperatura[indice] == media
                System.out.println(temperatura[indice] + " pari alla media");
        }

        System.out.println("Buona settimana.");
        tastiera.close();
    }
}
