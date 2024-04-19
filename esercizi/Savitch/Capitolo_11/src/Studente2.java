// Aggiunto 'implements Comparable'
public class Studente2 extends Persona implements Comparable {
	private int matricola;

	public Studente2() {
		super();
		matricola = 0;// Ancora nessuna matricola
	}

	public Studente2(String nomeIniziale, int matricolaIniziale) {
		super(nomeIniziale);
		matricola = matricolaIniziale;
	}

	public void reimposta(String nuovoNome, int nuovaMatricola) {
		setName(nuovoNome);
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

	public boolean equals(Studente2 altroStudente) {
		return this.haLoStessoNome(altroStudente) && (this.matricola == altroStudente.matricola);
	}

	public boolean equals(Object altroOggetto) {
		boolean uguale = false;
		if ((altroOggetto != null) && (altroOggetto instanceof Studente2)) {
			Studente2 altroStudente = (Studente2) altroOggetto;
			uguale = this.haLoStessoNome(altroStudente) && (this.matricola == altroStudente.matricola);
		}
		return uguale;
	}

	// Compara le matricole
	public int compareTo(Object o) {
		if ((o != null) && (o instanceof Studente2)) {
			Studente2 altroStudente = (Studente2) o;
			if (matricola < altroStudente.matricola)
				return -1;
			else if (matricola > altroStudente.matricola)
				return 1;
			else
				return 0;
		}
		return -1; // il default se l'oggetto passato in ingresso non è di tipo Studente2
	}

	// This version compares using the name
	/*
	 * . public int compareTo(Object o) { if ((o != null) && (o instanceof
	 * Student2)) { Student2 otherStudent = (Student2) o; return
	 * getName().compareTo(otherStudent.getName()); } return -1; // Default if other
	 * object is not a Student2 }
	 */
}
