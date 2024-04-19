import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOArrayDemo {
	public static void main(String[] args) {
		Specie[] unArray = new Specie[2]; 
		unArray[0] = new Specie("Condor della California", 27, 0.02);
		unArray[1] = new Specie("Rinoceronte Nero", 100, 1.0);
		String nomeFile = "array.dat";

		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new
								FileOutputStream(nomeFile));
			outputStream.writeObject(unArray); 
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Errore nella scrittura del file " + 
									nomeFile + ".");
			System.exit(0);
		}

		System.out.println("L’array è stato scritto nel file " + nomeFile + 
							" e il file è stato chiuso.");
		System.out.println("Ora il file verrà riaperto e verrà stampato l’array.");

		Specie[] unAltroArray = null; 
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new
								FileInputStream(nomeFile));
			unAltroArray = (Specie[])inputStream.readObject(); 
			inputStream.close();
		} catch (Exception e) {
			System.out.println("Errore nella lettura del file " + 
									nomeFile + ".");
			System.exit(0);		
		}

		System.out.println("I seguenti dati sono stati letti dal file " + 
									nomeFile + ":");
		for (int i = 0; i < unAltroArray.length; i++) {
			System.out.println(unAltroArray[i]);
			System.out.println();
		}
		System.out.println("Fine del programma.");
	}
}
