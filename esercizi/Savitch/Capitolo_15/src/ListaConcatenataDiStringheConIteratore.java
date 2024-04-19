
/**
Lista concatenata con iteratore. Un nodo e' il "nodo corrente."
Inizialmente, il nodo corrente e' il primonodo. Puo' essere cambiato
con il nodo successivo finche' l'iterazione non va oltre la fine
della lista.
*/
public class ListaConcatenataDiStringheConIteratore {
	private NodoLista testa;
	private NodoLista corrente;
	private NodoLista precedente;

	public ListaConcatenataDiStringheConIteratore() {
		testa = null;
		corrente = null;
		precedente = null;
	}

	public void aggiungiNodoInTesta(String datiDaAggiungere) {
		testa = new NodoLista(datiDaAggiungere, testa);
		if ((corrente == testa.collegamento) && (corrente != null))
			//Se corrente � al vecchio nodo di testa
			precedente = testa;
	}

	/**
	Imposta l'iteratore all'inizio della lista.
	*/
	public void reimpostaIterazione() {
		corrente = testa;
		precedente = null;
	}

	/**
	Restituisce vero se l'iterazione non � terminata.
	*/
	public boolean altriElementi() {
		return corrente != null;
	}

	/**
	Sposta l'iteratore al nodo successivo.
	*/
	public void vaiAlSuccessivo() {
		if (corrente != null) {
			precedente = corrente;
			corrente = corrente.collegamento;
		} else if (testa != null) {
			System.out.println("Si e� iterato troppe volte o l'iterazione non e� stata inizializzata.");
			System.exit(0);
		} else {
			System.out.println("Si sta iterando su una lista vuota.");
			System.exit(0);
		}
	}

	/**
	Restituisce i dati del nodo corrente.
	*/
	public String getDatiDaNodoCorrente() {
		String risultato = null;
		if (corrente != null)
			risultato = corrente.dati;
		else {
			System.out.println("Si sta richiedendo i dati quando corrente non e� posizionato su nessun nodo.");
			System.exit(0);
		}
		return risultato;
	}

	/**
	Sostituisce i dati al nodo corrente.
	*/
	public void impostaDatiANodoCorrente(String nuoviDati) {
		if (corrente != null) {
			corrente.dati = nuoviDati;
		} else {
			System.out.println("Si sta impostando i dati quando corrente non e� posizionato su nessun nodo.");
			System.exit(0);
		}
	}

	/**
	Inserisce un nuovo nodo che contiene nuoviDati dopo il nodo corrente.
	Il nodo corrente � uguale a quello prima dell'invocazione.
	Precondizione: La lista non � vuota; il nodo corrente non � oltre la
       fine della lista.
	*/
	public void inserisciDopoNodoCorrente(String nuoviDati) {
		NodoLista nuovoNodo = new NodoLista();
		nuovoNodo.dati = nuoviDati;
		if (corrente != null) {
			nuovoNodo.collegamento = corrente.collegamento;
			corrente.collegamento = nuovoNodo;
		} else if (testa != null) {
			System.out.println("Si sta inserendo quando iteratore ha visitato tutti i nodi o non e� stato inizializzato.");
			System.exit(0);
		} else {
			System.out.println("Si sta utilizzando inserisciDopoNodoCorrente con una lista vuota.");
			System.exit(0);
		}
	}

	/**
	Elimina il nodo corrente. Dopo l'invocazione,
	il nodo corrente � o il nodo successivo a quello eliminato
	o null se non c'� nessun nodo successivo.
	 */
	public void eliminaNodoCorrente() {
		if ((corrente != null) && (precedente != null)) {
			precedente.collegamento = corrente.collegamento;
			corrente = corrente.collegamento;
		} else if ((corrente != null) && (precedente == null)) {
			//Al nodo di testa
			testa = corrente.collegamento;
			corrente = testa;
		} else {//corrente == null
			System.out.println("Si sta eliminando un nodo corrente non inizializzato o la lista e� vuota.");
			System.exit(0);
		}
	}

	/**
	Mostra i dati della lista
	*/
	public void mostraLista() {
		NodoLista posizione = testa;
		while (posizione != null) {
			System.out.println(posizione.dati);
			posizione = posizione.collegamento;
		}
	}

	/**
	Restituisce il numero di nodi sulla lista.
	*/
	public int lunghezza() {
		int conteggio = 0;
		NodoLista posizione = testa;
		while (posizione != null) {
			conteggio++;
			posizione = posizione.collegamento;
		}
		return conteggio;
	}
	
	/**
	Va a vedere se elemento � nella lista.
	*/
	public boolean nellaLista(String elemento) {
		return trova(elemento) != null;
	}
	
	// Restituisce un riferimento al primo nodo che contiene 
	// i dati elemento. Se Se l'elemento non � nella lista, restituisce
	// null.
	private NodoLista trova(String elemento) {
		boolean trovato = false;
		NodoLista posizione = testa;
		while ((posizione != null) && !trovato) {
			String datiAllaPosizione = posizione.dati;
			if (datiAllaPosizione.equals(elemento))
				trovato = true;
			else
				posizione = posizione.collegamento;
		}
		return posizione;
	}
	
	/**
	Restituisce un array degli elementi presenti nella lista.
	*/
	public String[] convertiInArray() {
		String[] unArray = new String[lunghezza()];
		NodoLista posizione = testa;
		int i = 0;
		while (posizione != null) {
			unArray[i] = posizione.dati;
			i++;
			posizione = posizione.collegamento;
		}
		return unArray;
	}
	
	private class NodoLista {
		private String dati;
		private NodoLista collegamento;
		
		public NodoLista() {
			collegamento = null;
			dati = null;
		}
		
		public NodoLista(String nuoviDati, 
                              NodoLista valoreCollegamento) {
			dati = nuoviDati;
			collegamento = valoreCollegamento;
		}
	}		
}
