import java.io.*;
import java.util.*;

public class CopiaFile {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		// Ottiene il nome del file di input
		System.out.println("Qual e' il file di input da cui leggere?");
		String infileName = tastiera.nextLine().trim();

		File f = new File(infileName);
		if (!f.canRead()) {
			System.out.println("Errore nell'apertura del file in lettura " + infileName);
			System.exit(0);
		}

		// Ottiene il nome del file di output
		System.out.println("Qual e' il file di output su cui scrivere?");
		String outfileName = tastiera.nextLine().trim();

		boolean necessitaNome = true;
		while (necessitaNome) {
			f = new File(outfileName);
			if (f.exists() && !f.canWrite()) {
				System.out.println("Non e' possibile scrivere sul file)");
			} else if (f.exists()) {
				System.out.println("Il file esiste gia'. Vuoi sovrascriverlo? (s)");
				String response = tastiera.nextLine().trim();
				if (response.equals("s")) {
					necessitaNome = false;
				}
			} else {
				necessitaNome = false;
			}

			if (necessitaNome) {
				System.out.println("Qual e' il file su cui scrivere?");
				outfileName = tastiera.nextLine().trim();
			}
		}

		// input file
		Scanner inputFile = null;
		try {
			inputFile = new Scanner(new File(infileName));
		} catch (FileNotFoundException ex) {
			System.out.println("Errore nell'aprire il file in lettura " + infileName);
			System.exit(0);
		}

		// output file
		PrintWriter outputFile = null;
		try {
			outputFile = new PrintWriter(new File(outfileName));
		} catch (FileNotFoundException ex) {
			System.out.println("Errore nell'aprire il file in scrittura " + outfileName);
			System.exit(0);
		}

		// Copia
		while (inputFile.hasNextLine()) {
			String line = inputFile.nextLine();
			outputFile.println(line);
		}

		inputFile.close();
		outputFile.close();

		System.out.println("Elaborazione file completata.");

	}
}
