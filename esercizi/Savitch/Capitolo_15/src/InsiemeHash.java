import java.util.NoSuchElementException;

//usa una hash table come struttura dati interna 
public class InsiemeHash<T> {

	private ListaConcatenata[] arrayHash;
	private int size = 10;

	public InsiemeHash() {
		arrayHash = new ListaConcatenata[size];
		for (int i = 0; i < size; i++)
			arrayHash[i] = new ListaConcatenata<T>();
	}

	/**
	 * Aggiunge un nuovo elemento all'insieme. Se l'elemento e' gia' presente,
	 * restituisce false, altrimenti restituisce true.
	 */
	public boolean aggiungi(T nuovoElemento) {
		int hash = calcolaHash(nuovoElemento.toString()); // Ottiene il valore di hash
		ListaConcatenata list = arrayHash[hash];
		if (!list.nellaLista(nuovoElemento)) {
			// Aggiunge nuovoElemento se non e' presente nella lista
			arrayHash[hash].aggiungiNodoInTesta(nuovoElemento);
			return true;
		}
		return false;
	}

	// Calcola l'hash
	private int calcolaHash(String s) {
		int hash = 0;
		for (int i = 0; i < s.length(); i++) {
			hash += s.charAt(i);
		}
		return hash % size;
	}

	public boolean nellInsieme(T elemento) {
		int hash = calcolaHash(elemento.toString());
		ListaConcatenata list = arrayHash[hash];
		if (list.trova(elemento) == null)
			return false;
		return true;
	}

	public void mostraInsieme() {
		for (int i = 0; i < size; i++) {
			ListaConcatenata list = arrayHash[i];
			if (list != null) {
				list.mostraLista();
				;
			}
		}
	}

	/**
	 * Restituisce un nuovo insieme corrispondente all'unione dell'insieme con
	 * l'insieme specificato.
	 */
	public InsiemeHash<T> unione(InsiemeHash<T> altroInsieme) {
		InsiemeHash<T> insiemeUnione = new InsiemeHash<T>();
		// Copia questo insieme in insiemeUnione
		for (int i = 0; i < size; i++) {
			ListaConcatenata list = arrayHash[i];
			ListaConcatenata<T>.NodoLista iter = list.getTesta();
			while (iter != null) {
				insiemeUnione.aggiungi(iter.getDati());
				iter = iter.getCollegamento();
			}
		}

		// Copia l'altro insieme nell'unione.
		// Il metodo aggiungi elimina automaticamente
		// i duplicati.
		for (int i = 0; i < size; i++) {
			ListaConcatenata list = altroInsieme.arrayHash[i];
			ListaConcatenata<T>.NodoLista iter = list.getTesta();
			while (iter != null) {
				insiemeUnione.aggiungi(iter.getDati());
				iter = iter.getCollegamento();
			}
		}
		return insiemeUnione;
	}

	/**
	 * Restituisce un nuovo insieme corrispondente all'intersezione tra l'insieme e
	 * l'insieme specificato.
	 */
	public InsiemeHash<T> intersezione(InsiemeHash<T> altroInsieme) {
		InsiemeHash<T> insiemeIntersezione = new InsiemeHash<T>();
		// Copia solo gli elementi presenti in entrambi
		// gli insiemi.
		for (int i = 0; i < size; i++) {
			ListaConcatenata list = altroInsieme.arrayHash[i];
			ListaConcatenata<T>.NodoLista iter = list.getTesta();
			while (iter != null) {
				if (altroInsieme.nellInsieme(iter.getDati())) {
					altroInsieme.aggiungi(iter.getDati());
				}
				iter = iter.getCollegamento();
			}
		}
		return insiemeIntersezione;
	}

	/*
	 * public int numeroElementi() { int conteggio = 0; Nodo<T> posizione = testa;
	 * while (posizione != null) { conteggio++; posizione = posizione.collegamento;
	 * } return conteggio; }
	 * 
	 * 
	 * 
	 *//**
		 * itera la lista e rimuove il primo elemento che e' uguale a item Assume che il
		 * metodo equals sia definito nella classe T
		 *//*
			 * public void rimuovi(T item) { Nodo<T> posizione = testa; Nodo<T> precedente =
			 * null; T itemAtPosition; while (posizione != null) { itemAtPosition =
			 * posizione.dati; if (itemAtPosition.equals(item)) { // Cancella questo
			 * elemento if (precedente == null) { // Cancelliamo la testa testa =
			 * testa.collegamento; } else { // Cancelliamo un elemento dopo testa
			 * precedente.collegamento = posizione.collegamento; } return; } precedente =
			 * posizione; posizione = posizione.collegamento; } }
			 */

}
