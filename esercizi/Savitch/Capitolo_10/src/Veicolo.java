public class Veicolo {
	private String marca;
	private int numeroCilindri;
	private Persona proprietario;

	
	public Veicolo(Persona proprietario, String marca, int numeroCilindri) {
		setProprietario(proprietario);
		setMarca(marca);
		setNumeroCilindri(numeroCilindri);
	}
	
	public Veicolo(String marca, int numeroCilindri) {
		Persona p = new Persona("Nessuno");
		setProprietario(p);
		setMarca(marca);
		setNumeroCilindri(numeroCilindri);
	}
	
	public Veicolo() {
		this("Nessuna", 0);
	}

	public Veicolo(String marca) {
		this(marca, 0);
	}

	public Veicolo(Persona proprietario) {
		this(proprietario, "Nessuna", 0);
	}

	public Veicolo(Persona proprietario, int numeroCilindri) {
		this(proprietario, "Nessuna", numeroCilindri);
	}

	public Veicolo(Persona proprietario, String marca) {
		this(proprietario, marca, 0);
	}
	

	public void scriviOutput() {
		scriviNomeProprietario();
		scriviMarca();
		scriviNumeroCilindri();
	}

	public void scriviNomeProprietario() {
		System.out.println("Proprietario: " + proprietario.getNome());
	}

	public void scriviMarca() {
		System.out.println("Marca: " + marca);
	}

	public void scriviNumeroCilindri() {
		System.out.println("Numero di cilindri: " + numeroCilindri);
	}

	
	public void set(Persona proprietario, String marca, int numeroCilindri) {
		setProprietario(proprietario);
		setMarca(marca);
		setNumeroCilindri(numeroCilindri);
	}

	public void setProprietario(Persona proprietario) {
		if(this.proprietario == null)
			this.proprietario = new Persona();
		this.proprietario.setNome(proprietario.getNome());
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setNumeroCilindri(int numeroCilindri) {
		this.numeroCilindri = numeroCilindri;
	}

	
	public Persona getPropietario() {
		return proprietario;
	}

	public String getNomeProprietario() {
		return proprietario.getNome();
	}

	public String getMarca() {
		return marca;
	}

	public int getNumeroCilindri() {
		return numeroCilindri;
	}

	// equals method
	public boolean equals(Veicolo otherVehicle) {
		return (proprietario.haLoStessoNome(otherVehicle.getPropietario()) && numeroCilindri == otherVehicle.getNumeroCilindri()
				&& marca.equalsIgnoreCase(otherVehicle.getMarca()));
	}
}