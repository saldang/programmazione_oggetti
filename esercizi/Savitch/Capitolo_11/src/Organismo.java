public abstract class Organismo {
	protected int x, y; // Posizione nel mondo
	protected boolean mosso; // indica se si è mosso nel turno corrente
	protected int numeroTurniAffamato; // Numero di turni prima che diventi affamato
	protected Mondo mondo; // Rifrimento al mondo cosi' da aggiornarlo quando l'organismo si muove al suo interno
	
	public Organismo() {
		this(null, 0, 0);
	}

	public Organismo(Mondo mondo, int x, int y) {
		this.mondo = mondo;
		mosso = false;
		numeroTurniAffamato = 0;
		this.x = x;
		this.y = y;
		mondo.setAt(x, y, this);
	}

	public boolean getMosso() {
		return mosso;
	}

	public void setMosso(boolean mosso) {
		this.mosso = mosso;
	}

	/**
	 * Determina se l'organismo debba riprodursi o meno
	 */
	public abstract void riproduci();

	/**
	 * Determina come l'organismo si muove 
	 */
	public abstract void sposta();

	/**
	 *Determina se l'organismo ha fame
	 */
	public abstract boolean affammato();

	/**
	 * Restituisce il tipo di organismo
	 */
	public abstract String getTipo();
}
