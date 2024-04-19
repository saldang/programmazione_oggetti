import java.util.*;
import java.io.*;

public class AnimaliOrdinatiPerPeso {
	public static void main(String[] args) {
/*		
		// FILE
		// Se legge da file la lista degli animali
		// Apre il file di input
		String fileName = getFileName("Inserisci il nome del file da caricare:");
		ObjectInputStream inputStream = null;
		try {
			inputStream = new ObjectInputStream(new FileInputStream(fileName));
		} catch (IOException e) {
			System.out.println("Errore in lettura del file " + fileName);
			System.exit(0);
		}
		// Copia gli animali nella lista
		List<Animale> animali = new ArrayList<Animale>();
		Animale animale = new Animale();
		try {
			while (true) { // Uscita quando End Of File Exception
				animale = (Animale) inputStream.readObject();
				animali.add(animale);
			}
		} catch (EOFException e) {
			// tutto ok: raggiunta fine file
			System.out.println("\nAnimali copiati da " + fileName + " alla lista");
		} catch (IOException e) {
			System.out.println("Errore in lettura dal file " + fileName);
			System.exit(0);
		} catch (ClassNotFoundException e) {
			System.out.println("Errore: classe non trovata");
			System.exit(0);
		} // Chiude il file
		try {
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Errore in chisura del file " + fileName);
			System.exit(0);
		}
		// FINE FILE
*/
		List<Animale> animali = new ArrayList<Animale>();

		char ripeti = 's';
		Scanner tastiera = new Scanner(System.in);

		while (ripeti == 's' || ripeti == 'S') {
			System.out.println("Nome dell'animale: ");
			String nome = tastiera.nextLine();
			System.out.println("Eta dell'animale: ");
			int eta = tastiera.nextInt();
			System.out.println("Peso dell'animale: ");
			double peso = tastiera.nextDouble();
			Animale nextAnimale = new Animale(nome, eta, peso);
			animali.add(nextAnimale);

			System.out.println();
			System.out.println("Un altro animale? (s per si): ");
			ripeti = tastiera.next().charAt(0);
		}
		// Pera ggiungere degli animali senza inserirli a mano
		aggiungiAnimali(animali);

		// Ordina gli animali per nome
		System.out.println("Ordino glli animali per peso.");

		// La sentinella ordinato sarà posta a true prima di ogni passaggio attraverso
		// l'array
		// e posta a false se si verifica uno swap durante il passaggio.
		// Se rimane true, allora non si è verificato alcuno swap e l'array deve essere
		// ordinato.
		// La sentinella è inizializzata a false cosi' da entrare nel ciclo
		boolean ordinato = false;
		int iterazioni = animali.size() - 1; // Numero massimo di iterazioni
		while (!ordinato && iterazioni > 0) {
			ordinato = true;
			for (int i = 0; i < iterazioni; ++i) {
				if ((animali.get(i)).getPeso() > (animali.get(i + 1)).getPeso()) {
					Animale temp = new Animale();
					temp = animali.get(i);
					animali.set(i, animali.get(i + 1));
					animali.set(i + 1, temp);
					ordinato = false;
				}
			}
			iterazioni--;
		}

		// Ordinato!
		for (int i = 0; i < animali.size(); ++i) {
			System.out.println();
			((Animale) animali.get(i)).scriviOutput();
			System.out.println("===================================");
			System.out.println();
		}
		
/*
		// FILE
		// Copia gli elementi ordinati su file
		// Apre il file
		fileName = getFileName("Enter name of file to create:");
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
		} catch (IOException e) {
			System.out.println("Errore nell'apertura in scrittura del file " + fileName);
			System.exit(0);
		}
		// Scrive gli animali su file
		try {
			for (int i = 0; i < animali.size(); ++i) {
				Animale nextPet = animali.get(i);
				outputStream.writeObject(nextPet);
			}
		} catch (IOException e) {
			System.out.println("Errore in scrittura sul file " + fileName);
			System.exit(0);
		}
		// Chiude il file
		try {
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Errore in chiusura del file " + fileName);
			System.exit(0);
		}
		System.out.println();
		System.out.println("Animali in ordine di peso sono stati copiati sul file " + fileName);
		// FINE FILE
*/
		
		// Calcola statistiche sul peso
		int sotto5 = 0;
		int tra5e10 = 0;
		int sopra10 = 0;
		for (int i = 0; i < animali.size(); ++i) {
			if ((animali.get(i)).getPeso() < 5)
				++sotto5;
			else if ((animali.get(i)).getPeso() > 10)
				++sopra10;
			else
				++tra5e10;
		}

		// Mostra statistiche sul peso
		System.out.println();
		System.out.println("Numero di animali sotto i 5 kg: " + sotto5);
		System.out.println("Percentuale di animali sotto i 5 kg: " + (double) sotto5 * 100 / animali.size() + "%");
		System.out.println();
		System.out.println("Numero di animali tra i 5 kg e i 10 kg: " + tra5e10);
		System.out.println(
				"Percentuale di animali tra i 5 kg e i 10 kg: " + (double) tra5e10 * 100 / animali.size() + "%");
		System.out.println();
		System.out.println("Numero di animali sopra i 10 kg: " + sopra10);
		System.out.println("Percentuale di animali sopra i 10 kg: " + (double) sopra10 * 100 / animali.size() + "%");
		System.out.println();
	}

	private static String getFileName(String prompt) {
		Scanner tatsiera = new Scanner(System.in);
		String fileName = null;
		System.out.println(prompt);
		fileName = tatsiera.next();
		return fileName;
	}

	// Questo metodo permette di aggiungere animali senza doverli inserire a mano
	public static void aggiungiAnimali(List<Animale> somePets) {
		somePets.add(new Animale("cane", 10, 25));
		somePets.add(new Animale("gatto", 4, 10));
		somePets.add(new Animale("ostrica", 8, 150));
		somePets.add(new Animale("elefante", 35, 2000));
		somePets.add(new Animale("asino", 8, 350));
		somePets.add(new Animale("cobra", 2, 2));
	}
}
