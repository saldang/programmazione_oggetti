public class Dottore extends Persona {
	private double parcella;
	private String specializzazione;

	public Dottore(double parcella, String specializzazione) {
		super();
		setParcella(parcella);
		setSpecializzazione(specializzazione);;
	}

	public Dottore(String nome, double parcella, String specializzazione) {
		super(nome);
		setParcella(parcella);
		setSpecializzazione(specializzazione);
	}
	
	public Dottore() {
		this(150.00, "Generico");
	}

	public Dottore(String nome) {
		this(nome, 150.00, "Generico");
	}

	public Dottore(String nome, double parcella) {
		this(nome, parcella, "Generico");
	}

	public Dottore(String nome, String specializzazione) {
		this(nome, 150.00, specializzazione);
	}

	public void scriviOutput() {
		scriviNome();
		scriviParcella();
		scriviSpecializzazione();
	}

	public void scriviNome() {
		super.scriviOutput();
	}

	public void scriviParcella() {
		System.out.println("Parcella: €" + parcella);
	}

	public void scriviSpecializzazione() {
		System.out.println("Specializzazione: " + specializzazione);
	}

	
	public void set(String nome, double parcella, String specializzazione) {
		super.setNome(nome);
		setParcella(parcella);
		setSpecializzazione(specializzazione);
	}

	public void setParcella(double parcella) {
		this.parcella = parcella;
	}

	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}

	public double getParcella() {
		return parcella;
	}

	public String getSpecializzazione() {
		return specializzazione;
	}

	// Equals method
	public boolean equals(Dottore altroDottore) {
		return (this.haLoStessoNome(altroDottore) && this.getParcella() == altroDottore.getParcella()
				&& this.specializzazione.equalsIgnoreCase(altroDottore.getSpecializzazione()));
	}
}