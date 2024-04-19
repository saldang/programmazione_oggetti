public class FilmArray {
	private String nome;
	private String punteggioMPAA;

	private int[] punteggi;

	public FilmArray() {
		punteggi = new int[5];
		for (int i = 0; i < 5; i++)
			punteggi[i] = 0;
		nome = "";
		punteggioMPAA = "";
	}

	public void setNome(String nuovoNome) {
		nome = nuovoNome;
	}

	public String getNome() {
		return nome;
	}

	public void setPunteggio(String nuovoPunteggio) {
		punteggioMPAA = nuovoPunteggio;
	}

	public String getPunteggio() {
		return punteggioMPAA;
	}

	public void aggiungiPunteggio(int num) {
		if ((num < 1) || (num > 5))
			return;

		punteggi[num - 1]++;
	}

	public double getMedia() {
		int totale = 0;
		for (int i = 0; i < 5; i++)
			totale += (i + 1) * punteggi[i];

		return totale / 5.0;

	}

	public static void main(String[] args) {
		Film m1 = new Film();
		m1.setNome("The Adjustment Bureau");
		m1.setPunteggioMPAA("PG-13");
		m1.aggiungiPunteggio(5);
		m1.aggiungiPunteggio(5);
		m1.aggiungiPunteggio(4);
		m1.aggiungiPunteggio(4);
		m1.aggiungiPunteggio(5);
		System.out.println(m1.getNome() + "," + m1.getPunteggioMPAA() + " Average rating: " + m1.getMedia());

		Film m2 = new Film();
		m2.setNome("I Am Number Four");
		m2.setPunteggioMPAA("PG-13");
		m2.aggiungiPunteggio(3);
		m2.aggiungiPunteggio(2);
		m2.aggiungiPunteggio(2);
		m2.aggiungiPunteggio(4);
		m2.aggiungiPunteggio(1);
		System.out.println(m2.getNome() + "," + m2.getPunteggioMPAA() + " Average rating: " + m2.getMedia());
	}
}
