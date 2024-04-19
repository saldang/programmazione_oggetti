import java.util.Scanner;

/**
 * Scrivere un programma in una classe ConteggioFiori che calcoli il prezzo di
 * vendita di mazzi di fiori.
 * Ci sono cinque tipi di fiori (petunie, viole del pensiero, rose, violette e
 * garofani) che vengono venduti, rispettivamente, a € 0.50, € 0.75, € 1.50, €
 * 0.50 e € 0.80 per fiore.
 * Creare un array di stringhe che memorizzi il nome di questi fiori.
 * Creare un altro array che memorizzi i prezzi per ogni tipo di fiore.
 * Il programma dovrebbe leggere il nome del fiore e la quantità desiderata dal
 * cliente.
 * Localizzare il nome del fiore nell’array e utilizzare l’indice per trovare il
 * suo prezzo nell’array dei prezzi.
 * Calcolare e visualizzare il prezzo totale del mazzo di fiori.
 */
public class Domanda3Soluzione {

    public static void main(String[] args) {
        String[] fiori = { "petunie", "viole del pensiero", "rose", "violette", "garofani" };
        double[] prezzi = { 0.50, 0.75, 1.50, 0.50, 0.80 };
        double prezzoTotale = 0;
        int quantita = 0;
        String fiore = "";
        boolean trovato = false;
        Scanner tastiera = new Scanner(System.in);
        for (int i = 0; i < fiori.length; i++) {
            System.out.println(fiori[i] + " " + prezzi[i]);
        }
        System.out.println("Inserisci il nome del fiore");
        fiore = tastiera.nextLine();
        System.out.println("Inserisci la quantità");
        quantita = tastiera.nextInt();
        for (int i = 0; i < fiori.length; i++) {
            if (fiore.equals(fiori[i])) {
                trovato = true;
                prezzoTotale = prezzi[i] * quantita;
            }
        }
        if (trovato) {
            System.out.println("Il prezzo totale è " + prezzoTotale);
        } else {
            System.out.println("Fiore non trovato");
        }
        tastiera.close();
    }

}
