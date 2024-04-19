
public class GruppoAlieni {
	private Alieno[] alieni;

	public GruppoAlieni(int numeroAlieni) {
		alieni = new Alieno[numeroAlieni];
	}

	public void aggiungiAlieno(Alieno alieno, int posizione) {
		alieni[posizione] = alieno;
	}

	public Alieno[] getAlieni() {
		return alieni;
	}

	/**
	 * Per calolare il danno, iteriamo sugli alieni ed invochiamo
	 * il metodo getDanno
	 */
	public int calcolaDanni() {
		int danno = 0;
		for (int i = 0; i < alieni.length; i++) {
			if(alieni[i] != null)
				danno += alieni[i].getDanno();
		}
		return danno;
	}
} // AlienPac