/**
  Classe che descrive un animale rivista
*/
public class Animale2 {
	private String nome; 
	private int	eta;	 //in anni
	private double peso; //in Kg
	
	public Animale2(String nomeIniziale, int etaIniziale, double pesoIniziale) {
		set(nomeIniziale, etaIniziale, pesoIniziale);
	}

	public Animale2(String nomeIniziale) {
		set(nomeIniziale, 0, 0);
	}

	public Animale2(int etaIniziale) {
		set("Nessun nome", etaIniziale, 0);
	}
	
	public Animale2(double pesoIniziale) {
		set("Nessun nome", 0, pesoIniziale);
	}
	
	public Animale2() {
		set("Nessun nome", 0, 0);
	}

	public void setAnimale(String nuovoNome, int nuovaEta, double nuovoPeso) {
		set(nuovoNome, nuovaEta, nuovoPeso);
	}
	
	public void setNome(String nuovoNome) {
		set(nuovoNome, eta, peso); 
		//eta' e peso rimangono invariate
	}
	
	public void setEta(int nuovaEta) {
		set(nome, nuovaEta, peso);
		//nome e peso rimangono invariate
	}
	
	public void setPeso(double nuovoPeso) {
		set(nome, eta, nuovoPeso);
	//nome e eta' rimangono invariate
	}
	
	private void set(String nuovoNome, int nuovaEta, double nuovoPeso) {
		nome = nuovoNome;
		if ((nuovaEta < 0) || (nuovoPeso < 0)) {
			System.out.println("Errore: eta o peso negativi."); 
			System.exit(0);
		} else {
			eta = nuovaEta; 
			peso = nuovoPeso;
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
		System.out.println("Eta: " + eta + " anni.");
		System.out.println("Peso: " + peso + " Kg.");
	}
}

