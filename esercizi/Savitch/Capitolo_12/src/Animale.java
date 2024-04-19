/**
  Classe che descrive un animale 
 */
public class Animale {
	private String nome; 
	private int	eta;	 //in anni
	private double peso; //in Kg
	
	public Animale() {
		this("Nessun nome", 0, 0);
	}
	
	public Animale(String nome, int eta, double peso) {
		setAnimale(nome, eta, peso);
	}
	
	public Animale(String nome) {
		this(nome, 0, 0);
	}
	
	public Animale(int eta) {
		this("Nessun nome", eta, 0);
	}
	
	public Animale(double peso) {
		this("Nessun nome", 0, peso);
	}
	
	public void setAnimale(String nome, int eta, double peso) {
		setNome(nome);
		setEta(eta);
		setPeso(peso);
	}
	
		
	public void setNome(String nuovoNome) {
		nome = nuovoNome; //eta' e peso rimangono invariate
	}
	
	public void setEta(int nuovaEta) {
		if (nuovaEta < 0) {
			System.out.println("Errore: eta' negativa."); 
			System.exit(0);
		} else {
			eta = nuovaEta; 
			//nome e peso rimangono invariate 
		}
	}
	
	
	public void setPeso(double nuovoPeso) {
		if (nuovoPeso < 0) {
			System.out.println("Errore: peso negativo."); 
			System.exit(0);
		} else {
			peso = nuovoPeso;
			//nome e eta' rimangono invariate 
		}
	}
	
	public String getNome() {
		return nome;
	}

	public int getEta() {
		return eta;
	}

	public double getPeso() {
		return peso;
	}
	
	public void scriviOutput(){
		System.out.println("Nome: " + nome);
		System.out.println("Eta: " + eta + " anni");
		System.out.println("Peso: " + peso + " Kg");
	}
}
