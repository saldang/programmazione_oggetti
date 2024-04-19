public class TabellaHash<E> {

	private ListaConcatenata<E>[] arrayHash;
	private static final int DIMENSIONE = 10;

	public TabellaHash() {
		arrayHash = new ListaConcatenata[DIMENSIONE];
		for (int i = 0; i < DIMENSIONE; i++)
			arrayHash[i] = new ListaConcatenata<E>();
	}

	private int calcolaHash(String s) {
		int hash = 0;
		for (int i = 0; i < s.length(); i++) {
			hash += s.charAt(i);
		}
		return hash % DIMENSIONE;
	}

	/**
	 * Restituisce l'oggetto che matcha la query
	 * 
	 */
	public E get(String chiave, E queryObject) {
		int hash = calcolaHash(chiave);
		ListaConcatenata<E> lista = arrayHash[hash];
		if((lista.trova(queryObject) == null))
			return null;
		else
			return lista.getDati((lista.trova(queryObject)));
	}

	/**
	 * Aggiunge il nuovoElemento alla tabella di hash
	 */
	public void aggiungi(String chiave, E nuovoEleemnto) {
		int hash = calcolaHash(chiave); // Calcola il valore di hash
		ListaConcatenata<E> lista = arrayHash[hash];
		if (!lista.nellaLista(nuovoEleemnto)) {
			// Aggiunge la stringa solo se non e' gia'
			// nella lista
			arrayHash[hash].aggiungiNodoInTesta(nuovoEleemnto);
		}
	}
}
