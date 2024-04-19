import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Rete {
	public static void main(String[] args) {
		// Una mappa che ha come chiave il nome utente e come elemento l'utente
		// associato
		HashMap<String, Utente> utenti = new HashMap<String, Utente>();

		// Per prima cosa carica il file della rete
		try {
			Scanner inputStream = new Scanner(new FileInputStream("rete.txt")); 

			while (inputStream.hasNextLine()) {
				String linea = inputStream.nextLine();
				StringTokenizer lineaToken = new StringTokenizer(linea);
				// Legge due token dalla linea
				String nomeUtente = lineaToken.nextToken();
				String amico = lineaToken.nextToken();
				// Aggiunge l'utente se non ancora presente
				if (!utenti.containsKey(nomeUtente)) {
					utenti.put(nomeUtente, new Utente(nomeUtente));
				}
				if (!utenti.containsKey(amico)) {
					utenti.put(amico, new Utente(amico));
				}
				// Recupera l'oggetto di tipo Uente e aggiunge l'amico
				Utente utente = utenti.get(nomeUtente);
				Utente amicoUtente = utenti.get(amico);
				utente.aggiungiAmico(amicoUtente);
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Il file non e' stato trovato o non puo' essere aperto");			
		} catch (IOException e) {
			System.out.println("Errore in lettura del file.");
		}

		// Output what we loaded
		System.out.print("Utente caricato: ");
		for (Utente u : utenti.values()) {
			System.out.print(u.getNome() + " ");
			
			for (Object f : u.getAmiciArray()) { 
				Utente friendObj = (Utente) f;
				System.out.print(friendObj.getNome() + " "); 
			} 
			System.out.println();
		}
		System.out.println();

		// Permette di inserire un nome e quindi stampa
		// gli amici fino al secondo collegamento
		String nome = "";
		Scanner tastiera = new Scanner(System.in);
		do {
			System.out.println("Inserisci il nome di un amico.");
			System.out.println("Verranno mostrati tutti gli amici fino al livello due.");
			System.out.println("Premi invio per terminare.");
			nome = tastiera.nextLine();
			if (utenti.containsKey(nome)) {
				System.out.println("Amici di " + nome);
				Utente u = utenti.get(nome);
				u.mostraAmici(2); // Stampa fino al livello 2
			} else if (!nome.equals("")) {
				System.out.println("Nome non trovato.");
			}
		} while (!nome.equals(""));
	}
} 
