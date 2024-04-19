public class NonLaureato extends Studente {
	private int annoDiCorso; //1 per primo anno, 2 per secondo anno,
	                         //3 per terzo anno, o 4 per fuori corso.
	
	public NonLaureato() {
		super();
		annoDiCorso = 1;
	}
	
	public NonLaureato(String nomeIniziale, int matricolaIniziale, int annoDiCorsoIniziale) {
		super(nomeIniziale, matricolaIniziale);
		setAnnoDiCorso(annoDiCorsoIniziale); //Verifica 1 <= annoDiCorsoIniziale <= 4
	}
	
	public void reimposta(String nuovoNome, int nuovaMatricola, int nuovoAnnoDiCorso) {
		reimposta(nuovoNome, nuovaMatricola); //reimposta di Studente
		setAnnoDiCorso(nuovoAnnoDiCorso); //Verifica 1 <= nuovoAnnoDiCorso <= 4
	}
	
	public int getAnnoDiCorso() {
		return annoDiCorso;
	}
	
	public void setAnnoDiCorso(int nuovoAnnoDiCorso) {
		if ((1 <= nuovoAnnoDiCorso) && (nuovoAnnoDiCorso <= 4))
			annoDiCorso = nuovoAnnoDiCorso;
		else {
			System.out.println("Anno di corso Illegale!");
			System.exit(0);
		}
	}
	
	public void scriviOutput() {
		super.scriviOutput();
		System.out.println("Anno di corso: " + annoDiCorso);
	}
	
	public boolean equals(NonLaureato altroNonLaureato) {
		return equals((Studente)altroNonLaureato) &&
				(this.annoDiCorso == altroNonLaureato.annoDiCorso);
	}
}
