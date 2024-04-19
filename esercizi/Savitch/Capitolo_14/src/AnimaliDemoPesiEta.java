import java.io.*;
import java.util.*;

public class AnimaliDemoPesiEta {
	public static void main(String[] args) {
		ObjectInputStream inputStream = null;
		String nomeFile = getNomeFile("Inserisci il nome del file di input:");
		try {
			inputStream = new ObjectInputStream(new FileInputStream(nomeFile));
		} catch (IOException e) {
			System.out.println("Il file " + nomeFile + " non e' stato trovato.");
			System.exit(0);
		}

		AnimaleRecord piuPesante = new AnimaleRecord();
		AnimaleRecord piuLeggero = new AnimaleRecord();
		AnimaleRecord piuVecchio = new AnimaleRecord();
		AnimaleRecord piuGiovane = new AnimaleRecord();
		AnimaleRecord next = new AnimaleRecord();

		try {
			// Inizializza tutti con il primo record
			// Si assume che il file abbia almeno un animale
			piuPesante = (AnimaleRecord) inputStream.readObject();
			piuLeggero.setNome(piuPesante.getNome());
			piuLeggero.setEta(piuPesante.getEta());
			piuLeggero.setPeso(piuPesante.getPeso());
			piuVecchio.setNome(piuPesante.getNome());
			piuVecchio.setEta(piuPesante.getEta());
			piuVecchio.setPeso(piuPesante.getPeso());
			piuGiovane.setNome(piuPesante.getNome());
			piuGiovane.setEta(piuPesante.getEta());
			piuGiovane.setPeso(piuPesante.getPeso());

			while (true) {// Fino alla fine del file
				next = (AnimaleRecord) inputStream.readObject();
				if (next.getPeso() > piuPesante.getPeso()) {
					piuPesante.setAnimale(next.getNome(), next.getEta(), next.getPeso());
				} else if (next.getPeso() < piuLeggero.getPeso()) {
					piuLeggero.setAnimale(next.getNome(), next.getEta(), next.getPeso());
				}
				if (next.getEta() > piuVecchio.getEta()) {
					piuVecchio.setAnimale(next.getNome(), next.getEta(), next.getPeso());
				} else if (next.getEta() < piuGiovane.getEta()) {
					piuGiovane.setAnimale(next.getNome(), next.getEta(), next.getPeso());
				}
			}
		} catch (EOFException e) {// Normal operation goes here at end of file
			System.out.println();
			System.out.println("L'animale piu' pesante pesa " + piuPesante.getPeso() + " kg ed e' " + piuPesante.getNome());
			System.out.println();
			System.out.println("L'animale piu' leggero pesa " + piuLeggero.getPeso() + " kg ed e' " + piuLeggero.getNome());
			System.out.println();
			System.out.println(piuVecchio.getNome() + ", di " + piuVecchio.getEta() + " anni, e' il piu' anziano.");
			System.out.println();
			System.out.println(piuGiovane.getNome() + ", di " + piuGiovane.getEta() + " anni, e' il piu' giovane.");
			System.out.println();
		} catch (IOException e) {
			System.out.println("Errore in lettura del file " + nomeFile);
			System.exit(0);
		} catch (ClassNotFoundException e) {
			System.out.println("Errore: classe non trovata.");
			System.exit(0);
		}

		try {
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Errore in chiusura del file " + e.getMessage());
			System.exit(0);
		}
	}

	private static String getNomeFile(String prompt) {
		Scanner tastiera = new Scanner(System.in);
		String nomeFile = null;
		System.out.println(prompt);
		nomeFile = tastiera.next();

		return nomeFile;
	}
}
