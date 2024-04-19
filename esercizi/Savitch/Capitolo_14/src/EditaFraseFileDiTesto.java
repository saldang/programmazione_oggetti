
/**
 Questo programma elabora i file di testo e crea un nuovo file con
 le seguenti correzioni grammaticali:
     1) Qualsiasi stringa di due o più spazi è sostituita da un unico spazio.
     2) Capitalizza la prima parola di ogni frase.
 Una frase è definita da un punto, da un punto interrogativo o da un punto interrogativo seguiti da uno spazio bianco.
 

Precondizioni: il file di testo ha almeno una riga.
 */
import java.io.*;
import java.util.*;

public class EditaFraseFileDiTesto {
	private static BufferedReader inputStream = null;
	private static PrintWriter outputStream = null;

	/**
	 * 1) Sostituisce le stringhe di uno o piu' caratteri bianchi con un solo carattere bianco
	 * 2) Capitalizza la prima parola nella frase
	 */
	public static void main(String[] args) {
		EditaFraseFileDiTesto editor = new EditaFraseFileDiTesto();
		editor.connettiFileInput();
		editor.connettiFileOutput();
		editor.edita();
		editor.chiudiFile();
		System.out.println("Linee editate copiate sul file di output.");
	}

	public void connettiFileInput() {
		String nomeFileInput = getNomeFile("Inserisci il nome del file di input:");
		try {
			inputStream = new BufferedReader(new FileReader(nomeFileInput));
		} catch (FileNotFoundException e) {
			System.out.println("Errore: il file di inpute " + nomeFileInput + " non e' stato trovato.");
			System.exit(0);
		}
	}

	public void connettiFileOutput() {
		String nomeFileOutput = getNomeFile("Inserisci il nome del file di output:");
		try {
			outputStream = new PrintWriter(new FileOutputStream(nomeFileOutput));
		} catch (FileNotFoundException e) {
			System.out.println("Errore: il file di inpute " + nomeFileOutput + " non e' stato trovato.");
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	private String getNomeFile(String prompt) {
		Scanner tastiera = new Scanner(System.in);
		String nomeFile = null;
		System.out.println(prompt);
		nomeFile = tastiera.next();

		return nomeFile;
	}

	public void edita() {
		String linea = null;
		int i = 0; // indice del carattere della linea corrente
		boolean rilevatoSpazio; // flag: already space after end of sentence
		boolean fineLinea; // flag: rilevata frine della linea

		try {
			linea = inputStream.readLine();

			while (linea != null)  {// Ripete fino a che non ci sono piu' linee
				// L'inizo di una linea richiede una elaborazione speciale:
				// Rimuove tutti gli spazi bianchi prima della prima parola nella linea
				// e fa si che la prima parola sia capitalizzata.

				while (linea.charAt(i) == ' ' || linea.charAt(i) == '\t' || linea.charAt(i) == '\n') {
					++i; // Next character
				}
				outputStream.write(maiuscolo(linea.charAt(i)));
				rilevatoSpazio = false;
				fineLinea = false;

				// Imposta l'indice al carattere successivo e continua l'elaborazione della riga
				// Sostituisce spazi multipli con un solo spazio.
				// Controlla se si e' raggiunti la fine della linea e in caso affermativo imposta il flag fineLinea a true in modo da capitalizzare la prossima linea


				++i; // Indice al prossimo carattere della linea
				char prossimoCarattere;
				for (/* valore corrente di i */; i < linea.length(); ++i) {
					prossimoCarattere = linea.charAt(i);
					switch (prossimoCarattere) {
					case ' ':
						if (!rilevatoSpazio) {
							outputStream.print(prossimoCarattere);
							rilevatoSpazio = true;
							// Controlla il carattere precdente (se c'e') per verificare la fine della linea (punteggiatura specifica)
							if (i > 0) {
								fineLinea = controlloLinea(linea.charAt(i - 1));
							}
						}
						break;
					case '\t':
						outputStream.print(prossimoCarattere);
						// Se fineLinea e' true, non lo cambia e se preceduto da uno spazio non occorre controllarlo
						if (!fineLinea && !rilevatoSpazio) {
							// Controlla il carattere precdente (se c'e') per verificare la fine della linea (punteggiatura specifica)
							if (i > 0) {
								fineLinea = controlloLinea(linea.charAt(i - 1));
							}
						}
						break;
					default:
						// Spazi non bianchi: resetta il flag rilevatoSpazio
						rilevatoSpazio = false;
						if (fineLinea) {
							prossimoCarattere = maiuscolo(prossimoCarattere);
							fineLinea = false;
						}
						outputStream.print(prossimoCarattere);
					} 
				} 

				outputStream.print('\n'); // Fine della linea
				linea = inputStream.readLine(); // Prossima linea
				i = 0; // Indice di inizio della linea
			}
		} catch (IOException e) {
			System.out.println("Errore nel leggere o scrivere il file.");
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	private boolean controlloLinea(char c) {
		return (c == '.' || c == '?' || c == '!');
	}

	private char maiuscolo(char c) {
		if (c >= 'a' && c <= 'z')
			return (char) (c - 32); // differenza ASCII
		else // per lettera maiuscola e minuscola
			return c; // lettera.
	}

	public void chiudiFile() {
		try {
			inputStream.close();
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Errore nel chiudere i file " + e.getMessage());
			System.exit(0);
		}
	}
}
