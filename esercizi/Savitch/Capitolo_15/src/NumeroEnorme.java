
public class NumeroEnorme {

	/**
	 * Inner class per meorizzare le cifre in un nodo
	 */
	private class NodoCifra {
		private int cifra = 0; // Valore
		private NodoCifra next = null; // Riferiemnto alla prossima cifra
		private NodoCifra prev = null; // Riferiemnto alla cifra precedente

		/**
		 * Inizializza la cifra
		 */
		public NodoCifra(int cifra) {
			setCifra(cifra);
		}

		/* get e set */
		public int getCifra() {
			return cifra;
		}

		public void setCifra(int cifra) {
			this.cifra = cifra;
		}

		public NodoCifra getNext() {
			return next;
		}

		public void setNext(NodoCifra nextNode) {
			next = nextNode;
		}

		public NodoCifra getPrev() {
			return prev;
		}

		public void setPrev(NodoCifra prevNode) {
			prev = prevNode;
		}
	} // Fine inner class

	private NodoCifra testa = null; // Punta alla cifra piu' significativa
	private NodoCifra coda = null; // TPunta alla cifra meno significativa

	public NumeroEnorme() {
	}

	/**
	 * Aggiunge una nuova cifra
	 * 
	 * @param cifra
	 *            la nuova cifra da aggiungere
	 */
	public void aggiungiCifra(int cifra) {
		NodoCifra nuovaCifra = new NodoCifra(cifra);
		if (testa == null) {
			testa = nuovaCifra;
			coda = nuovaCifra;
		} else {
			// Fa in modo che il next della nuova cifra punti alla cifra piu' significativa
			// precedente
			nuovaCifra.setNext(testa);
			// Fa in modo che il precedente della testa punti alla nuova cifra
			testa.setPrev(nuovaCifra);
			// Imposta la testa alla nuova cifar piu' significativa
			testa = nuovaCifra;
		}
	}

	/**
	 * Reimposta testa e cosa a null
	 */
	public void reimpostaValore() {
		testa = null;
		coda = null;
	}

	public String toString() {
		if (testa == null)
			return "null";
		NodoCifra temp = testa;
		String strVal = "";

		while (temp != null) {
			strVal = strVal + temp.getCifra(); // Aggiunge in coda alla strimga i valori
			temp = temp.getNext();
		}
		return strVal;
	}
}
