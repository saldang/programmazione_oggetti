import java.util.Scanner;

/**
 * Scrivere un programma in una classe FrequenzaCarattere che conti il numero di volte che una cifra appare in un numero telefonico. 
 * Il programma deve creare un array di dimensione 10 che memorizzerà il conto di ogni cifra da 0 a 9.
 * Leggere da tastiera un numero di telefono come stringa. 
 * Esaminare ogni carattere del numero telefonico e incrementare il conteggio relativo alla cifra nell’array. 
 * Visualizzare il contenuto dell’array.
 */
public class Domanda4Soluzione {
    public static void main(String[] args) {
        int[] frequenza = new int[10];
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Inserisci il numero di telefono");
        String numero = tastiera.nextLine();
        tastiera.close();

        for (int i = 0; i < numero.length(); i++) {
            int cifra = Integer.parseInt(numero.substring(i, i + 1));
            frequenza[cifra]++;
        }
        for (int i = 0; i < frequenza.length; i++) {
            System.out.println(i + " " + frequenza[i]);
        }
    }
    
}
