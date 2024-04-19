/* Implementa Comparable cosi' che possa essere usata dalla classe  ListaConcatenata */
public class Elemento implements Comparable {
	private String elemento;
	private int conteggio;

	public Elemento(String itemData, int countData) {
		elemento = itemData;
		conteggio = countData;
	}

	public String toString() {
		return (elemento + " " + conteggio);
	}

	/**
	 * Questo metodo deve essere implementao poiche' la classe implementa Comparable
	 * Il metodo compara le due stringhe memorizzate nell'attributo elemento
	 */
	public int compareTo(Object altroOggetto) throws ClassCastException {
		if (altroOggetto == null)
			throw new ClassCastException("E' atteso un oggetto.");
		else if (getClass() != altroOggetto.getClass())
			throw new ClassCastException("E' atteso un oggetto.");
		else {
			Elemento otherEntry = (Elemento) altroOggetto;
			return (elemento.compareTo(otherEntry.elemento));
		}
	}

	public boolean equals(Object altroOggetto) {
		if (altroOggetto == null)
			return false;
		else if (getClass() != altroOggetto.getClass())
			return false;
		else {
			Elemento otherEntry = (Elemento) altroOggetto;
			return (elemento.equals(otherEntry.elemento) && (conteggio == otherEntry.conteggio));
		}
	}

	// Andrebbero inseriti i costruttori e i metodi di get e set
}