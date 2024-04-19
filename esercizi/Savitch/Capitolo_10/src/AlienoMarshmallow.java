public class AlienoMarshmallow extends Alieno {
	public static final int DANNO_ALIENO_MARSHMALLOW = 1;

	/**
	 * Costruttori
	 */
	public AlienoMarshmallow() {
		super();
	}

	public AlienoMarshmallow(int salute, String nome) {
		super(salute, nome);
	}

	/**
	 * restituisce il danno che l'alieno può infliggere
	 */
	public int getDanno() {
		return DANNO_ALIENO_MARSHMALLOW;
	}
}