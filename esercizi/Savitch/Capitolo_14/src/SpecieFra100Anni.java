
/**
 File name: SpeciePopulationsIn100Years.java

 This program processes binary files containing Specie records.
 It asks the user to enter the name of a file that contains
 Specie records, the name of a file in which to write new Specie
 records, then copies records from the first to the second, except
 with the population changed to the projected value after 100 years.

 Note: Use WriteSpecieFile.java to create files with Specie records
 and DisplaySpecieFile.java to view files with Specie records.

 Uses Specie.java, Listing 10.9

 Preconditions: the input file entered contains Specie records.

 Written by: Lew Rakocy
 email address: LRakocy@devrycols.edu
 Date: 9/30/2000
 Changes: 04/06/2003 Made comments like text examples.
                     Rewrote to look like Listing 10.10, ClassObjectIODemo.
 Updated for fourth edition by Brian Durney, January 2005.
 */
import java.io.*;
import java.util.*;

public class SpecieFra100Anni {
	public static void main(String[] args) {
		String nomeFileInput = getNomeFile("Inserisci il nome del file di input.");
		ObjectInputStream inputStream = null;
		try {
			inputStream = new ObjectInputStream(new FileInputStream(nomeFileInput));
		} catch (IOException e) {
			System.out.println("Errore nell'aprire il file di input " + nomeFileInput);
			System.exit(0);
		}

		String nomeFileOutput = getNomeFile("Inserisci il nome del file di output.");
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(nomeFileOutput));
		} catch (IOException e) {
			System.out.println("Errore nell'aprire il file di output " + nomeFileOutput);
			System.exit(0);
		}

		Specie record = null;
		int popolazioneDopo100 = -1; // Inizializza ad un numero non valido
		try {
			while (true) {
				record = (Specie) inputStream.readObject();
				popolazioneDopo100 = record.prediciPopolazione(100);
				record.setSpecie(record.getNome(), popolazioneDopo100, record.getTassoCrescita());
				outputStream.writeObject(record);
			}
		} catch (EOFException e)  {
			System.out.println();
			System.out.println("Tutti i record nel file " + nomeFileInput + " sono stati processati.");
			System.out.println();
			System.out.println("I record nel file " + nomeFileOutput + " hanno la popolazione proiettata a 100 anni");
		} catch (IOException e) {
			System.out.println("Errore nel leggere o scrivere i file " + e.getMessage());
			System.exit(0);
		} catch (ClassNotFoundException e) {
			System.out.println("Errore: classe non trovata.");
			System.exit(0);
		}

		try {
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Errore nel chiudere il file di input " + nomeFileInput);
			System.exit(0);
		}

		try {
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Errore nel chiudere il file di output " + nomeFileOutput);
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
