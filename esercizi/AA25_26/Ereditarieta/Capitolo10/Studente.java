public class Studente extends Persona {
	private int matricola;
	
	public Studente() {
		super();
		matricola = 0;//Ancora nessuna matricola
	}
	
	public Studente(String nomeIniziale, int matricolaIniziale) {
		super(nomeIniziale);
		matricola = matricolaIniziale;
	}
	
	public void reimposta(String nuovoNome, int nuovaMatricola) {
		setNome(nuovoNome);
		matricola = nuovaMatricola;
	}
	
	public int getMatricola() {
		return matricola;
	}
	
	public void setMatricola(int nuovaMatricola) {
		matricola = nuovaMatricola;
	}
	
	public void scriviOutput() {
		System.out.println("Nome: " + getNome());
		System.out.println("Matricola: " + matricola);
	}
	
	public boolean equals(Studente altroStudente) {
		return this.haLoStessoNome(altroStudente) &&
				(this.matricola == 
					altroStudente.matricola);
	}
}
