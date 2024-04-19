
/**
 File name: DisplaySentenceTextFile.java

 Una classe che mostra il contenuto di un file che contiene frasi (linee di testo).
 E' una classe di supporto per ScriviFraseFileDiTesto e EditaFraseFileDiTesto
  */
import java.io.*;
import java.util.*;

public class MostraFraseFileDiTesto {
	private BufferedReader inputStream = null;

	/**
	 * Ottiene dall'utente il nome di un file e mostra il suo contenuto.
	 * Assume che il file contenga almeno una linea
	 */
	public static void main(String[] args) {
		String nomeFile = null;
		nomeFile = getNomeFile("Inserisci il nome del file di input: ");
		MostraFraseFileDiTesto mostra = new MostraFraseFileDiTesto();
		mostra.connettiFileInput(nomeFile);
		mostra.mostraLineeDiTesto(nomeFile);
		mostra.chiudiFile(nomeFile);
	}

	private static String getNomeFile(String prompt) {
		Scanner tastiera = new Scanner(System.in);
		String nomeFile = null;
		System.out.println(prompt);
		nomeFile = tastiera.next();

		return nomeFile;
	}

	public void connettiFileInput(String nomeFile) {
		try {
			inputStream = new BufferedReader(new FileReader(nomeFile));
		} catch (FileNotFoundException e) {
			System.out.println("Il file " + nomeFile + " non e' stato trovato");
			System.out.println(", oppure non puo' essere aperto.");
			System.exit(0);
		}
	}

	public void mostraLineeDiTesto(String nomeFile) {
		System.out.println("Il contenuto del file e' il seguente: ");
		try {
			String linea = inputStream.readLine();
			while (linea != null) { // Stop quando non ci sono piu' linee
				System.out.println(linea);
				linea = inputStream.readLine();
			}
		} catch (IOException e) {
			System.out.println("Errore nel leggere il file " + nomeFile);
			System.exit(0);
		}
	}

	public void chiudiFile(String nomeFile) {
		try {
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Errore nel chiudere il file  " + nomeFile);
			System.exit(0);
		}
	}
}
