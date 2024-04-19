import java.util.ArrayList;

public class ListaConcatenata<E> {
	private NodoLista testa;

	public ListaConcatenata() {
		testa = null;
	}

	/**
	 * Restituisce il numero di nodi sulla lista.
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
	 * Mostra i dati della lista
	 */
	public void mostraLista() {
		NodoLista posizione = testa;
		while (posizione != null) {
			System.out.println(posizione.dati);
			posizione = posizione.collegamento;
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

	public void aggiungiNodoInTesta(E datiDaAggiungere) {
		testa = new NodoLista(datiDaAggiungere, testa);
	}

	public boolean nellaLista(E elemento) {
		return trova(elemento) != null;
	}

	public NodoLista trova(E elemento) {
		boolean trovato = false;
		NodoLista posizione = testa;
		while ((posizione != null) && !trovato) {
			E datiAllaPosizione = posizione.dati;
			if (datiAllaPosizione.equals(elemento))
				trovato = true;
			else
				posizione = posizione.collegamento;
		}
		return posizione;
	}

	public ArrayList<E> convertiInArrayList() {
		ArrayList<E> lista = new ArrayList<E>(lunghezza());
		NodoLista posizione = testa;
		while (posizione != null) {
			lista.add(posizione.dati);
			posizione = posizione.collegamento;
		}
		return lista;
	}

	//passa da private a public per il Progettop 8. Per i Progetti precedenti basta provate
	public class NodoLista {
		private E dati;
		private NodoLista collegamento;

		public NodoLista() {
			collegamento = null;
			dati = null;
		}

		public NodoLista(E nuoviDati, NodoLista valoreCollegamento) {
			dati = nuoviDati;
			collegamento = valoreCollegamento;
		}
		
		//meotodi di get aggiunti per progetto 8
		public E getDati() {
			return dati;
		}
		
		public NodoLista getCollegamento() {
			return collegamento;
		}
		
	}

	// Per Progetto 7
	public E getDati(NodoLista nodo) {
		return nodo.dati;
	}
	
	//Per progetto 8
	public NodoLista getTesta() {
		return testa;
	}
}
