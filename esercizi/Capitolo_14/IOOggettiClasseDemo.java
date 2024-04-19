import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOOggettiClasseDemo {
	public static void main(String[] args) {
		String nomeFile = "specie.registrazioni";

		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(nomeFile));
		} catch (IOException e) {
			System.out.println("Errore nell'apertura del file di output " +
					nomeFile + ".");
			System.exit(0);
		}

		Specie condorCalifornia = new Specie("Condor della California", 27, 0.02, new Persona("John Smith"));
		Specie rinoceronteNero = new Specie("Rinoceronte Nero", 100, 1.0, new Persona("Jane Smith"));

		try {
			outputStream.writeObject(condorCalifornia);
			outputStream.writeObject(rinoceronteNero);
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Errore nella scrfittura del file " + nomeFile + ".");
			System.exit(0);
		}
		System.out.println("Le registrazioni sono state scritte nel file " +
				nomeFile + ".");
		System.out.println("Ora il file verr� riaperto e verranno mostrate "
				+ "le registrazioni.");
		ObjectInputStream inputStream = null;
		try {
			inputStream = new ObjectInputStream(new FileInputStream(nomeFile));
		} catch (IOException e) {
			System.out.println("Errore nell'apertura del file di input "
					+ nomeFile + ".");
			System.exit(0);
		}

		Specie lettaUno = null, lettaDue = null;
		try {
			lettaUno = (Specie) inputStream.readObject();
			lettaDue = (Specie) inputStream.readObject();
			inputStream.close();
		} catch (Exception e) {
			System.out.println("Error nella lettura del file " + nomeFile + ".");
			System.exit(0);
		}

		System.out.println("Sono stati letti dal file " + nomeFile +
				"\ni seguenti dati.");
		System.out.println(lettaUno);
		System.out.println();
		System.out.println(lettaDue);
		System.out.println("Fine del programma.");
	}
}
