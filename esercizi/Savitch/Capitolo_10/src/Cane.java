
public class Cane extends Animale {
	private String razza;
	private boolean comandoDiRichiamo;

	public Cane() {
		this("Nessun nome", 0, 0, "nessuna", false); 
	}

	public Cane(String nome, int eta, double peso, String razza, boolean comandoDiRichiamo) {
		super(nome, eta, peso);
		setEta(eta);
		setPeso(peso);
		setRazza(razza);
		setComandoDiRichiamo(comandoDiRichiamo);
	}

	public Cane(String nome, int eta, double peso, String razza) {
		this(nome, eta, peso, razza, false);
	}

	public void scriviOutput() {
		super.scriviOutput();
		System.out.println("Razza: " + razza);
		if (comandoDiRichiamo)
			System.out.println("Ha un comando di richiamo.");
		else
			System.out.println("Non ha un comando di richiamo.");
	}

	public void set(String nome, int eta, double peso, String razza, boolean comandoDiRichiamo) {
		super.setAnimale(nome, eta, peso);
		setRazza(razza);
		setComandoDiRichiamo(comandoDiRichiamo);
	}

	public void setRazza(String razza) {
		this.razza = razza;
	}

	public void setComandoDiRichiamo(boolean comandoDiRichiamo) {
		this.comandoDiRichiamo = comandoDiRichiamo;
	}

	public String getRazza() {
		return razza;
	}

	public boolean getComandoDiRichiamo() {
		return comandoDiRichiamo;
	}
}