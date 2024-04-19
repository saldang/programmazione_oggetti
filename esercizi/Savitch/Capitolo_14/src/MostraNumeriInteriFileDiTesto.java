import java.io.*;
import java.util.*;

public class MostraNumeriInteriFileDiTesto {
	private BufferedReader inputStream = null;

	/**
	 * Ottiene un nome di file dall'utente e riempie il file con numeri interi (tipo
	 * int) inseriti dall'utente. I duplicati sono ammessi
	 */
	public static void main(String[] args) {
		String nomeFile = null;
		nomeFile = getNomeFile("Immetti il nome del file di output: ");
		MostraNumeriInteriFileDiTesto integerText = new MostraNumeriInteriFileDiTesto();
		integerText.connetiFileInput(nomeFile);
		integerText.mostraNumeri(nomeFile);
		integerText.chiudiFile(nomeFile);
	}

	private static String getNomeFile(String prompt) {
		Scanner tastiera = new Scanner(System.in);
		String nomeFile = null;
		System.out.println(prompt);
		nomeFile = tastiera.next();

		return nomeFile;
	}

	public void connetiFileInput(String nomeFile) {
		try {
			inputStream = new BufferedReader(new FileReader(nomeFile));
		} catch (FileNotFoundException e) {
			System.out.println("Il file " + nomeFile + " non e' stato trovato.");
			System.out.println("o non puo' essere aperto.");
			System.exit(0);
		}
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

	public void chiudiFile(String nomeFile) {
		try {
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Errore nel chiudere il file " + nomeFile);
			System.exit(0);
		}
	}
}
