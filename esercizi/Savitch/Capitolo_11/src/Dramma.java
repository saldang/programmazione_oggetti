
public class Dramma extends Film {
	public Dramma() {
		super();
	}

	public Dramma(int ID, String titolo) {
		super(ID, titolo);
	}

	public double calcolaPenaleRitardo(int giorniRitardo) {
		return (2 * giorniRitardo);
	}
}
