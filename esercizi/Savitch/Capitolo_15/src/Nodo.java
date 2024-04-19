public class Nodo {
	private char ID;
	private Nodo nord, sud, est, ovest;

	public Nodo() {
	}

	public Nodo(char newID) {
		ID = newID;
	}

	public char getID() {
		return ID;
	}

	public Nodo getNord() {
		return nord;
	}

	public Nodo getSud() {
		return sud;
	}

	public Nodo getEst() {
		return est;
	}

	public Nodo getOvest() {
		return ovest;
	}

	public void setConnessioni(Nodo nord, Nodo sud, Nodo est, Nodo ovest) {
		this.nord = nord;
		this.sud = sud;
		this.est = est;
		this.ovest = ovest;
	}
}