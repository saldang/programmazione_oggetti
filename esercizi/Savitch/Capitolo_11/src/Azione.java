
public class Azione extends Film {
	
	public Azione() {
		super();
	}

	public Azione(int ID, String titolo) {
		super(ID, titolo);
	}

	public double calcolaPenaleRitardo(int giorniRitardo) {
		return (3.0 * giorniRitardo);
	}
}
