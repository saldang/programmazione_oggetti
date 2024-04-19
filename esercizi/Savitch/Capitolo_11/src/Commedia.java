
public class Commedia extends Film {
	public Commedia() {
		super();
	}

	public Commedia(int ID, String titolo) {
		super(ID, titolo);
	}

	public double calcolaPenaleRitardo(int giorniRitardo) {
		return (2.5 * giorniRitardo);
	}
}
