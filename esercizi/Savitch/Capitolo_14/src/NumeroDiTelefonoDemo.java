import java.io.*;
import java.util.*;

public class NumeroDiTelefonoDemo {

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		Scanner inputFile = null;
		try {
			inputFile = new Scanner(new File("numeri.txt"));
		} catch (FileNotFoundException ex) {
			System.out.println("Errore nell'apertura del file in lettura");
			System.exit(0);
		}

		// Verifica il numero di numeri nel file
		int contatore = 0;
		while (inputFile.hasNext()) {
			String telNumberString = inputFile.next();
			NumeroDiTelefono t = null;
			try {
				t = new NumeroDiTelefono(telNumberString);
				contatore++;
			} catch (NumeroTelefonicoNonValidoException ex) {
				System.out.println("Formato non ammesso " + ex.getMessage());
			}
			System.out.println("Leggo il numero " + t);
		}
		inputFile.close();

		// Crea un array e quindi rilegge il file cosi' da riempire l'array
		NumeroDiTelefono numeri[] = new NumeroDiTelefono[contatore];

		try {
			inputFile = new Scanner(new File("numeri.txt"));
		} catch (FileNotFoundException ex) {
			System.out.println("Errore nell'apertura del file");
			System.exit(0);
		}

		contatore = 0;
		while (inputFile.hasNext()) {
			String numeroTelefonoString = inputFile.next();
			NumeroDiTelefono numeroTelefono = null;
			try {
				numeroTelefono = new NumeroDiTelefono(numeroTelefonoString);
				numeri[contatore] = numeroTelefono;
				System.out.println("Numero " + contatore + " e' " + numeroTelefono);
				contatore++;
			} catch (NumeroTelefonicoNonValidoException ex) {
			}
		}
		inputFile.close();

		NumeroDiTelefono nuovoNumero = null;

		System.out.println("Cambia un numero (c) o aggiungi un numero (a)");
		String risposta = tastiera.next().toLowerCase();
		if (risposta.equals("c")) {
			System.out.println("Quale numero desideri modificare? (immetti l'indice)");
			int indice = tastiera.nextInt();
			System.out.println("Inserisci il numero di telefono");
			String nuovoNumeroString = tastiera.next();

			try {
				nuovoNumero = new NumeroDiTelefono(nuovoNumeroString);
			} catch (NumeroTelefonicoNonValidoException ex) {
				System.out.println("Formato non ammesso " + ex.getMessage());
			}
			if (nuovoNumero != null)
				numeri[indice] = nuovoNumero;
		} else if (risposta.equals("a")) {
			System.out.println("Inserisci il numero di telefono da aggiungere");
			String nuovoNumeroString = tastiera.next();
			try {
				nuovoNumero = new NumeroDiTelefono(nuovoNumeroString);
			} catch (NumeroTelefonicoNonValidoException ex) {
				System.out.println("Formato non ammesso" + ex.getMessage());
			}

		}

		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter("numeri.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Errore nell'apertura del file in scrittura");
			System.exit(0);
		}

		for (int i = 0; i < numeri.length; i++) {
			outputStream.println(numeri[i]);
		}

		if (risposta.equals("a"))
			outputStream.println(nuovoNumero);

		outputStream.close();

		System.out.println("Il file e' stato riscritto.");
	}
}
