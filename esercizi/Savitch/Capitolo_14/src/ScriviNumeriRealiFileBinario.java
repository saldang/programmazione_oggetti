import java.util.*;
import java.io.*;

public class ScriviNumeriRealiFileBinario {
	private ObjectOutputStream outputStream = null;
	private ObjectInputStream inputStream = null;

	/**
	 * Ottiene un nome di file dall'utente e riempie il file con numeri reali (tipo
	 * double) inseriti dall'utente. I duplicati sono ammessi
	 */
	public static void main(String[] args) {
		String nomeFile = null;
		nomeFile = getNomeFile("Inserisci il nome del file di output: ");
		ScriviNumeriRealiFileBinario realNumberBinaryFile = new ScriviNumeriRealiFileBinario();
		realNumberBinaryFile.connettiFileOutput(nomeFile);
		realNumberBinaryFile.inserisciNumeri(nomeFile);
		realNumberBinaryFile.chiudiFileOutput(nomeFile);

		// Verifica i dati inseriti
		realNumberBinaryFile.connettiFileInput(nomeFile);
		realNumberBinaryFile.mostarNumeri(nomeFile);
		realNumberBinaryFile.chiudiFileInput(nomeFile);
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

	public void inserisciNumeri(String nameOfFile) {
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Inserisci un numero reale da inserire nel file");

		double numero;
		char risposta = 'y'; // Valore iniziale per entrare nel loop
		try {
			while ((risposta == 's') || (risposta == 'S')) {
				System.out.println("Inserisci un numero reale: ");
				numero = tastiera.nextDouble();
				outputStream.writeDouble(numero);
				System.out.println("Inserisci un altro intero?(s/n)");
				risposta = tastiera.next().charAt(0);
			}
		} catch (IOException e) {
			System.out.println("Errore nello scrivere il file " + nameOfFile);
			System.exit(0);
		}
	}

	public void mostarNumeri(String nomeFile) {
		System.out.println("I numeri nel file sono: ");
		try {
			while (true) { // Stop at EOF
				System.out.println(inputStream.readDouble());
			}
		} catch (EOFException e) {
			System.out.println("Fine dei dati.");
		} catch (IOException e) {
			System.out.println("Errore nel leggere il file " + nomeFile);
			System.exit(0);
		}
	}

	public void chiudiFileOutput(String nomeFile) {
		try {
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Errore nel chiudere il file " + nomeFile);
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
