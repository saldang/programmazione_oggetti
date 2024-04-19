public class Camion extends Veicolo {
	private double capacitaCarico;
	private double capacitaCaricoRimorchio;

	public Camion(Persona proprietario, String marca, int numeroCilindri, double capacitaCarico, double capacitaCaricoRimorchio) {
		super(proprietario, marca, numeroCilindri);
		setCapacitaCarico(capacitaCarico);
		setCapacitaCaricoRimorchio(capacitaCaricoRimorchio);
	}
	
	public Camion() {
		super();
		setCapacitaCarico(0);
		setCapacitaCaricoRimorchio(0);
	}

	public Camion(String marca) {
		super(marca);
		setCapacitaCarico(0);
		setCapacitaCaricoRimorchio(0);
	}

	public Camion(String marca, int numeroCilindri) {
		super(marca, numeroCilindri);
		setCapacitaCarico(0);
		setCapacitaCaricoRimorchio(0);
	}

	public Camion(Persona proprietario) {
		super(proprietario);
		setCapacitaCarico(0);
		setCapacitaCaricoRimorchio(0);
	}

	public Camion(Persona proprietario, int numeroCilindri) {
		super(proprietario, numeroCilindri);
		setCapacitaCarico(0);
		setCapacitaCaricoRimorchio(0);
	}

	public Camion(Persona proprietario, String marca) {
		super(proprietario, marca);
		setCapacitaCarico(0);
		setCapacitaCaricoRimorchio(0);
	}

	public Camion(Persona proprietario, String marca, int numeroCilindri) {
		super(proprietario, marca, numeroCilindri);
		setCapacitaCarico(0);
		setCapacitaCaricoRimorchio(0);
	}
	

	//Scrivi

	public void scriviOutput() {
		super.scriviOutput();
		scriviCapacitaCarico();
		scriviCapacitaCaricoRimorchio();
	}

	public void scriviCapacitaCarico() {
		System.out.println("Capacita carico: " + capacitaCarico + " tonnellate");
	}

	public void scriviCapacitaCaricoRimorchio() {
		System.out.println("Capacita carico rimorchio: " + capacitaCaricoRimorchio + " tonnellate");
	}

	
	//Set	

	public void set(Persona proprietario, String marca, int numeroCilindri, double capacitaCarico, double capacitaCaricoRimorchio) {
		super.set(proprietario, marca, numeroCilindri);
		setCapacitaCarico(capacitaCarico);
		setCapacitaCaricoRimorchio(capacitaCaricoRimorchio);
	}

	public void setCapacitaCarico(double capacitaCarico) {
		this.capacitaCarico = capacitaCarico;
	}

	public void setCapacitaCaricoRimorchio(double capacitaCaricoRimorchio) {
		this.capacitaCaricoRimorchio = capacitaCaricoRimorchio;
	}
	
	
	//Get
	
	public double getCapacitaCarico() {
		return capacitaCarico;
	}

	public double getCapacitaCaricoRimorchio() {
		return capacitaCaricoRimorchio;
	}

	// equals method
	public boolean equals(Camion otherTruck) {
		return (super.equals(otherTruck) && this.capacitaCarico == otherTruck.getCapacitaCarico() && this.capacitaCaricoRimorchio == otherTruck.getCapacitaCaricoRimorchio());
	}
}