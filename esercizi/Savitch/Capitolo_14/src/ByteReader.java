import java.util.*;
import java.io.*;

public class ByteReader {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Qual e' il nome del file da leggere?");
		String nomeFile = input.next();
		char[] c;
		char[] badChar = { ' ' };
		try {
			ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(nomeFile));
			System.out.println("Contenuto del file.");
			while (true) {
				// Dipendiamo da un errore che ci fa uscire da questo ciclo.
				Byte b = inFile.readByte();

				try {
					c = Character.toChars(b);
				} catch (IllegalArgumentException e) {
					c = badChar;
				}

				System.out.println(b + ":" + c[0]);

			}
		} catch (FileNotFoundException e) {
			System.out.println("Abbiamo un problema nell'aprire il file: " + e.getMessage());

		} catch (EOFException e) {
			System.out.println();
			System.out.println("Raggiunta la fine del file.");
		} catch (IOException e) {
			System.out.println();
			System.out.println(e.getMessage());
		}
	}
}
