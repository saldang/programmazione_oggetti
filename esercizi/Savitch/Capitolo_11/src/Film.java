
public abstract class Film {
	private int ID;
	private String titolo;

	public Film() {
		this(0, "");

	}

	public Film(int ID, String title) {
		setID(ID);
		setTitolo(title);
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public boolean equals(Object altro) {
		if (altro == null)
			return false;
		if (this == altro)
			return true;
		if (getClass() != altro.getClass())
			return false;
		Film altroFilm = (Film) altro;
		if (altroFilm.getID() == this.getID())
			return true;

		return false;
	}

	public abstract double calcolaPenaleRitardo(int giorniRitardo);
}
