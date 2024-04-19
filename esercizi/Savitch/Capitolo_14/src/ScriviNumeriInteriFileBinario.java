
import java.io.*;
import java.util.*;

public class ScriviNumeriInteriFileBinario {
	private ObjectOutputStream outputStream = null;
	private ObjectInputStream inputStream = null;

	/**
	 * Ottiene un nome di file dall'utente e riempie il file con numeri interi (tipo
	 * int) inseriti dall'utente. I duplicati sono ammessi
	 */
	public static void main(String[] args) {
		String nomeFile = null;
		nomeFile = getNomeFile("Immetti il nome del file di output: ");
		ScriviNumeriInteriFileBinario integerBinary = new ScriviNumeriInteriFileBinario();
		integerBinary.connettiFileOutput(nomeFile);
		integerBinary.inserisciNumeri(nomeFile);
		integerBinary.chiudiFileDiOutput(nomeFile);

		// Verifica i dati inseriti
		integerBinary.connettiFileInput(nomeFile);
		integerBinary.mostraNumeri(nomeFile);
		integerBinary.chiudiInputFile(nomeFile);
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
			outputStream = new ObjectOutputStream(new FileOutputStream(nomeFile));
		} catch (IOException e) {
			System.out.println("Errore nell'aprire il file di output " + nomeFile);
			System.exit(0);
		}
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

	public void inserisciNumeri(String nomeFile) {
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Inserisci gli interi da inserire nel file");

		int numero;
		char risposta = 's'; // Valore iniziale per entrare nel loop
		try {
			while ((risposta == 's') || (risposta == 'S')) {
				System.out.println("Inserisci un intero: ");
				numero = tastiera.nextInt();
				outputStream.writeInt(numero);
				System.out.println("Inserisci un altro intero?(s/n)");
				risposta = tastiera.next().charAt(0);
			}
		} catch (IOException e) {
			System.out.println("Errore nel scrivere il file " + nomeFile);
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

	public void chiudiFileDiOutput(String nomeFile) {
		try {
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Errore nel chiudere il file " + nomeFile);
			System.exit(0);
		}
	}

	public void chiudiInputFile(String nomeFile) {
		try {
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Errore nel chiudere il file " + nomeFile);
			System.exit(0);
		}
	}
}
