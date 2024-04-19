/**
 * Class for the Ogre Alien
 */
public class AlienoOrco extends Alieno {
	public static final int DANNO_ALIENO_ORCO = 6;

	/**
	 * Costruttori
	 */
	public AlienoOrco() {
		super();
	}

	public AlienoOrco(int salute, String nome) {
		super(salute, nome);
	}

	/**
	 * restituisce il danno che l'alieno può infliggere
	 */
	public int getDanno() {
		return DANNO_ALIENO_ORCO;
	}
} 