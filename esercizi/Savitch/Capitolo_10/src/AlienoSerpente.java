public class AlienoSerpente extends Alieno {
	public static final int DANNO_ALIENO_SERPENTE = 10;

	/**
	 * Costruttori
	 */
	public AlienoSerpente() {
		super();
	}

	public AlienoSerpente(int salute, String nome) {
		super(salute, nome);
	}

	/**
	 * restituisce il danno che l'alieno può infliggere
	 */
	public int getDanno() {
		return DANNO_ALIENO_SERPENTE;
	}
}
