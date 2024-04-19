public class Persona {
	private String nome;

	public Persona() {
		nome = "Ancora nessun nome";
	}

	public Persona(String nuovoNome) {
		nome = nuovoNome;
	}

	public void setName(String nuovoNome) {
		nome = nuovoNome;
	}

	public String getNome() {
		return nome;
	}

	public void scriviOutput() {
		System.out.println("Nome: " + nome);
	}

	public boolean haLoStessoNome(Persona altraPersona) {
		return (this.nome.equalsIgnoreCase(altraPersona.getNome()));
	}

}
