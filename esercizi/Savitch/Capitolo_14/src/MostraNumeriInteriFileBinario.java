import java.io.*;
import java.util.*;

public class MostraNumeriInteriFileBinario {
	private ObjectInputStream inputStream = null;

	/**
	 * Ottiene un nome di file dall'utente e riempie il file con numeri interi (tipo
	 * int) inseriti dall'utente. I duplicati sono ammessi
	 */
	public static void main(String[] args) {
		String nomeFile = null;
		nomeFile = getNomeFile("Immetti il nome del file di output: ");
		MostraNumeriInteriFileBinario integerBinary = new MostraNumeriInteriFileBinario();
		integerBinary.connettiFileInput(nomeFile);
		integerBinary.mostraNumeri(nomeFile);
		integerBinary.chiudiFileInput(nomeFile);
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
			inputStream = new ObjectInputStream(new FileInputStream(nomeFile));
		} catch (FileNotFoundException e) {
			System.out.println("Il file " + nomeFile + " non e' stato trovato.");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Errore nell'aprire il file di input " + nomeFile);
			System.exit(0);
		}
	}

	public void mostraNumeri(String nomeFile) {
		System.out.println("I numeri nel file sono: ");
		try {
			while (true) { // Stop at EOF
				System.out.println(inputStream.readInt());
			}
		} catch (EOFException e) {
			System.out.println("Fine dei dati.");
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
