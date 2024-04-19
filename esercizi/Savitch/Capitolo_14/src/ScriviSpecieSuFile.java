
/**
  Costruisce file binari di Specie.
 E' una classe di servizo per la classe TrovaSpecie.java.

 Nota: dopoa aver scritto su file, mostra i valori inseriti per ciascun record in modo che possano essere verificati */
import java.io.*;
import java.util.*;

public class ScriviSpecieSuFile {
	public static void main(String[] args) {
		ObjectOutputStream outputStream = null;
		ObjectInputStream inputStream = null;
		String nomeFile = getNomeFile("Inserisci il nome del file di output.");
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(nomeFile));
		} catch (IOException e) {
			System.out.println("Errore nell'aprire il file " + nomeFile);
			System.out.println(" in scrittura");
			System.exit(0);
		}

		Scanner tastiera = new Scanner(System.in);
		char risposta = 's'; // Valore iniziale per entrare nel loop la prima volta
		while ((risposta == 's') || (risposta == 'S')) {
			Specie record = new Specie();
			record.leggiInput();
			try {
				outputStream.writeObject(record);
			} catch (IOException e) {
				System.out.println("Errore nello scrivere sul file " + nomeFile);
				System.exit(0);
			}
			System.out.println("Record scritto sul file " + nomeFile);
			System.out.println("\nVuoi inserire un'altra specie? (s/n)");
			risposta = tastiera.next().charAt(0);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Errore nel chiudere il file  " + nomeFile);
			System.exit(0);
		}

		System.out.println("Riapro il file e mostro il contenuto.");

		try {
			inputStream = new ObjectInputStream(new FileInputStream(nomeFile));
		} catch (IOException e) {
			System.out.println("Errore nell'aprire il file in lettura " + nomeFile);
			System.exit(0);
		}

		Specie specie = null;

		try {
			while (true) { // Esce alla fine del file
				specie = (Specie) inputStream.readObject();
				System.out.println(specie);
			}
		} catch (EOFException e)  { 
			System.out.println("Fine del programma.");
		} catch (Exception e) {
			System.out.println("Errore nella lettura del file di inpute " + nomeFile);
			System.exit(0);
		}
		try {
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Errore nel chiudere il file di input " + nomeFile);
			System.exit(0);
		}
	}

	private static String getNomeFile(String prompt) {
		Scanner tastiera = new Scanner(System.in);
		String nomeFile = null;
		System.out.println(prompt);
		nomeFile = tastiera.next();

		return nomeFile;
	}
}
