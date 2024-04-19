
import java.io.*;
import java.util.*;

public class ScriviNumeriInteriFileDiTesto {
	private PrintWriter outputStream = null;
	private BufferedReader inputStream = null;

	/**
	 * Ottiene un nome di file dall'utente e riempie il file con numeri interi (tipo
	 * int) inseriti dall'utente. I duplicati sono ammessi
	 */
	public static void main(String[] args) {
		String nomeFile = null;
		nomeFile = getNomeFile("Immetti il nome del file di output: ");
		ScriviNumeriInteriFileDiTesto integerText = new ScriviNumeriInteriFileDiTesto();
		integerText.connettiFileOutput(nomeFile);
		integerText.inserisciNumeri(nomeFile);

		// Verifica i dati inseriti
		integerText.connettiFileInput(nomeFile);
		integerText.mostraNumeri(nomeFile);
		integerText.chiudiInputFile(nomeFile);
	}

	private static String getNomeFile(String prompt) {
		Scanner tastiera = new Scanner(System.in);
		String nomeFile = null;
		System.out.println(prompt);
		nomeFile = tastiera.next();

		return nomeFile;
	}

	public void connettiFileOutput(String nameOfFile) {
		try {
			outputStream = new PrintWriter(new FileOutputStream(nameOfFile));
		} catch (IOException e) {
			System.out.println("Errore nell'aprire il file di output " + nameOfFile);
			System.exit(0);
		}
	}

	public void connettiFileInput(String nomeFile) {
		try {
			inputStream = new BufferedReader(new FileReader(nomeFile));
		} catch (FileNotFoundException e) {
			System.out.println("Il file " + nomeFile + " non e' stato trovato.");
			System.exit(0);
		}
	}

	public void inserisciNumeri(String nameOfFile) {
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Inserisci gli interi da inserire nel file");

		int numero;
		char risposta = 's'; // Valore iniziale per entrare nel loop
		while ((risposta == 's') || (risposta == 'S')) {
			System.out.println("Inserisci un intero: ");
			numero = tastiera.nextInt();
			outputStream.println(numero);
			System.out.println("Inserisci un altro intero?(s/n)");
			risposta = tastiera.next().charAt(0);
		}
		outputStream.close();
	}

	public void mostraNumeri(String nomeFile) {
		System.out.println("I numeri nel file sono: ");
		try {
			String line = inputStream.readLine();
			while (line != null) { // Stop quando non ci sono piu' linee
				System.out.println(line);
				line = inputStream.readLine();
			}
		} catch (IOException e) {
			System.out.println("Errore nel leggere il file " + nomeFile);
			System.exit(0);
		}
	}

	public void chiudiInputFile(String nomeFile) {
		try {
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Errore nel chiudere il file di input " + nomeFile);
			System.exit(0);
		}
	}
}
