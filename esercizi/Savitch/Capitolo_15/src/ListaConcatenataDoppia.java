public class ListaConcatenataDoppia<E> {
	private NodoLista<E> testa;
	private NodoLista<E> corrente;
	private NodoLista<E> coda;

	public ListaConcatenataDoppia() {
		testa = null;
		corrente = null;
		coda = null;
	}

	public int lunghezza() {
		int conteggio = 0;
		NodoLista<E> posizone = testa;
		while (posizone != null) {
			conteggio++;
			posizone = posizone.getCollegamento();
		}
		return conteggio;
	}

	public void aggiungiNodoInTesta(E datiDaAggiungere) {
		NodoLista<E> vecchiaTesta = testa;

		testa = new NodoLista<E>(datiDaAggiungere, null, null);

		if (coda == null) {
			coda = testa;
		}

		if (vecchiaTesta != null) {
			testa.collegamento = vecchiaTesta;
			vecchiaTesta.precedente = testa;
		}

		// se corrente è al vecchio nodo iniziale
		if (corrente == testa.collegamento && corrente != null) {
			corrente.precedente = testa;
		}
	}

	public E getDatiDaNodoCorrente() {
		if (corrente != null)
			return (corrente.dati);
		else {
			System.out.println("Si cerca di ottenere dei dati da un nodo inesistente.");
			System.exit(0);
		}
		return null;
	}

	public void reimpostaIterazione() {
		corrente = testa;
	}

	public boolean ancoraDaIterare() {
		return (corrente != null);
	}

	public void vaiAlProssimo() {
		if (corrente != null) {
			corrente = corrente.collegamento;
		} else if (testa != null) {
			System.out.println("Iterato troppe volte o iterazione non inizializzata.");
			System.exit(0);
		} else {
			System.out.println("Lista vuota.");
			System.exit(0);
		}
	}

	public void reimpostaIteratoreAlContrario() {
		corrente = coda;
	}

	public void vaiAlPrecedente() {
		if (corrente != null) {
			corrente = corrente.precedente;
		} else if (testa != null) {
			System.out.println("Iterato troppe volte o iterazione non inizializzata.");
			System.exit(0);
		} else {
			System.out.println("Lista vuota.");
			System.exit(0);
		}
	}

	/**
	 * Inserisce il nodo con nuoviDati dopo il nodo corrente
	 */
	public void inserisciNodoDopoCorrente(E nuoviDati) {
		NodoLista<E> nuovoNodo = new NodoLista<E>();
		nuovoNodo.dati = nuoviDati;
		if (coda == corrente) {
			coda = nuovoNodo;
		}

		if (corrente != null) {
			nuovoNodo.collegamento = corrente.collegamento;
			corrente.collegamento = nuovoNodo;
			nuovoNodo.precedente = corrente;
			if (nuovoNodo.collegamento != null) {
				nuovoNodo.collegamento.precedente = nuovoNodo;
			}
		} else if (testa != null) {
			System.out.println("Inserimento quando l'iteratore ha scorso tutti i nodi o non e' stato inizializzato.");
			System.exit(0);
		} else {
			System.out.println("Lista vuota.");
			System.exit(0);
		}
	}

	/**
	 * Calcella il nodo corrente. Dopo l'invocazione, il nodo corrente
	 * e' il nodo dopo quello cancellato, oppure null se non c'e' un prossimo nodo.
	 */
	public void cancellaNodoCorrente() {
		NodoLista<E> precedenteSalvato = null;

		if (coda == corrente && corrente != null) {
			coda = corrente.precedente;
		}

		if ((corrente != null) && (corrente.precedente != null)) {
			precedenteSalvato = corrente.precedente;
			corrente = corrente.collegamento;
			precedenteSalvato.collegamento = corrente;
			if (corrente != null) {
				corrente.precedente = precedenteSalvato;
			}
		} else if ((corrente != null) && (corrente.precedente == null)) {// al nodo di testa
			testa = corrente.collegamento;
			corrente = testa;
			corrente.precedente = null;
		} else {// corrente == null
			System.out.println("Lista vuota.");
			System.exit(0);
		}
	}

	public void cancellaNodoTesta() {
		if (coda == testa) {
			// solo un nodo nella lista
			coda = null;
		}

		if (testa != null) {
			testa = testa.getCollegamento();
		} else {
			System.out.println("Lista vuota.");
			System.exit(0);
		}
	}

/** Cerca l'elemento con i dati di elemento. 
 * Se viene trovato, corrente puntera' a quell'elemento e verra' restituito true.
 * Se non viene trovato, corrente e' impostato a null e verra' restituito false
 */
	public boolean cercaNellaLista(E elemento) {
		NodoLista<E> posizione = testa;
		E dataAllaPosizione;
		while (posizione != null) {
			dataAllaPosizione = posizione.getDati();
			if (dataAllaPosizione.equals(elemento)) {
				corrente = posizione;
				return true;
			}
			posizione = posizione.getCollegamento();
		}

		// elemento non e' stato trovato
		corrente = null;
		return false;
	}

	public boolean nellaLista(E elemento) {
		return (trova(elemento) != null);
	}

	private NodoLista<E> trova(E elemento) {
		NodoLista<E> posizione = testa;
		E dataAllaPosizione;
		while (posizione != null) {
			dataAllaPosizione = posizione.getDati();
			if (dataAllaPosizione.equals(elemento))
				return posizione;
			posizione = posizione.getCollegamento();
		}

		// elemento non e' stato trovato
		return null;
	}

	public void mostraLista() {
		NodoLista<E> posizione = testa;
		while (posizione != null) {
			System.out.println(posizione.getDati());
			posizione = posizione.getCollegamento();
		}
	}

	// Usata per verifica
	public void mostraStatoLista() {
		System.out.println("Testa: " + (testa == null ? "null" : testa.dati) + " Corrente: "
				+ (corrente == null ? "null" : corrente.dati) + " Coda: " + (coda == null ? "null" : coda.dati) + " "
				+ lunghezza() + " elementi");
	}

	public class NodoLista<E> {
		private E dati;
		private NodoLista<E> collegamento;
		private NodoLista<E> precedente;

		public NodoLista() {
			dati = null;
			collegamento = null;
			precedente = null;
		}

		public NodoLista(E dati, NodoLista<E> collegamento, NodoLista<E> precedente) {
			setDati(dati);
			setCollegamento(collegamento);
			setPrecedente(precedente);
		}

		public void setDati(E dati) {
			this.dati = dati;
		}

		public E getDati() {
			return dati;
		}

		public void setCollegamento(NodoLista<E> collegamento) {
			this.collegamento = collegamento;
		}

		public void setPrecedente(NodoLista<E> collegamento) {
			this.precedente = collegamento;
		}

		public NodoLista<E> getCollegamento() {
			return collegamento;
		}

		public NodoLista<E> getPrecedente() {
			return precedente;
		}
	}
}
