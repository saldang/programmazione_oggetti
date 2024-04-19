public class Film {
	private String nome;
	private String punteggioMPAA;

	private int numeroValutati1 = 0, numeroValutati2 = 0, numeroValutati3 = 0, numeroValutati4 = 0, numeroValutati5 = 0;

	public void setNome(String nuovoNome) {
		nome = nuovoNome;
	}

	public String getNome() {
		return nome;
	}

	public void setPunteggioMPAA(String nuovoPunteggio) {
		punteggioMPAA = nuovoPunteggio;
	}

	public String getPunteggioMPAA() {
		return punteggioMPAA;
	}

	public void aggiungiPunteggio(int numero) {
		if ((numero < 1) || (numero > 5))
			return;

		switch (numero) {
		case 1:
			numeroValutati1++;
			break;
		case 2:
			numeroValutati2++;
			break;
		case 3:
			numeroValutati3++;
			break;
		case 4:
			numeroValutati4++;
			break;
		case 5:
			numeroValutati5++;
			break;
		}
	}

	public double getMedia() {
		return (numeroValutati1 + 2 * numeroValutati2 + 3 * numeroValutati3 + 4 * numeroValutati4 + 5 * numeroValutati5) / 5.0;
	}

	public static void main(String[] args) {
		Film m1 = new Film();
		m1.setNome("I guardiani del destino");
		m1.setPunteggioMPAA("PG-13");
		m1.aggiungiPunteggio(5);
		m1.aggiungiPunteggio(5);
		m1.aggiungiPunteggio(4);
		m1.aggiungiPunteggio(4);
		m1.aggiungiPunteggio(5);
		System.out.println(m1.getNome() + ", " + m1.getPunteggioMPAA() + " media punteggio: " + m1.getMedia());

		Film m2 = new Film();
		m2.setNome("Sono il Numero Quattro");
		m2.setPunteggioMPAA("PG-13");
		m2.aggiungiPunteggio(3);
		m2.aggiungiPunteggio(2);
		m2.aggiungiPunteggio(2);
		m2.aggiungiPunteggio(4);
		m2.aggiungiPunteggio(1);
		System.out.println(m2.getNome() + ", " + m2.getPunteggioMPAA() + " media punteggio: " + m2.getMedia());
	}
}
