public class NodoLista {
	private String dati;
	private NodoLista collegamento;
	
	public NodoLista() {
		collegamento = null;
		dati = null;
	}

	public NodoLista(String valoreDati, NodoLista valoreCollegamento) {
		dati = valoreDati;
		collegamento = valoreCollegamento;
	}

	public void setDati(String nuoviDati) {
		dati = nuoviDati;
	}

	public String getDati() {
		return dati;
	}

	public void setCollegamento(NodoLista nuovoCollegamento) {
		collegamento = nuovoCollegamento;
	}

	public NodoLista getCollegamento() {
		return collegamento;
	}
}
