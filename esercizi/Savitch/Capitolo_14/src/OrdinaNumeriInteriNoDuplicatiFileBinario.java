import java.io.*;
import java.util.*;

public class OrdinaNumeriInteriNoDuplicatiFileBinario {
	private ObjectInputStream inputStream = null;
	private ObjectOutputStream outputStream = null;

	/**
	 * Copia i numeri interi ordinati in un file binario che può avere duplicati in
	 * un altro file binario, ma rimuove i duplicati. I valori nel file risultanti
	 * rimangono ordinati.
	 */
	public static void main(String[] args) {
		OrdinaNumeriInteriNoDuplicatiFileBinario noDuplicati = new OrdinaNumeriInteriNoDuplicatiFileBinario();
		noDuplicati.connettiInputFile();
		noDuplicati.connettiOutputFile();
		noDuplicati.copiaSenzaDuplicati();
		noDuplicati.chiudiFile();
		System.out.println("I numeri nel file di input sono copiati nel file di output e i duplicati rimossi");
	}

	public void connettiOutputFile() {
		String outputFileName = getNomeFile("Inserisci il nome di un file di output:");
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(outputFileName));
		} catch (IOException e) {
			System.out.println("Errore nell'aprire il file " + outputFileName);
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	public void connettiInputFile() {
		String inputFileName = getNomeFile("Inserisci il nome di un file di input:");
		try {
			inputStream = new ObjectInputStream(new FileInputStream(inputFileName));
		} catch (FileNotFoundException e) {
			System.out.println("Il file " + inputFileName + " non e' stato trovato.");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Errore nell'aprire il file " + inputFileName);
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	private String getNomeFile(String prompt) {
		Scanner tastiera = new Scanner(System.in);
		String nomeFile = null;
		System.out.println(prompt);
		nomeFile = tastiera.next();

		return nomeFile;
	}

	public void copiaSenzaDuplicati() {
		int intPrecedente;
		int intNuovo;
		try {
			// Assume che il file abbia almeno un numero e che gli interi siano in ordine ascendente
			intPrecedente = inputStream.readInt();
			outputStream.writeInt(intPrecedente);

			// Per i valori rimanenti, copia solo se intNuovo > intPrecedente (questo elimina i duplicati)
			while (true) { // Esce alla fine del file
				intNuovo = inputStream.readInt();
				if (intNuovo > intPrecedente) {
					outputStream.writeInt(intNuovo);
					intPrecedente = intNuovo;
				}
			}
		} catch (EOFException e)  {
			// Non fa nulla, semplicemente esce dal loop
		} catch (IOException e1) {
			System.out.println("Errore nel leggere o scrivere i files.");
			System.out.println(e1.getMessage());
			System.exit(0);
		}
	}

	public void chiudiFile() {
		try {
			inputStream.close();
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Errore nel chiudere i file " + e.getMessage());
			System.exit(0);
		}
	}
}
