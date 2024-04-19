import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EsempioScritturaFileDiTesto {
	public static void main(String[] args) {
		String nomeFile = "out.txt";  //Il nome potrebbe anche
						              //essere letto da tastiera
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(nomeFile);
		} catch (FileNotFoundException e) {
			System.out.println("Errore nell'apertura del file " + nomeFile);
			System.exit(0);
		}

		System.out.println("Inserire tre righe di testo:");
		Scanner tastiera = new Scanner(System.in);
		for (int contatore = 1; contatore <= 3; contatore++) {
			String riga = tastiera.nextLine();
			outputStream.println(contatore + " " + riga);
		}
		outputStream.close();
		System.out.println("Le righe sono state scritte su " + nomeFile);
	}
}
