import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class LetturaTransazioni {
	public static void main(String[] args) {
		String nomeFile = "Transazioni.txt";
		try {
			Scanner inputStream = new Scanner(new File(nomeFile));
			// Salta l'intestazione leggendola e poi ignorandola
			String riga = inputStream.nextLine();
			// Vendite totali
			double totale = 0;
			// Legge il resto del file riga per riga
			while (inputStream.hasNextLine()) {
				// Contiene Codice,Quantit�,Prezzo,Descrizione
				riga = inputStream.nextLine();
				// Trasforma la stringa in un array di stringhe
				String[] array = riga.split(",");
				// Estrae ogni elemento in una variabile opportuna
				String codice = array[0];
				int quantita = Integer.parseInt(array[1]);
				double prezzo = Double.parseDouble(array[2]);
				String descrizione = array[3];
				// Stampa la registrazione
				System.out.printf("Venduti %d di %s (codice: %s) a " + 
					"�%1.2f l'uno.\n", quantita, descrizione, codice, prezzo);
				// Calcola il totale
				totale += quantita * prezzo;
			}
			System.out.printf("Vendite totali: �%1.2f\n", totale);
			inputStream.close( );
		} catch(FileNotFoundException e) {
			System.out.println("Impossibile trovare il file " + nomeFile);
		} catch(IOException e) {
			System.out.println("Errore nella lettura del file " + nomeFile);
		}
	}
}
