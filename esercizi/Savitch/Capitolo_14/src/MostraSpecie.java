
/**
 Visualizza il contenuto di file binari che contengono specie */
import java.io.*;
import java.util.*;

public class MostraSpecie {
	public static void main(String[] args) {
		String nomeFile = getNomeFile("Inserisci il nome del file di input.");
		ObjectInputStream inputStream = null;

		try {
			inputStream = new ObjectInputStream(new FileInputStream(nomeFile));
		} catch (IOException e) {
			System.out.println("Errore nell'aprire il file in lettura " + nomeFile);
			System.exit(0);
		}

		Specie specie = null;
		try {
			while (true) { // Esci alla fine del file
				specie = (Specie) inputStream.readObject();
				System.out.println(specie);
			}
		} catch (EOFException e) {
			System.out.println("Fine del programma.");
		} catch (Exception e) {
			System.out.println("Errore nel leggere il file di input " + nomeFile);
			System.exit(0);
		}
		try {
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Error closing input file " + nomeFile);
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
