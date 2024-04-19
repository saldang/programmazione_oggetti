import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileBinarioInputDemo {
	public static void main(String[] args) {
		String nomeFile = "numeri.dat";
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new
								FileInputStream(nomeFile));
			System.out.println("Lettura dei numeri non negativi");
			System.out.println("nel file " + nomeFile);
			
			int unIntero = inputStream.readInt();
			while (unIntero >= 0) {
				System.out.println(unIntero);
				unIntero = inputStream.readInt();
			}

			System.out.println("Fine della lettura dal file.");
			inputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Errore nell'apertura del file " + nomeFile);
		} catch (EOFException e) {
			System.out.println("Errore nella lettura del file " + nomeFile);
			System.out.println("Raggiunta la fine del file.");
		} catch (IOException e) {
			System.out.println("Errore nella lettura del file " + nomeFile);
		}
	}
}
