
/**
 La classe cerca all'interno di un file la specie richiesta
 */
import java.io.*;
import java.util.*;

public class TrovaSpecie {
	public static void main(String[] args) {
		String nomeFile = getNomeFile("Inserisci il nome della specie da cercare.");
		ObjectInputStream inputStream = null;
		String nomeSpecie = null;
		Specie specie = new Specie();
		char ripete; 
		Scanner tastiera = new Scanner(System.in);

		do {
			// Occorre riaprire il file ogni volta al fine da far si che si punti sempre al primo elemento
			try {
				inputStream = new ObjectInputStream(new FileInputStream(nomeFile));
			} catch (IOException e) {
				System.out.println("Errore nell'aprire il file di input " + nomeFile);
				System.exit(0);
			}

			// Nome della specie da cercare
			System.out.println();
			System.out.println("Quale specie vuoi cercare?");
			tastiera = new Scanner(System.in);
			nomeSpecie = tastiera.nextLine();

			boolean fatto = false; // Per entrare nel ciclo la prima volta
			try {
				while (!fatto) {
					specie = (Specie) inputStream.readObject();
					if (specie.getNome().equals(nomeSpecie)) {
						System.out.println("Specie " + nomeSpecie + " trovata!");
						System.out.println(specie);
						fatto = true;
					}
				}
			} catch (EOFException e) {
				System.out.println("Specie " + nomeSpecie + " NON trovata nel file" + nomeFile);
			} catch (Exception e) {
				System.out.println("Errore nel leggere dal file" + nomeFile);
				System.exit(0);
			}

			// Chiude il file cosi' che il puntatore venga riportato all'iniziodel file
			// nel caso si voglia fare una nuova ricerca di una specie diversa
			try {
				inputStream.close();
			} catch (IOException e) {
				System.out.println("Errore nel chiudere il file" + nomeFile);
				System.exit(0);
			}
			System.out.println();
			System.out.println("Cerchi un'altra specie? (s per si)");
			ripete = tastiera.next().charAt(0);

		} while (ripete == 's' || ripete == 'S');

		System.out.println("Fine del programma.");
	}

	private static String getNomeFile(String prompt) {
		Scanner tastiera = new Scanner(System.in);
		String nomeFile = null;
		System.out.println(prompt);
		nomeFile = tastiera.next();

		return nomeFile;
	}
}
