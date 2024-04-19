import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileDiTestoInputConScannerDemo {
	public static void main(String[] args) {
		String nomeFile = "out.txt";
		Scanner inputStream = null;
		System.out.println("Il file " + nomeFile + "\ncontiene le righe seguenti:\n");
		
		try {
			inputStream = new Scanner(new File(nomeFile));
		} catch (FileNotFoundException e) {
			System.out.println("Errore nell’apertura del file " + nomeFile);
			System.exit(0);
		}
		while (inputStream.hasNextLine()) {
			String riga = inputStream.nextLine();
			System.out.println(riga);
		}
		inputStream.close();
	}
}
