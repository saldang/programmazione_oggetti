// Scrivere un programma in una classe NumeriSottoLaMedia che conti il numero di giorni in cui la temperatura è al di sotto della media. 
//Leggere 10 temperature da tastiera e memorizzarle in un array.
// Calcolare la temperatura media e contare e visualizzare il numero di giorni in cui la temperatura è al di sotto della media.

import java.util.Scanner;

public class Domanda1Soluzione {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Inserire il numero di giorni:");
        int k = tastiera.nextInt();
        double[] temperature = new double[k];
        System.out.println("Inserire le temperature:");
        for (int i = 0; i < temperature.length; i++) {
            temperature[i] = tastiera.nextDouble();
        }
        double somma = 0;
        for (int i = 0; i < temperature.length; i++) {
            somma += temperature[i];
        }
        double media = somma / temperature.length;
        int contatore = 0;
        for (int i = 0; i < temperature.length; i++) {
            if (temperature[i] < media) {
                contatore++;
            }
        }
        System.out.println("Il numero di giorni in cui la temperatura è al di sotto della media è " + contatore);
        tastiera.close();
    }
}
