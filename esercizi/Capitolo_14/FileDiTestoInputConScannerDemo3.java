import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileDiTestoInputConScannerDemo3 {
	public static void main(String[] args) {
		System.out.print("Inserire il nome di un file: ");
		Scanner tastiera = new Scanner(System.in);
		String nomeFile = tastiera.next();
		Scanner inputStream = null;
		System.out.println("Il file " + nomeFile + "\n" + 
						"contiene le righe seguenti:\n");

		try {
			
			File oggettoFile = new File(nomeFile);
			boolean fileOK = false;
			while (!fileOK) {
				if (!oggettoFile.exists())
					System.out.println("Il file non esiste");
				else if (!oggettoFile.canRead())
					System.out.println("Il file non può essere letto.");
				else
					fileOK = true;

				if (!fileOK) {
					System.out.println("Reinserire il nome del file:");
					nomeFile = tastiera.next( );
					oggettoFile = new File(nomeFile);
				}
			}
			
			inputStream = new Scanner(oggettoFile);
				
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