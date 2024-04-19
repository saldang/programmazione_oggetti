public class BambinoScuola {

	private String nome;
	private int eta;
	private String insegnante;
	private String saluto;

	/**
	 * Crea una istanza di BambinoScuola
	 */
	public BambinoScuola(String nome, int eta, String insegnate, String saluto) {
		this.nome = nome;
		this.eta = eta;
		this.insegnante = insegnate;
		this.saluto = saluto;
	}

	// get
	public String getNome() {
		return nome;
	}

	public String getInsegnante() {
		return insegnante;
	}

	public String getSaluto() {
		return saluto;
	}

	public int getEta() {
		return eta;
	}

	// modifica
	public void compleanno() {
		eta++;
	}

	public void cambiaInsegnante(String nuovoInsegnante) {
		insegnante = nuovoInsegnante;
	}

	public void cambiaSaluto(String nuovoSaluto) {
		saluto = nuovoSaluto;
	}

	public String toString() {
		return "Classe base per un bambino a scuola \n\tNome: " + nome + "\n\tEta: " + eta + "\n\tInsegnante: "
				+ insegnante + "\n\tSaluto: " + saluto;
	}

	public static void main(String[] args) {
		BambinoScuola ken = new BambinoScuola("Ken", 5, "Mrs. Jones", "Hiyas.");
		System.out.println(ken);
		System.out.println("\nCambio l'eta in 1, insegnante in Mr. Roberson, saluto in Aloha");
		ken.compleanno();
		ken.cambiaInsegnante("Mr. Roberson");
		ken.cambiaSaluto("Aloha");
		System.out.println("Lo stato di Ken ora...");
		System.out.println(ken);
	}
}
