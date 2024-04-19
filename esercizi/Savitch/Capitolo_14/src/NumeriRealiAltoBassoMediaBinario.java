import java.util.*;
import java.io.*;

public class NumeriRealiAltoBassoMediaBinario {
	private ObjectInputStream inputStream = null;

	/**
	 * Mostra il valore piu' piccolo, il piu' grande e la media tra i valori in un
	 * file specificato dall'utente
	 */
	public static void main(String[] args) {
		NumeriRealiAltoBassoMediaBinario realBinaryFile = new NumeriRealiAltoBassoMediaBinario();
		realBinaryFile.connettiFileInput();
		realBinaryFile.altoBassoMedia();
		realBinaryFile.chiudiFile();
	}

	public void connettiFileInput() {
		String inputFileName = getNomeFile("Immetti il nome del file di input:");

		try {
			inputStream = new ObjectInputStream(new FileInputStream(inputFileName));
		}

		catch (FileNotFoundException e) {
			System.out.println("File " + inputFileName + " not found.");
			System.exit(0);
		}

		catch (IOException e) {
			System.out.println("Error opening input file" + inputFileName);
			System.exit(0);
		}
	}

	private String getNomeFile(String prompt) {
		Scanner keyboard = new Scanner(System.in);
		String fileName = null;
		System.out.println(prompt);
		fileName = keyboard.next();

		return fileName;
	}

	public void altoBassoMedia() {
		double piuGrande = -9999; // Per fare il compilatore felice ;-)
		double piuPiccolo = 9999; // Per fare il compilatore felice ;-)
		double somma = 0; // Media = somma / conteggio
		int conteggio = 0;

		try {
			// Assume almeno un valore nel file
			// Inizializza il piu' grande e il piu' piccolo al primo valore quindi
			// poi li cambia nel momento in cui vengono travati valori piu' grandi e piu'
			// piccoliì
			double next = inputStream.readDouble();

			piuPiccolo = next;
			piuGrande = next;
			somma = next;
			++conteggio;

			// Elabora i numeri rimanenti fino alla fine del file
			while (true) { // Esce su eccezione EOF
				next = inputStream.readDouble();
				if (next > piuGrande)
					piuGrande = next;
				if (next < piuPiccolo)
					piuPiccolo = next;
				somma += next;
				++conteggio;
			}
		} catch (EOFException e) {
			System.out.println("Piu' grande = " + piuGrande);
			System.out.println("Piu' piccolo = " + piuPiccolo);
			System.out.println("Media = " + somma / conteggio);
		}

		catch (IOException e) {
			System.out.println("Error reading file " + e.getMessage());
			System.exit(0);
		}
	}

	public void chiudiFile() {
		try {
			inputStream.close();
		}

		catch (IOException e) {
			System.out.println("Errore nel chiudere il file " + e.getMessage());
			System.exit(0);
		}
	}
}
