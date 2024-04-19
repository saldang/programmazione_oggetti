import java.util.*;

public class ContaLettere {
	public static void main(String[] args) {
		Scanner tastiera;
		String linea = null;
		int lunghezzaLinea;
		int[] conteggioLettere = new int[26];
		char risposta = 's';
		while (risposta == 's' || risposta == 'S') {
			// Crea un nuovo Scanner all'interno del loop per evitare possibili problemi con
			// l'uso ripetuto di nextLine()
			tastiera = new Scanner(System.in);

			// Pulisce l'array di caratteri
			for (int i = 0; i < 26; i++)
				conteggioLettere[i] = 0;

			// Ottiene la linea di testo
			System.out.println("Inserisci una linea di testo con un punto al termine ");
			linea = tastiera.nextLine();
			lunghezzaLinea = linea.length();

			// Conta le lettere e termina quanto trova un punto o la fine della linea
			int indiceLinea = 0;
			char prossimoCarattere = ' '; // impostatoper entrare nel ciclo
			int indiceAlfabetico;
			while (indiceLinea < lunghezzaLinea && prossimoCarattere != '.') {
				prossimoCarattere = linea.charAt(indiceLinea);
				if (!Character.isWhitespace(prossimoCarattere) && prossimoCarattere != '.') {
					// Converte a lettera maisucola cosi' da non preoccuparsi del minuscolo e maiuscolo
					prossimoCarattere = Character.toUpperCase(prossimoCarattere);
					indiceAlfabetico = indiceAlfabeto(prossimoCarattere);
					// Incrementa il conteggio solo per le lettere
					if (indiceAlfabetico >= 0 && indiceAlfabetico < 26)
						conteggioLettere[indiceAlfabetico]++;
				}
				indiceLinea++;
			}
			// Mostra i risultati
			for (int i = 0; i < 26; i++) {
				if (conteggioLettere[i] != 0)
					System.out.println((char) (i + 65) + " " + conteggioLettere[i]);
			}
			System.out.println("Vuoi inserire un'altra linea? (s per 'si')");
			risposta = tastiera.next().charAt(0);
		}
	}

	public static int indiceAlfabeto(char lettera) {
		int indiceLettera;
		indiceLettera = (int) lettera - (int) 'A';
		return indiceLettera;
	}
}
