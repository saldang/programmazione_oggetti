
public class ListaConcatenataDiDipendentiAutoContenuta {
	private NodoLista testa;

	public ListaConcatenataDiDipendentiAutoContenuta() {
		testa = null;
	}

	/**
	 * Restituisce il numero di nodi sulla lista.
	 */
	public int lunghezza() {
		int count = 0;
		NodoLista position = testa;
		while (position != null) {
			++count;
			position = position.collegamento;
		}
		return count;
	}

	/**
	 * Aggiunge in testa un nodo contenente i dati dipendente all'inizio della
	 * lista.
	 */
	public void aggiungiNodoInTesta(Dipendente dipendente) {
		testa = new NodoLista(dipendente, testa);
	}

	public void eliminaNodoDiTesta() {
		if (testa != null)
			testa = testa.collegamento;
		else {
			System.out.println("Si sta eliminando da una lista vuota.");
			System.exit(0);
		}
	}

	public boolean nellaLista(String targetSSN) {
		return (trova(targetSSN) != null);
	}

	/**
	 * Restituisce un riferimento al primo nodo che contiene i dati elemento. Se
	 * l'elemento non e' nella lista, restituisce null
	 */
	private NodoLista trova(String elemento) {
		NodoLista posizione = testa;
		String posizoneId = null;
		while (posizione != null) {
			posizoneId = posizione.dati.getId();
			if (posizoneId.equals(elemento))
				return posizione;
			posizione = posizione.collegamento;
		}
		return null; // elemento non e' stato trovato
	}

	public void mostra() {
		NodoLista posizione;
		posizione = testa;
		NodoLista dataAllaPosizione;
		while (posizione != null) {
			System.out.println(posizione.dati);
			posizione = posizione.collegamento;
		}
	}

	public Dipendente[] convertiInArray() {
		Dipendente a[] = new Dipendente[lunghezza()];
		NodoLista posizione;
		posizione = testa;
		int i = 0;
		while (posizione != null) {
			a[i] = posizione.dati;
			++i;
			posizione = posizione.collegamento;
		}
		return a;
	}

	private class NodoLista {
		private Dipendente dati;
		private NodoLista collegamento;

		public NodoLista() {
			collegamento = null;
			dati = null;
		}

		public NodoLista(Dipendente newData, NodoLista linkValue) {
			dati = newData;
			collegamento = linkValue;
		}
	}

}