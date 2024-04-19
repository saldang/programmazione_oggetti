import java.util.*;

public class PiccoloGrandeMedia {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		int valore;
		double media = 0; // Non dimenticare di inizializzare somma a 0
		int conteggio = 0; // Analogamente inizializzare conteggio prima di entrare nel ciclo

		System.out.println("Questo programma permette di inserire una lista di interi positivi."
				+ "Si termina l'immissione con -1. Quindi il programma mostra "
				+ "il valore piu' grande, il piu' piccolo e la media della lista non "
				+ " includendo il valore negativo.");
		System.out.println(""); // Svuota la riga per una maggiore leggibilita'

		System.out.println("Inserisci un intero positivo o -1 per uscire.");
		valore = tastiera.nextInt(); // inserisce il primo valore

		int valorePiuGrande = valore; // inizializza le variabili al primo valore isnserito
		int valorePiuPiccolo = valore;

		while (valore >= 0) {
			media = media + valore; // mantiene il valore corrente di somma
			conteggio++; // mantiene traccia di quanti valori positivi sono stati inseriti

			if (valore > valorePiuGrande)
				valorePiuGrande = valore; // il nuovo numero e' piu' grande

			else if (valore < valorePiuPiccolo)
				valorePiuPiccolo = valore; // il nuovo numero e' piu' piccolo

			System.out.println("Inserisci un intero positivo o -1 per uscire.");
			valore = tastiera.nextInt();
		}

		if (conteggio > 0) {
			System.out.println("Per i " + conteggio + " numeri che hai inserito");
			System.out.println("il piu' grande e' = " + valorePiuGrande);
			System.out.println("il piu' piccolo e' = " + valorePiuPiccolo);
			System.out.println("e la media e' = " + media / conteggio);
		} else
			System.out.println("Non hai inserito alcun intero positivo.");
	}
}
