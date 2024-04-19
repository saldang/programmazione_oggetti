import java.io.*;
import java.util.*;

public class StudioUccelli {

	private NodoLista testa;

	public StudioUccelli() {
		testa = null;
	}

	/**
	 * Mostra i dati nella lista
	 */
	public void getReport() {
		NodoLista posizione = testa;
		while (posizione != null) {
			System.out.println(posizione.nome + " ha " + posizione.conteggio);
			posizione = posizione.collegamento;
		}
	}

	/**
	 * Restituisce il numero di nodi nella lista
	 */
	public int lunghezza() {
		int count = 0;
		NodoLista posizione = testa;
		while (posizione != null) {
			count++;
			posizione = posizione.collegamento;
		}
		return count;
	}

	/**
	 * Aggiunge un nodo contenente il nomeUccello in testa ala listaAdds a node
	 * containing the data birdName at the start of the list.
	 */
	private void aggiungiNodoAllInizio(String uccello) {
		testa = new NodoLista(uccello, testa);
	}

	/**
	 * Aggiunge un nodo che contine il dato uccello alla fine della lista
	 */
	public void aggiungi(String uccello) {
		if (testa == null)
			// se la lista e' vuota lo aggiunge in testa
			aggiungiNodoAllInizio(uccello);
		else {
			NodoLista nodo = cerca(uccello);
			if (nodo != null) {
				nodo.conteggio++;
			} else {
				NodoLista scout = testa;
				// trova l'ultimo elemento della lista
				while (scout.collegamento != null) {
					scout = scout.collegamento;
				}
				// Aggiunge il nodo
				NodoLista creato = new NodoLista(uccello, null);
				scout.collegamento = creato;
			}
		}
	}

	public int getContatore(String uccello) {
		int risultato;

		NodoLista nodo = cerca(uccello);
		if (nodo == null)
			risultato = 0;
		else
			risultato = nodo.conteggio;

		return risultato;
	}

	/**
	 * Verifica se l'uccello e' nella lista
	 */
	public boolean onList(String uccello) {
		return cerca(uccello) != null;
	}

	// Restituisce un riferimento al primo nodo che contiene l'elemento cercato
	private NodoLista cerca(String uccello) {
		boolean trovato = false;
		NodoLista posizione = testa;
		while ((posizione != null) && !trovato) {
			String dataAtPosition = posizione.nome;
			if (dataAtPosition.equals(uccello))
				trovato = true;
			else
				posizione = posizione.collegamento;
		}
		return posizione;
	}

	private class NodoLista {
		private String nome;
		private int conteggio;
		private NodoLista collegamento;

		public NodoLista(String newName, NodoLista linkValue) {
			nome = newName;
			conteggio = 1;
			collegamento = linkValue;
		}
	}

	public static void main(String[] args) {

		StudioUccelli uccelli = new StudioUccelli();

		Scanner tastiera = new Scanner(System.in);

		System.out.println("Inserisci i nomi degli uccelli");
		System.out.println("Scrivi fatto quando hai terminato");

		boolean ancoraDati = true;
		while (ancoraDati) {
			String nome = tastiera.next();
			if (nome.equals("fatto")) {
				ancoraDati = false;
			} else {
				uccelli.aggiungi(nome);
			}
		}

		// Mostra il report degli uccelli visti
		System.out.println("Resoconto degli uccelli avvistati:");
		uccelli.getReport();
	}
}
