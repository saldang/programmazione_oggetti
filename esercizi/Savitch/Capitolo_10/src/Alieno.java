public class Alieno {
	public static final int DANNO_ALIENO = 0;
	private int salute; // 0=morto, 100=piena forza
	private String nome;

	/**
	 * Costruttore di default
	 */
	public Alieno() {
		this(100, "");
	}

	/**
	 * Inizializza gli attributi
	 * @param salute La salute iniziale
	 * @param nome Il nome
	 */
	public Alieno(int salute, String nome) {
		setSalute(salute);
		setNome(nome);
	}

	// ======================
	// get e set
	// ======================

	public int getSalute() {
		return salute;
	}
	
	public void setSalute(int health) {
		this.salute = health;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * restituisce il danno che l'alieno può infliggere
	 */
	public int getDanno() {
		return DANNO_ALIENO;
	}
} 