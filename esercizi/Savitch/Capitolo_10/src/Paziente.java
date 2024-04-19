public class Paziente extends Persona {
	private String ssn; 

	public Paziente() {
		super();
		setSsn("000-00-0000");
	}

	public Paziente(String nome) {
		this(nome, "000-00-0000");
	}

	public Paziente(String nome, String ssn) {
		super(nome);
		setSsn(ssn);
	}

	public void scriviOutput() {
		super.scriviOutput();
		scriviSsn();
	}

	public void scriviSsn() {
		System.out.println("Servizio sanitario nazionale #: " + ssn);
	}

	public void set(String nome, String ssn) {
		setNome(nome);
		setSsn(ssn);
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public String getSsn() {
		return ssn;
	}

	// Equals method
	public boolean equals(Paziente altroPaziente) {
		return (this.haLoStessoNome(altroPaziente) && 
				this.ssn.equalsIgnoreCase(altroPaziente.getSsn()));
	}
}