public class NodoDuale {
	private String dati;
	private NodoDuale collegamento1;
	private NodoDuale collegamento2;

	public NodoDuale() {
		collegamento1 = null;
		collegamento2 = null;
		dati = null;
	}

	public NodoDuale(String newData, NodoDuale collegamento1, NodoDuale collegamento2) {
		dati = newData;
		this.collegamento1 = collegamento1;
		this.collegamento2 = collegamento2;
	}

	public void setDati(String dati) {
		this.dati = dati;
	}

	public String getDati() {
		return dati;
	}

	public void setCollegamento1(NodoDuale collegamento1) {
		this.collegamento1 = collegamento1;
	}

	public void setCollegamento2(NodoDuale collegamento2) {
		this.collegamento2 = collegamento2;
	}

	public NodoDuale getCollegamento1() {
		return collegamento1;
	}

	public NodoDuale getCollegamento2() {
		return collegamento2;
	}
}
