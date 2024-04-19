import java.io.*;
import java.util.*;

public class InformazioniContattoDemo {

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		Scanner inputFile = null;
		try {
			inputFile = new Scanner(new File("contatti.txt"));
		} catch (FileNotFoundException ex) {
			System.out.println("Errore nell'apertura del file in lettura");
			System.exit(0);
		}

		// Verifica il numero di contatti
		int contatore = 0;
		while (inputFile.hasNext()) {
			String contattoString = inputFile.nextLine();
			InformazioniContatto contatto = null;
			try {
				contatto = new InformazioniContatto(contattoString);
				contatore++;
			} catch (ContattoNonValidoException ex) {
				System.out.println("Informazioni del contatto non valide ");
			}
		}
		inputFile.close();

		// Crea un array e lo riempie con i contatti
		InformazioniContatto contatti[] = new InformazioniContatto[contatore];

		try {
			inputFile = new Scanner(new File("contatti.txt"));
		} catch (FileNotFoundException ex) {
			System.out.println("Errore nell'apertura del file in lettura");
			System.exit(0);
		}

		contatore = 0;
		while (inputFile.hasNext()) {
			String contattoString = inputFile.nextLine();
			InformazioniContatto contatto = null;
			try {
				contatto = new InformazioniContatto(contattoString);
				contatti[contatore] = contatto;
				System.out.println("Il contatto " + contatore + " e' " + contatto.stringFormattata());
				contatore++;
			} catch (ContattoNonValidoException ex) {
			}
		}
		inputFile.close();

		InformazioniContatto nuovoContatto = null;

		System.out.println("Cambia un contatto (c) o aggiungi un contatto (a) o rimuovi un contatto (d)");
		String risposta = tastiera.next().toLowerCase();
		if (risposta.equals("c")) {
			System.out.println("Quale contatto desideri modificare? (immetti l'indice)");
			int indice = tastiera.nextInt();
			modificaContatto(contatti[indice]);

		} else if (risposta.equals("a")) {
			tastiera.nextLine();
			System.out.println("Inserisci le informazioni del contatto da aggiungere");
			String nuovoContattoString = tastiera.nextLine();

			try {
				nuovoContatto = new InformazioniContatto(nuovoContattoString);
			} catch (ContattoNonValidoException ex) {
				System.out.println("Formato del contatto non valido: " + ex.getMessage());
			}
		} else if (risposta.equals("d")) {
			System.out.println("Quale contatto desideri cancellare? (immetti l'indice)");
			int indice = tastiera.nextInt();
			contatti[indice] = null;
		}

		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter("contatti.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Errore nell'apertura del file in scrittura");
			System.exit(0);
		}

		for (int i = 0; i < contatti.length; i++) {
			if (contatti[i] != null)
				outputStream.println(contatti[i]);
		}

		if (risposta.equals("a"))
			outputStream.println(nuovoContatto);

		outputStream.close();

		System.out.println("Il file e' stato scritto.");
	}

	public static void modificaContatto(InformazioniContatto contatto) {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Il contatto e' " + contatto.stringFormattata());
		System.out.println("Quale campo desider modificare?");

		String risposta = tastiera.nextLine().trim().toLowerCase();
		if (risposta.indexOf("nom") != -1) {
			System.out.println("Inserisci il nuovo nome");
			String entry = tastiera.nextLine();
			contatto.aggiornaNome(entry);
		} else if (risposta.indexOf("ind") != -1) {
			System.out.println("Inserisci il nuovo indirizzo");
			String entry = tastiera.nextLine();
			contatto.aggiornaIndirizzoCasa(entry);
		} else if (risposta.indexOf("uff") != -1) {
			System.out.println("Inserisci il nuovo numero dell'ufficio");
			String entry = tastiera.nextLine();
			contatto.aggiornaTelefonoUfficio(entry);
		} else if (risposta.indexOf("cas") != -1) {
			System.out.println("Inserisci il nuovo numero di casa");
			String entry = tastiera.nextLine();
			contatto.aggiornaTelefonoCasa(entry);
		} else if (risposta.indexOf("cel") != -1) {
			System.out.println("Inserisci il nuovo di cellulare");
			String entry = tastiera.nextLine();
			contatto.aggiornaTelefonoCellulare(entry);
		} else if (risposta.indexOf("ema") != -1) {
			System.out.println("Inserisci il nuovo indirizzo email");
			String entry = tastiera.nextLine();
			contatto.aggiornaEmail(entry);
		} else {
			System.out.println("Non riesco a capire quale campo modificare.");
		}
	}
}