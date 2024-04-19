
/**
 File name: PetFileReadOrWrite.java

 A program to build and view binary files of AnimaleRecord records.

 Based on ClassObjectIODemo.java, Listing 10.10

 Uses AnimaleRecord, Listing 6.1, with the following changes:
 1. It implements Serializable.
 2. It has a leggiInput() method, similar to Species, Listing 10.9
 3. It has a toString() method similar to Species, Listing 10.9

 Written by: Lew Rakocy
 email address: LRakocy@devrycols.edu
 Date: 04/10/2003
 Updated for fourth edition by Brian Durney, January 2005.
 */
import java.io.*;
import java.util.*;

public class AnimaleRecordFileLeggiOScrivi {
	public static void main(String[] args) {
		ObjectInputStream inputStream = null;
		ObjectOutputStream outputStream = null;
		String nomeFile = null;
		Scanner tastiera = new Scanner(System.in);

		char ripeti = 's'; // Inizializzata per entrare nel ciclo la prima volta
		while (ripeti == 's' || ripeti == 'S') {
			System.out.println("Immetti L per leggere i record di animali inseriti in un file ");
			System.out.println("oppure S per scrivere record di animali su un file");
			char azione;
			azione = tastiera.next().charAt(0);

			// Legge record di animali da un file
			if (azione == 'L' || azione == 'l') {
				nomeFile = getNomeFile("Inserisci il nome del file:");
				try {
					inputStream = new ObjectInputStream(new FileInputStream(nomeFile));
				} catch (IOException e) {
					System.out.println("Errore nell'apertura del file " + nomeFile + " in lettura.");
					System.exit(0);
				}

				AnimaleRecord pet = new AnimaleRecord();
				try {
					while (true) {// Esce a fine file
						pet = (AnimaleRecord) inputStream.readObject();
						System.out.println(pet);
						System.out.println();
						System.out.println("===========================");
					}
				} catch (EOFException e) {// Le operazioni normali vanno qui
					System.out.println("\nFine del file: nessun altro record");
				} catch (IOException e) {
					System.out.println("Errore nella lettura dal file " + nomeFile);
					System.exit(0);
				} catch (ClassNotFoundException e) {
					System.out.println("Errore: classe non trovata mentre era in lettura il file " + nomeFile);
					System.exit(0);
				}
				try {
					inputStream.close();
				} catch (IOException e) {
					System.out.println("Errore nella chiusura del file di input " + nomeFile);
					System.exit(0);
				}
				System.out.println("Leggi o scrivi un altro file? (s per si)");
				ripeti = tastiera.next().charAt(0);
			}

			// Scrive record di animali su file
			else if (azione == 'S' || azione == 's') {
				nomeFile = getNomeFile("Inserisci il nome del file da creare:");
				try {
					outputStream = new ObjectOutputStream(new FileOutputStream(nomeFile));
				} catch (IOException e) {					
					System.out.println("Errore nell'apertura del file " + nomeFile + " in scrittura.");
					System.exit(0);
				}

				char eseguiAncora;
				do {// scrive un record nel file
					AnimaleRecord animale = new AnimaleRecord();
					animale.leggiInput();
					try {
						outputStream.writeObject(animale);
					} catch (IOException e) {
						System.out.println("Errore nello scrivere sul file " + nomeFile);
						System.exit(0);
					}
					System.out.println("Inserire un altro record di animale?" + " (s per si)");
					eseguiAncora = tastiera.next().charAt(0);

				} while (eseguiAncora == 's' || eseguiAncora == 'S');

				try {
					outputStream.close();
				} catch (IOException e) {
					System.out.println("Error closing output file " + nomeFile);
					System.out.println("Errore nella chiusura del file di output " + nomeFile);
					System.exit(0);
				}
				System.out.println("Terminato di scrivere record sul file.");
				System.out.println("Leggi o scrivi un altro file? (s per si)");
				ripeti = tastiera.next().charAt(0);
			} else {
				System.out.println("Selezione non valida.");
				ripeti = 's';
			}
		}
	}

	public static String getNomeFile(String prompt) {
		Scanner tastiera = new Scanner(System.in);
		String nomeFile = null;
		System.out.println(prompt);
		nomeFile = tastiera.next();

		return nomeFile;
	}
}
