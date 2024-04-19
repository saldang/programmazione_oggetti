public class ListaConcatenataDiStringhe {
	private NodoLista testa;

	public ListaConcatenataDiStringhe() {
		testa = null;
	}

	/**
	Mostra i dati della lista.
	*/
	public void mostraLista() {
		NodoLista posizione = testa;
		while (posizione != null) {
			System.out.println(posizione.getDati());
			posizione = posizione.getCollegamento();
		}
	}
	
	/**
	Restituisce il numero che compongono la lista.
	*/
	public int lunghezza() {
		int conteggio = 0;
		NodoLista posizione = testa;
		while (posizione != null) {
			conteggio++;
			posizione = posizione.getCollegamento();
		}
		return conteggio;
	}

	/**
	Aggiunge all'inizio della lista 
	un nodo contenente datiDaAggiungere
	*/
	public void aggiungiNodoInTesta(String datiDaAggiungere) {
		testa = new NodoLista(datiDaAggiungere, testa);
	}
	
	/**
     * Aggiunge alla fine della lista un nodo contenente datiDaAggiungereì
     */
    public void aggiungiNodoInCoda(String aggiungiDati) {
        if(testa == null)
            // Se la lista e' vuota, aggiunge in testa
        	aggiungiNodoInTesta(aggiungiDati);
        else{
            NodoLista scout = testa;
            // in caso contrario trova la fine della lista
            while(scout.getCollegamento() != null){
                scout = scout.getCollegamento();
            }
            // Aggiunge il nodo
            NodoLista created = new NodoLista(aggiungiDati, null);
            scout.setCollegamento(created);
        }
    }

	/**
	Elimina il primo nodo sulla lista.
	*/
	public void eliminaNodoDiTesta() {
		if (testa != null)
			testa = testa.getCollegamento();
		else {
			System.out.println("Si sta eliminando da una lista vuota");
			System.exit(0);
		}
	}

	
	 /**
     * Elimina l'ultimo nodo della lista
     */
    public void deleteLastNode() {
        if (testa == null){
            System.out.println("Si tenta di cancellare da una lista vuota.");
            System.exit(0);
        } else if (testa.getCollegamento() == null){
            // Un solo nodo nella lista
        	eliminaNodoDiTesta();
        } else {
        	NodoLista scout = testa;
            // Cerca il nodo prima dell'ultimo nodo
            while(scout.getCollegamento().getCollegamento() != null)
                scout = scout.getCollegamento();
            // Scollega l'ultimo nodo
            scout.setCollegamento(null);
        }
    }
	
	/**
	Va a vedere se elemento e' nella lista.
	*/
	public boolean nellaLista(String elemento) {
		return trova(elemento) != null;
	}

	// Restituisce un riferimento al primo nodo che contiene elemento. 
	// Se elemento non � nella lista, restituisce null.
	private NodoLista trova(String elemento) {
		boolean trovato = false;
		NodoLista posizione = testa;
		while ((posizione != null) && !trovato) {
			String datiAllaPosizione = posizione.getDati();
			if (datiAllaPosizione.equals(elemento))
				trovato = true;
			else
				posizione = posizione.getCollegamento();
		}
		return posizione;
	}
}
