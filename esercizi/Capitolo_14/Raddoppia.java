import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Raddoppia {
	private ObjectInputStream inputStream = null;
	private ObjectOutputStream outputStream = null; 

	/**
	Raddoppia gli interi in un file e scrive il risultato in un altro file.
	*/
	public static void main(String[] args) {
		Raddoppia moltiplicatore = new Raddoppia();
		moltiplicatore.collegaFileDiInput();
		moltiplicatore.collegaFileDiOutput();
		moltiplicatore.moltiplicaPerDue();
		moltiplicatore.chiudiFile();

		System.out.println("Numeri letti da un file di input");
		System.out.println("raddoppiati e copiati in un file di output.");
	}

	public void collegaFileDiInput() {
		String nomeFileDiInput = leggiNomeFile("Inserisci il nome del file di input:");
		try {
			inputStream = new ObjectInputStream(new FileInputStream(nomeFileDiInput));
		} catch (FileNotFoundException e) {
			System.out.println("File " + nomeFileDiInput + " non trovato.");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Errore nell'apertura del file di input " +
									nomeFileDiInput);
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	private String leggiNomeFile(String messaggio) {
		String nomeFile = null;
		System.out.println(messaggio);
		Scanner tastiera = new Scanner(System.in);
		nomeFile = tastiera.next();
		return nomeFile;
	}

	public void collegaFileDiOutput() {
		String nomeFileDiOutput = leggiNomeFile("Inserisci il nome del file di output:");
		try {
			outputStream = new ObjectOutputStream(new
							FileOutputStream(nomeFileDiOutput));
		} catch (IOException e) {
			System.out.println("Errore nell'apertura del file di output " +
									nomeFileDiOutput);
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	public void moltiplicaPerDue() {
		try {
			while (true) {
				int prossimo = inputStream.readInt(); 
				outputStream.writeInt(2 * prossimo);
			}
		} catch (EOFException e) {
			//Non fa niente, serve solo per terminare il ciclo.
		}  catch (IOException e) {
			System.out.println("Errore nella lettura o nella scrittura dei file.");
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	public void chiudiFile() {
		try {
			inputStream.close();
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Errore nella chiusura dei file.");
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
}
