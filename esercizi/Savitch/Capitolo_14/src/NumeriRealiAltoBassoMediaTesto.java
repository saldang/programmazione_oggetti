import java.util.*;
import java.io.*;

public class NumeriRealiAltoBassoMediaTesto {
	private BufferedReader inputStream = null;

	/**
	 * Mostra il valore piu' piccolo, il piu' grande e la media tra i valori in un file specificato dall'utente
	 */
	public static void main(String[] args) {
		String nomeFile = null;
		nomeFile = getNomeFile("Immetti il nome del file di input: ");
		NumeriRealiAltoBassoMediaTesto realTextFile = new NumeriRealiAltoBassoMediaTesto();
		realTextFile.connettiFileInput(nomeFile);
		realTextFile.altoBAssoMedia(nomeFile);
		realTextFile.chiudiFile(nomeFile);
	}

	public void connettiFileInput(String nameOfFile) {
		try {
			inputStream = new BufferedReader(new FileReader(nameOfFile));
		} catch (FileNotFoundException e) {
			System.out.println("File " + nameOfFile + " non trovato.");
			System.exit(0);
		}
	}

	private static String getNomeFile(String prompt) {
		Scanner tastiera = new Scanner(System.in);
		String fileName = null;
		System.out.println(prompt);
		fileName = tastiera.next();

		return fileName;
	}

	public void altoBAssoMedia(String nomeFile) {
		double piuGrande = -9999; //Per fare il compilatore felice ;-)
		double piuPiccolo = 9999; //Per fare il compilatore felice ;-)
		double somma = 0; // Media = somma / conteggio
		int conteggio = 0;

		try {
			// Assume almeno un valore nel file
			// Inizializza il piu' grande e il piu' piccolo al primo valore quindi
			// poi li cambia nel momento in cui vengono travati valori piu' grandi e piu' piccoliì
			String nextLine = inputStream.readLine();
			double next = Double.parseDouble(nextLine);

			piuPiccolo = next;
			piuGrande = next;
			somma = next;
			++conteggio;

			// Elabora i numeri rimanenti fino alla fine del file
			nextLine = inputStream.readLine();
			while (nextLine != null)  { //esce alla fine del file
				next = Double.parseDouble(nextLine);
				if (next > piuGrande)
					piuGrande = next;
				if (next < piuPiccolo)
					piuPiccolo = next;

				somma += next; 
				++conteggio; 
				nextLine = inputStream.readLine();
			}
			System.out.println("Piu' grande = " + piuGrande);
			System.out.println("Piu' piccolo = " + piuPiccolo);
			System.out.println("Media = " + somma / conteggio);
		} catch (IOException e) {
			System.out.println("Errore nel leggere il file " + nomeFile);
			System.exit(0);
		}
	}

	public void chiudiFile(String nomeFile) {
		try {
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Errore nel chiudere il file " + nomeFile);
			System.exit(0);
		}
	}
}
