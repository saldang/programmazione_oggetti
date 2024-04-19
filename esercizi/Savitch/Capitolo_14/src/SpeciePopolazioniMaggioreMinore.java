
/**
 Questo programma elabora i file binari contenenti record Specie.
 Chiede all'utente di inserire il nome di un file che contiene Specie
 quindi visualizza i record delle specie con rispetttivamente la popolazione minore e maggiore.

 Note
 1) Se più di una specie ha la stessa popolazione minima e massima, viene visualizzata la prima trovata
 2) Usare ScriviSpecieSuFile.java per creare file con record Specie.
 3) Usare MostraSpecieSuFile.java per visualizzare i file con record Specie.
 */
import java.io.*;
import java.util.*;

public class SpeciePopolazioniMaggioreMinore {
	public static void main(String[] args) {
		String nomeFile = getNomeFile("Inserisci il nome della specie.");
		ObjectInputStream inputStream = null;
		try {
			inputStream = new ObjectInputStream(new FileInputStream(nomeFile));
		} catch (IOException e) {
			System.out.println("Errore nell'aprire il file di input " + nomeFile);
			System.exit(0);
		}

		Specie piccola = new Specie();
		Specie grande = new Specie();
		Specie next = new Specie();

		try {
			// Inizializza le specie piu' piccola e piu' grande con la prima specie
			piccola = (Specie) inputStream.readObject();
			grande.setSpecie(piccola.getNome(), piccola.getPopolazione(), piccola.getTassoCrescita());
			while (true) {
				next = (Specie) inputStream.readObject();
				if (next.getPopolazione() < piccola.getPopolazione()) {
					piccola.setSpecie(next.getNome(), next.getPopolazione(), next.getTassoCrescita());
				} else if (next.getPopolazione() > grande.getPopolazione()) {
					grande.setSpecie(next.getNome(), next.getPopolazione(), next.getTassoCrescita());
				}
			}
		} catch (EOFException e)  {
			System.out.println("");
			System.out.println("Specie con la popolazione minore:");
			System.out.println(piccola);
			System.out.println("");
			System.out.println("Specie con la popolazione maggiore:");
			System.out.println(grande);
		} catch (Exception e) {
			System.out.println("Errore nel leggere il file " + nomeFile);
			System.exit(0);
		}
		try {
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Errore nel chiudere il file " + nomeFile);
			System.exit(0);
		}
		System.out.println("Fine del programma.");
	}

	private static String getNomeFile(String prompt) {
		Scanner tastiera = new Scanner(System.in);
		String nomeFile = null;
		System.out.println(prompt);
		nomeFile = tastiera.next();

		return nomeFile;
	}
}
