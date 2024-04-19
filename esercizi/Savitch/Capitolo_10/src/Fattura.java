public class Fattura {
	private Dottore dottore;
	private Paziente paziente;
	private double ammontare;

	public Fattura(Dottore dottore, Paziente paziente) {
		set(dottore, paziente, dottore.getParcella());
	}

	
	public void scriviOutput() {
		scriviNomeDottore();
		scriviNomePaziente();
		scriviAmmontare();
	}

	public void scriviNomeDottore() {
		System.out.println("Dottore: " + dottore.getNome());
	}

	public void scriviNomePaziente() {
		System.out.println("PAziente: " + paziente.getNome());
	}

	public void scriviAmmontare() {
		System.out.println("Ammontare della fattura: €" + ammontare);
	}

	
	public void set(Dottore dottore, Paziente paziente, double ammontare) {
		setDottore(dottore);
		setPaziente(paziente);
		setAmmontare(ammontare);
	}

	public void setDottore(Dottore dottore) {
		this.dottore = dottore;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public void setAmmontare(double ammontare) {
		this.ammontare = ammontare;
	}

	public Dottore getDottore() {
		return dottore;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public double getAmmontare() {
		return ammontare;
	}

	// Equals method
	public boolean equals(Fattura altraFattura) {
		return this.dottore.getNome().equalsIgnoreCase(altraFattura.getDottore().getNome())
				&& this.paziente.getNome().equalsIgnoreCase(altraFattura.getPaziente().getNome())
				&& this.ammontare == altraFattura.ammontare;
	}
}