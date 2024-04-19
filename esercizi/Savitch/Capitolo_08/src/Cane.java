
public class Cane {
	public String nome;
	public String razza;
	public int anni;

	// Metodi get e set
	public void setNome(String nuovoNome) {
		nome = nuovoNome;
	}

	public String getNome() {
		return nome;
	}

	public void setRazza(String nuovaRazza) {
		razza = nuovaRazza;
	}

	public String getRazza() {
		return razza;
	}

	public void setAnni(int nuoviAnni) {
		anni = nuoviAnni;
	}

	public int getAnni() {
		return anni;
	}

	// Metoddo equals
	public boolean equals(Cane altroCane) {
		return (razza.equals(altroCane.razza) && 
				nome.equals(altroCane.nome) && anni == altroCane.anni);
	}

	public void scriviOutput() {
		System.out.println("Nome: " + nome);
		System.out.println("Razza: " + razza);
		System.out.println("Eta': " + anni);
	}

	public int getEtaInAnniUmani() {
		int etaUmana = 0;
		if (anni <= 2) {
			etaUmana = anni * 11;
		} else {
			etaUmana = 22 + ((anni - 2) * 5);
		}
		return etaUmana;
	}
}
