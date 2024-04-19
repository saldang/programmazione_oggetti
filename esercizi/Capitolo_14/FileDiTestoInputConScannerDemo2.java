import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileDiTestoInputConScannerDemo2 {
	public static void main(String[] args) {
		System.out.print("Inserire il nome di un file: ");
		Scanner tastiera = new Scanner(System.in);
		String nomeFile = tastiera.next();
		Scanner inputStream = null;
		System.out.println("Il file " + nomeFile + "\n" + 
						"contiene le righe seguenti:\n");

		try {
			inputStream = new Scanner(new File(nomeFile));
		} catch (FileNotFoundException e) {
			System.out.println("Errore nell'apertura del file " + nomeFile);
			System.exit(0);
		}
		while (inputStream.hasNextLine()) {
			String riga = inputStream.nextLine();
			System.out.println(riga);
		}
		inputStream.close();
	}
}