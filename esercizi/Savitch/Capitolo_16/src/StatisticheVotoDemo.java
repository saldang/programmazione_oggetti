import java.util.HashMap;
import java.util.Set;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StatisticheVotoDemo {
	public static void main(String[] args) {
		// Le valutazioni HashMap mappa un nome di un film
		// ad un oggetto Statischiche Voto
		HashMap<String, StatisticheVoto> punteggi = new HashMap<String, StatisticheVoto>();

		// Cerca di caricare i punteggi da un file
		try {
			Scanner inputStream = new Scanner(new FileInputStream("giudizi.txt"));

			int numeroPunteggi = 0;
			String linea = inputStream.nextLine();
			numeroPunteggi = Integer.parseInt(linea);

			// Legge in ogni valutazione quale è il nome del film seguito per primo dal
			// rating
			for (int i = 0; i < numeroPunteggi; i++) {
				String nomeFilm = inputStream.nextLine();
				linea = inputStream.nextLine();

				int punteggio = Integer.parseInt(linea);
				// Aggiunge un nuovo oggetto di tipo StatischicheVoto se non gia' presente
				if (!punteggi.containsKey(nomeFilm)) {
					StatisticheVoto rs = new StatisticheVoto();
					rs.aggiungiGiudizio(punteggio);
					punteggi.put(nomeFilm, rs);
				} else {
					StatisticheVoto rs = punteggi.get(nomeFilm);
					rs.aggiungiGiudizio(punteggio);
				}
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Il file non e' stato trovato o non puo' essere aperto");			
		} catch (IOException e) {
			System.out.println("Errore in lettura del file.");
		}

		// IItera attraverso la HashMap e stampa al emdia dei punteggi di ogni film
		Set<String> movies = punteggi.keySet();
		for (String m : movies) {
			StatisticheVoto rs = punteggi.get(m);
			double ave = rs.getSommaGiudizi() / (double) rs.getNumeroGiudizi();
			System.out.printf("%s: %d recensioni, media  %.1f/5\n", m, rs.getNumeroGiudizi(), ave);
		}

	}
} // Question 8
