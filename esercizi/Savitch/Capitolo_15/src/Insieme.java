import java.util.NoSuchElementException;

// Utilizza una lista concatenata come struttura dati
// interna per immagazzinare gli elementi di un insieme
public class Insieme<T> {
	private class Nodo<T> {
		private T dati;
		private Nodo<T> collegamento;

		public Nodo() {
			dati = null;
			collegamento = null;
		}
		public Nodo(T nuoviDati, Nodo<T> valoreCollegamento) {
			dati = nuoviDati;
			collegamento = valoreCollegamento;
		}
	} // Fine della inner class Nodo<T>

	
	
	/**
	 * Un semplice iteratore in avanti per la classe Insieme
	 */
	public class InsiemeIterator {
		private Nodo<T> posizione;
		private Nodo<T> precedente; //valore precedente di posizone

		public InsiemeIterator() {
			posizione = Insieme.this.testa; // Variabile di istanza testa della outer class
			precedente = null;
		}

		public void restart() {
			posizione = testa; // Variabile di istanza testa della outer class
			precedente = null;
		}

		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();

			T daRestituire = posizione.dati;
			precedente = posizione;
			posizione = posizione.collegamento;
			return daRestituire;
		}

		public boolean hasNext() {
			return (posizione != null);
		}

		/**
		 * Aggiunge un nuovo nodo prima del nodo alla posizone corrente.
		 * Il nodo alla posizone corrente viene spostato in avanti
		 * Se hasNext( ) restituisce false, il nodo e' aggiunto
		 * alla fine della lista. Se la lista e' vuota, aggiunge il nodo comunque
		 */
		public void aggiungiQui(T nuoviDati) {
			if (posizione == null && precedente != null)
				// se alla fine della lista
				precedente.collegamento = new Nodo<T>(nuoviDati, null);
			else if (posizione == null || precedente == null)
				// se la lista e' vuota o posizione e' alla testa
				Insieme.this.aggiungi(nuoviDati);
			else { // precedente e posizone sono collocate a due nodi consecutivi
				Nodo<T> temp = new Nodo<T>(nuoviDati, posizione);
				precedente.collegamento = temp;
				precedente = temp;
			}
		}

		/**
		 * Cambia i dati alla posizone corrente. Se la posizone corrente non punta 
		 * ad un nodo lancia una eccezione di tipo IllegalStateException
		 */
		public void cambiaQui(T nuoviDati) {
			if (posizione == null)
				throw new IllegalStateException();
			else
				posizione.dati = nuoviDati;
		}

		/**
		 * CAncella il nodo in posizone a muove posizione al prossimo nodo.
		 * LAncia un'eccezione di tipo IllegalStateException se la lista e' vuota..
		 */
		public void cancella() {
			if (posizione == null)
				throw new IllegalStateException();
			else if (precedente == null) {// rimuove il nodo alla testa
				testa = testa.collegamento;
				posizione = testa;
			} else { //precedente e posizione puntano a due nodi.
				precedente.collegamento = posizione.collegamento;
				posizione = posizione.collegamento;
			}
		}
	}// Fine della classe InsiemeIteratore
	
	
	
	////////////////////////////////////////
	
	private Nodo<T> testa;

	public Insieme() {
		testa = null;
	}

	/**
	Aggiunge un nuovo elemento all'insieme.
	Se l'elemento � gi� presente, restituisce false,
	altrimenti restituisce true.
	*/
	public boolean aggiungi(T nuovoElemento) {
		if (!nellInsieme(nuovoElemento)) {
			testa = new Nodo<T>(nuovoElemento, testa);
			return true;
		}
		return false;
	}

	public boolean nellInsieme(T elemento) {
		Nodo<T> posizione = testa;
		T elementoAllaPosizione;

		while (posizione != null) {
			elementoAllaPosizione = posizione.dati;
			if (elementoAllaPosizione.equals(elemento))
				return true;
			posizione = posizione.collegamento;
		}
		return false; // l'elemento non � stato trovato
	}

	public void mostraInsieme() {
		Nodo<T> posizione = testa;
		while (posizione != null) {
			System.out.print(posizione.dati.toString() + " ");
			posizione = posizione.collegamento;
		}
		System.out.println();
	}

	/**
	Restituisce un nuovo insieme corrispondente all'unione
	dell'insieme con l'insieme specificato.
	*/
	public Insieme<T> unione(Insieme<T> altroInsieme) {
		Insieme<T> insiemeUnione = new Insieme<T>();
		// Copia l'insieme corrente nell'unione
		Nodo<T> posizione = testa;
		while (posizione != null) {
			insiemeUnione.aggiungi(posizione.dati);
			posizione = posizione.collegamento;
		}

		// Copia l'altro insieme nell'unione.
		// Il metodo aggiungi elimina automaticamente
		// i duplicati.
		posizione = altroInsieme.testa;
		while (posizione != null) {
			insiemeUnione.aggiungi(posizione.dati);
			posizione = posizione.collegamento;
		}
		return insiemeUnione;
	}

	/**
	Restituisce un nuovo insieme corrispondente all'intersezione
	tra l'insieme e l'insieme specificato.
	*/
	public Insieme<T> intersezione(Insieme<T> altroInsieme) {
		Insieme<T> insiemeIntersezione = new Insieme<T>();
		// Copia solo gli elementi presenti in entrambi
		// gli insiemi.
		Nodo<T> posizione = testa;
		while (posizione != null) {
			if (altroInsieme.nellInsieme(posizione.dati))
				insiemeIntersezione.aggiungi(posizione.dati);
			posizione = posizione.collegamento;	
		}
		return insiemeIntersezione;
	}

	public int numeroElementi() {
		int conteggio = 0;
		Nodo<T> posizione = testa;
		while (posizione != null) {
			conteggio++;
			posizione = posizione.collegamento;
		}
		return conteggio;
	}
	
	/**
	 * iterator Returns an iterator to the set.
	 */
	public InsiemeIterator iterator() {
		return new InsiemeIterator();
	}

	/**
	 * itera la lista e rimuove il primo elemento che e' uguale a item
	 * Assume che il metodo equals sia definito nella classe T
	 */
	public void rimuovi(T item) {
		Nodo<T> posizione = testa;
		Nodo<T> precedente = null;
		T itemAtPosition;
		while (posizione != null) {
			itemAtPosition = posizione.dati;
			if (itemAtPosition.equals(item)) {
				// Cancella questo elemento
				if (precedente == null) {
					// Cancelliamo la testa
					testa = testa.collegamento;
				} else {
					// Cancelliamo un elemento dopo testa
					precedente.collegamento = posizione.collegamento;
				}
				return;
			}
			precedente = posizione;
			posizione = posizione.collegamento;
		}
	}
	
}
