
/**
 Crea iun file di testo e mostra il contenuto dopo limmissione di dati.
 e' una classe di supporto per EditaFraseFileDiTesto.

 */
import java.io.*;
import java.util.*;

public class ScriviFraseFileDiTesto {
	private PrintWriter outputStream = null;
	private BufferedReader inputStream = null;

	/**
	 * Ottiene dall'utente il nome di un file e riempie il file con linee di testo
	 * immesse dall'utente
	 */
	public static void main(String[] args) {
		String nomeFile = null;
		nomeFile = getNomeFile("Immetti il nome di un file su cui memorizzare le linee di testo.");
		ScriviFraseFileDiTesto scrivi = new ScriviFraseFileDiTesto();
		scrivi.connettiFileOutput(nomeFile);
		scrivi.immettiLineeDiTesto(nomeFile);

		// Verifica i dati immessi
		scrivi.connettiFileInput(nomeFile);
		scrivi.mostraLineeDiTesto(nomeFile);
		scrivi.chiudiFileInput(nomeFile);
	}

	private static String getNomeFile(String prompt) {
		Scanner tastiera = new Scanner(System.in);
		String nomeFile = null;
		System.out.println(prompt);
		nomeFile = tastiera.next();

		return nomeFile;
	}

	private void connettiFileOutput(String nameOfFile) {
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
		} catch (IOException e) {
			System.out.println("Errore nell'aprire il file di input " + nomeFile);
			System.exit(0);
		}
	}

	private void immettiLineeDiTesto(String nomeFile) {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Inserisci le frasi (linee di testo):");
		String linea = null;
		char risposta = 's'; // valore iniziale per entrare nel ciclo almeno una volta
		while ((risposta == 's') || (risposta == 'S')) {
			tastiera = new Scanner(System.in);
			linea = tastiera.nextLine();
			outputStream.println(linea);
			System.out.println("Vuoi inserire un'altra linea? (s/n)");
			risposta = tastiera.next().charAt(0);
		}
		System.out.println("Le seguenti linee sono state scritte sul file " + nomeFile);
		outputStream.close();
	}

	public void mostraLineeDiTesto(String nomeFile) {
		try {
			String linea = inputStream.readLine();
			while (linea != null) { // Stop alla fine del file
				System.out.println(linea);
				linea = inputStream.readLine();
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
