import java.util.*;
import java.io.*;

public class ScriviNumeriRealiFileDiTesto {
	private PrintWriter outputStream = null;
	private BufferedReader inputStream = null;

	/**
	 * Ottiene un nome di file dall'utente e riempie il file con numeri reali (tipo
	 * double) inseriti dall'utente. I duplicati sono ammessi
	 */
	public static void main(String[] args) {
		String nomeFile = null;
		nomeFile = getNomeFile("Inserisci il nome di file di output: ");
		ScriviNumeriRealiFileDiTesto realNumberTextFile = new ScriviNumeriRealiFileDiTesto();
		realNumberTextFile.connettiFileOutput(nomeFile);
		realNumberTextFile.inserisciNumeri(nomeFile);

		// Verifica i dati inseriti
		realNumberTextFile.connettiFileInput(nomeFile);
		realNumberTextFile.mostarNumeri(nomeFile);
		realNumberTextFile.chiudiFileInput(nomeFile);
	}

	private static String getNomeFile(String prompt) {
		Scanner tastiera = new Scanner(System.in);
		String nomeFile = null;
		System.out.println(prompt);
		nomeFile = tastiera.next();
		return nomeFile;
	}

	public void connettiFileOutput(String nomeFile) {
		try {
			outputStream = new PrintWriter(new FileOutputStream(nomeFile));
		} catch (IOException e) {
			System.out.println("Errore nell'aprire il file di output " + nomeFile);
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

	public void inserisciNumeri(String nomeFile) {
		Scanner tastiera = null;
		System.out.println("Inserisci un numero reale da inserire nel file");

		String numero;
		char risposta = 's';  // Valore iniziale per entrare nel loop

		while ((risposta == 'S') || (risposta == 'S')) {
			tastiera = new Scanner(System.in);
			System.out.println("Inserisci un numero reale: ");
			numero = tastiera.nextLine();
			outputStream.println(numero);

			System.out.println("Inserisci un altro intero?(s/n)");
			risposta = tastiera.next().charAt(0);
		}
		outputStream.close();
	}

	public void mostarNumeri(String nomeFile) {
		System.out.println("I numeri nel file sono: ");
		try {
			String line = inputStream.readLine();
			while (line != null) { // Stop alla fine del file
				System.out.println(line);
				line = inputStream.readLine();
			}
		} catch (IOException e) {
			System.out.println("Errore nel leggere il file " + nomeFile);
			System.exit(0);
		}
	}

	public void chiudiFileInput(String nomeFile) {
		try {
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Errore nel chiudere il file " + nomeFile);
			System.exit(0);
		}
	}
}
