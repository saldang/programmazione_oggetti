/**
 * Scrivere un programma in una classe ContaFamiglie che conti il numero di famiglie il cui reddito è al di sotto di un certo valore. 
 * Leggere un intero k da tastiera e, in seguito, creare un array di valori double di dimensione k. 
 * Leggere dalla tastiera k valori che rappresentano i redditi delle famiglie e memorizzarli nell’array. 
 * Trovare il più elevato tra questi redditi. Poi contare le famiglie il cui reddito è inferiore fino al 10% rispetto al reddito massimo.
 *  Visualizzare questo conteggio e i redditi di queste famiglie.
 */

import java.util.Scanner;

public class Domanda2Soluzione {

    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Inserire il numero di famiglie:");
        int k = tastiera.nextInt();
        double[] redditi = new double[k];
        System.out.println("Inserire i redditi delle famiglie:");
        for (int i = 0; i < redditi.length; i++) {
            redditi[i] = tastiera.nextDouble();
        }
        double max = redditi[0];
        for (int i = 1; i < redditi.length; i++) {
            if (redditi[i] > max) {
                max = redditi[i];
            }
        }
        int contatore = 0;
        for (int i = 0; i < redditi.length; i++) {
            if (redditi[i] < max * 0.1) {
                contatore++;
            }
        }
        System.out.println("Il numero di famiglie con reddito inferiore al 10% del reddito massimo è " + contatore);
        System.out.println("I redditi di queste famiglie sono:");
        for (int i = 0; i < redditi.length; i++) {
            if (redditi[i] < max * 0.1) {
                System.out.println(redditi[i]);
            }
        }
        tastiera.close();
    }
    
}
