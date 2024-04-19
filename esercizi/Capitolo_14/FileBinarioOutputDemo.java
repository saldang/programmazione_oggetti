import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileBinarioOutputDemo {
	public static void main(String[] args) {
		String nomeFile = "numeri.dat";
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new 
									FileOutputStream(nomeFile)); 
			Scanner tastiera = new Scanner(System.in);
			System.out.println("Inserire degli interi non negativi.");
			System.out.println("Inserire un numero negativo per terminare.");

			int unIntero;
			do {
				unIntero = tastiera.nextInt();
				outputStream.writeInt(unIntero); 
			} while (unIntero >= 0);

			System.out.println("I numeri e il valore di terminazione");
			System.out.println("sono stati scritti nel file " + nomeFile);
			outputStream.close(); 
		} catch (FileNotFoundException e) {
			System.out.println("Errore nell'apertura del file " + nomeFile);
		} catch (IOException e) {
			System.out.println("Errore nella scrittura nel file " + nomeFile);
		}
	}
}
