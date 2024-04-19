import java.io.*;
import java.util.*;

public class DelimitatoreDiAbbreviazioni {

	public static void main(String[] args) {

		Scanner tastiera = new Scanner(System.in);

		System.out.println("Qual e' il file da cui leggere?");
		String inputNomeFile = tastiera.nextLine().trim();

		System.out.println("What is the file to write to with abbreviations marked");
		String outputNomeFile = tastiera.nextLine().trim();

		Scanner fileInput = null;
		try {
			fileInput = new Scanner(new File(inputNomeFile));
		} catch (FileNotFoundException ex) {
			System.out.println("Errore nell'aprire il file di input " + fileInput + " in lettura");
			System.exit(0);
		}

		PrintWriter fileOutput = null;
		try {
			fileOutput = new PrintWriter(new File(outputNomeFile));
		} catch (FileNotFoundException ex) {
			System.out.println("Errore nell'aprire il file di output " + outputNomeFile + " per la scrittura");
			System.exit(0);
		}

		Scanner fileAbbreviazioni = null;
		try {
			fileAbbreviazioni = new Scanner(new File("abbreviazioni.txt"));
		} catch (FileNotFoundException ex) {
			System.out.println("Errore nell'aprire il file abbreviazioni.txt in lettura");
			System.exit(0);
		}

		// Conta il numero di abbreviazioni
		int count = 0;
		while (fileAbbreviazioni.hasNextLine()) {
			fileAbbreviazioni.nextLine();
			count++;
		}

		// Riapre il file
		fileAbbreviazioni.close();
		try {
			fileAbbreviazioni = new Scanner(new File("abbreviazioni.txt"));
		} catch (FileNotFoundException ex) {
			System.out.println("Errore nell'aprire il file abbreviazioni.txt in lettura");
			System.exit(0);
		}

		// Crea un array per memorizzare le abbreviazioni
		String abbreviazioni[] = new String[count];
		for (int i = 0; i < count; i++) {
			String abbreviazione = fileAbbreviazioni.nextLine().trim();
			abbreviazioni[i] = abbreviazione;
		}
		fileAbbreviazioni.close();

		// Scansiona il file e processa ogni linea
		while (fileInput.hasNextLine()) {
			String linea = fileInput.nextLine();
			String nuovaLinea = processLine(linea, abbreviazioni);
			fileOutput.println(nuovaLinea);
		}

		fileInput.close();
		fileOutput.close();

		System.out.println("Elaborazione completata.");

	}

	// Elabora una singola linea
	public static String processLine(String linea, String[] abbreviazioni) {
		for (int i = 0; i < abbreviazioni.length; i++) {
			linea = elaboraAbbreviazione(linea, abbreviazioni[i]);
		}
		return linea;
	}

	public static String elaboraAbbreviazione(String linea, String abbreviazione) {
		String risultato = "";
		String input = linea;
		String elaborata = linea.toLowerCase();
		int trovataA = elaborata.indexOf(abbreviazione);
		while (trovataA != -1) {
			// trova una abbreviazione: si decompone la linea
			String primaParte = input.substring(0, trovataA);
			String parteDiMezzo = input.substring(trovataA, trovataA + abbreviazione.length());
			String parteRestante = input.substring(trovataA + abbreviazione.length());

			// Può essere parte della parola: si controlla quindi che i caratteri proma e dopo non sono lettere o cifre
			Character prima = '+';
			if (primaParte.length() > 0) {
				prima = primaParte.charAt(primaParte.length() - 1);
			}

			Character dopo = '+';
			if (parteRestante.length() > 0) {
				dopo = parteRestante.charAt(0);
			}

			if (Character.isLetter(prima) || Character.isLetter(dopo) || Character.isDigit(prima)
					|| Character.isDigit(dopo)) {

				// Trovata nel mezzo di una parola: non viene inserita all'interno di <>
				// Inizia nuovamente la ricerca 
				// Consideriamo che qaulsiasi cosa che e' una lettere o una cifra
				// e' legale per una parola e quindi non la sostituiamo
				trovataA = elaborata.indexOf(abbreviazione, trovataA + 1);

			} else {
				// trovata l'abbreviazione
				risultato = risultato + primaParte + "<" + parteDiMezzo + ">";

				// processa iol resto dell'input
				input = input.substring(trovataA + abbreviazione.length());
				elaborata = elaborata.substring(trovataA + abbreviazione.length());
				trovataA = elaborata.indexOf(abbreviazione);
			}
		}

		risultato = risultato + input;
		return risultato;
	}
}
