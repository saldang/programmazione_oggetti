
import java.util.ArrayList;

public class ListaConcatenataProgetto6<E extends Comparable> {
	private NodoLista<E> testa;

	public ListaConcatenataProgetto6() {
		testa = null;
	}

	public void aggiungiNodoInTesta(E datiDaAggiungere) {
		testa = new NodoLista<E>(datiDaAggiungere, testa);
	}

	/**
	 * Aggiunge un nodo alla lista in modo che la lista sia ordinata. Questo viene
	 * fatto cercando un nodo il cui valore è maggiore del nuovo elemento da
	 * inserire. Il nuovo elemento viene quindi posizionato prima del nodo maggiore.
	 */
	public void aagiungiInOrdine(E datiDaAggiungere) {
		if (testa == null) {
			// Aggiunge il primo nodo
			testa = new NodoLista<E>(datiDaAggiungere, testa);
		} else {
			// Cerca un nodo dove i nuovi dati sono maggiori dei dati correnti e inserisci
			// tra un nodo e l'altro.
			NodoLista<E> precedente = null;
			NodoLista<E> corrente = testa;
			E elementoAllaPosizione;
			while (corrente != null) {
				elementoAllaPosizione = corrente.dati;
				if (elementoAllaPosizione.compareTo(datiDaAggiungere) >= 0) {
					// L'elemento da aggiungere dovrebbe essere inserito prima dell'elemento nella
					// posizone elementoAllaPosizione.
					// Ma controlla che sia o meno la testa della lista
					if (precedente == null) {
						// Inserisce alla testa
						testa = new NodoLista<E>(datiDaAggiungere, testa);
						break;
					} else {
						// Inserisce in un altro posto diverso dalla testa e dalla coda
						NodoLista<E> newtestaNodoLista = new NodoLista<E>(datiDaAggiungere, precedente.collegamento);
						precedente.collegamento = newtestaNodoLista;
						break;
					}
				}
				// Si muove al prossimo nodo
				precedente = corrente;
				corrente = corrente.collegamento;
			}
			// Se si raggiunge la fine della lista, aggiunge in coda
			if (corrente == null) {
				NodoLista<E> newtestaNodoLista = new NodoLista<E>(datiDaAggiungere, null);
				precedente.collegamento = newtestaNodoLista;
			}
		}
	}

	/**
	 * Elimina il primo nodo sulla lista.
	 */
	public void eliminaNodoDiTesta() {
		if (testa != null)
			testa = testa.collegamento;
		else {
			System.out.println("Si sta eliminando da una lista vuota.");
			System.exit(0);
		}
	}

	/**
	 * Restituisce il numero di nodi sulla lista.
	 */
	public int lunghezza() {
		int conteggio = 0;
		NodoLista<E> posizione = testa;
		while (posizione != null) {
			conteggio++;
			posizione = posizione.collegamento;
		}
		return conteggio;
	}

	public boolean nellaLista(E elemento) {
		return trova(elemento) != null;
	}

	private NodoLista<E> trova(E elemento) {
		NodoLista<E> posizione = testa;
		E itemAllaPosizone;
		while ((posizione != null)) {
			itemAllaPosizone = posizione.dati;
			if (itemAllaPosizone.equals(elemento))
				return posizione;
			posizione = posizione.collegamento;
		}
		return null;
	}

	/**
	 * Trova il primo nodo contenente il target e restituisce un riferimento ai dati
	 * in quel nodo. Se il target non è nell'elenco, viene restituito null.
	 */
	public E findData(E target) {
		return trova(target).dati;
	}

	/**
	 * Mostra i dati della lista
	 */
	public void mostraLista() {
		NodoLista posizione = testa;
		while (posizione != null) {
			System.out.println(posizione.dati);
			posizione = posizione.collegamento;
		}
	}

	private class NodoLista<E> {
		private E dati;
		private NodoLista<E> collegamento;

		public NodoLista() {
			collegamento = null;
			dati = null;
		}

		public NodoLista(E nuoviDati, NodoLista<E> valoreCollegamento) {
			dati = nuoviDati;
			collegamento = valoreCollegamento;
		}
	}
}
