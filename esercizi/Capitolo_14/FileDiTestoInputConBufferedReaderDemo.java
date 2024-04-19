import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileDiTestoInputConBufferedReaderDemo {
	public static void main(String[] args) {
		
		String nomeFile = "originale.txt";
		BufferedReader inputStream = null;
		System.out.println("Il file " + nomeFile + "\ncontiene le righe seguenti:\n");		
		
		try {
			inputStream = new BufferedReader(new FileReader(nomeFile));			
		} catch (FileNotFoundException e) {
			System.out.println("Problema nell'apertura del file.");
		}		
		
		try {
			String riga = inputStream.readLine();
			while (riga != null) {
				System.out.println(riga);			
				riga = inputStream.readLine();
			}
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Errore nella lettura da " +  nomeFile);
		}
	}
}
