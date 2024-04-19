import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EOFExceptionDemo {
	public static void main(String[] args) {
		String nomeFile = "numeri.dat";
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new
								FileInputStream(nomeFile));
			System.out.println("Lettura di TUTTI gli interi");
			System.out.println("nel file " + nomeFile);

			try {
				while (true)  {
					int unIntero = inputStream.readInt(); 
					System.out.println(unIntero);
				}
			} catch (EOFException e)  {
				System.out.println("Fine della lettura dal file.");
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Errore nell'apertura del file " + nomeFile);
		} catch (IOException e) {
			System.out.println("Errore nella lettura del file " + nomeFile);
		}
	}
}
