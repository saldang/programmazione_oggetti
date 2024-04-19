import java.io.*;
import java.util.*;

public class OrdinaNumeriInteriNoDuplicatiFileDiTesto {
	private BufferedReader inputStream = null;
	private PrintWriter outputStream = null;

	/**
	 * Copia i numeri interi ordinati in un file di testo che può avere duplicati in
	 * un altro file binario, ma rimuove i duplicati. I valori nel file risultanti
	 * rimangono ordinati.
	 */
	public static void main(String[] args) {
		OrdinaNumeriInteriNoDuplicatiFileDiTesto noDuplicati = new OrdinaNumeriInteriNoDuplicatiFileDiTesto();
		noDuplicati.connettiInputFile();
		noDuplicati.connettiOutputFile();
		noDuplicati.copiaSenzaDuplicati();
		noDuplicati.chiudiFile();
		System.out.println("I numeri nel file di input sono copiati nel file di output e i duplicati rimossi");
	}

	public void connettiOutputFile() {
		String outputFileName = getNomeFile("Inserisci il nome di un file di output:");
		try {
			outputStream = new PrintWriter(new FileOutputStream(outputFileName));
		} catch (FileNotFoundException e) {
			System.out.println("Errore nell'aprire il file" + outputFileName);
			System.exit(0);
		}
	}

	public void connettiInputFile() {
		String inputFileName = getNomeFile("Inserisci il nome di un file di input:");
		try {
			inputStream = new BufferedReader(new FileReader(inputFileName));
		} catch (FileNotFoundException e) {
			System.out.println("Errore nell'aprire il file " + inputFileName);
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
		String numeroIntString;
		int intPrecedente;
		int intNuovo;
		try {
			// Assume che il file abbia almeno un numero e che gli interi siano in ordine ascendente

			numeroIntString = inputStream.readLine();
			intPrecedente = Integer.parseInt(numeroIntString);
			outputStream.println(intPrecedente);
			numeroIntString = inputStream.readLine();

			// Per i valori rimanenti, copia solo se intNuovo > intPrecedente (questo elimina i duplicati)
			while (numeroIntString != null) { // Esce quando non ci sono piu' dati
				numeroIntString = numeroIntString.trim();
				intNuovo = Integer.parseInt(numeroIntString);
				if (intNuovo > intPrecedente) {
					outputStream.println(intNuovo);
					intPrecedente = intNuovo;
				}
				numeroIntString = inputStream.readLine();
			}
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
