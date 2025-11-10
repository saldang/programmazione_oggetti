/**
  Classe che descrive un animale rivista 
*/
public class Animale3 {
	private String nome; 
	private int	eta;	 //in anni
	private double peso; //in Kg
	
	public Animale3(String nomeIniziale, int etaIniziale, double pesoIniziale) {
		set(nomeIniziale, etaIniziale, pesoIniziale);
	}

	public Animale3(String nomeIniziale) {
		this(nomeIniziale, 0, 0);
	}

	public Animale3(int etaIniziale) {
		this("Nessun nome", etaIniziale, 0);
	}
	
	public Animale3(double pesoIniziale) {
		this("Nessun nome", 0, pesoIniziale);
	}
	
	public Animale3() {
		this("Nessun nome", 0, 0);
	}

	public void setAnimale(String nomeIniziale, int etaIniziale, double pesoIniziale) {
		set(nomeIniziale, etaIniziale, pesoIniziale);
	}
	
	public void setNome(String nuovoNome) {
		nome = nuovoNome; 
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

