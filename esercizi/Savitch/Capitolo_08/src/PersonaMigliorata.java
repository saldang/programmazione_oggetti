import java.util.Scanner;

/**
  Un oggetto di questa classe ha due attributi, un nome e un'età.
 Metodi pubblici
	Impostare solo il nome, solo l'età, o entrambi.
	Verificare se due persone sono uguali (stesso nome ed età).
	Verificare se due persone hanno lo stesso nome.
	Verificare se due persone hanno la stessa età.
	Verificare se una persona è più anziana di un'altra.
	Verificare se una persona è più giovane di un'altra.

 Precondizioni:
	Per i metodi di set: la persona è stata creata.
	Per i metodi di test: le persone sono state create e hanno valori per nome ed età.

 Postcondizioni:
	Metodi di set: ad uno o ad entrambi gli attributi viene assegnato un valore.
	Metodi di prova: viene restituito true o false.

 Basato su: Domanda di autovalutazione n. 15 nel capitolo 8.

 */
public class PersonaMigliorata {
	private String nome;
	private int eta;

	public void setNome(String nuovoNome) {
		nome = nuovoNome;
	}

	public void setEta(int nuovaEta) {
		if (nuovaEta >= 0) {
			eta = nuovaEta;
		} else {
			System.out.println("ERRORE: Eta' negativa.");
			System.exit(0);
		}
	}

	public void setPersona(String nuovoNome, int nuovaEta) {
		setNome(nuovoNome);
		setEta(nuovaEta);
	}

	public String getNome() {
		return nome;
	}

	public int getEta() {
		return eta;
	}

	public void leggiInput() {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Nome della persona?");
		nome = tastiera.nextLine();

		System.out.println("Eta' della persona?");
		eta = tastiera.nextInt();
		while (eta < 0) {
			System.out.println("L'eta' non puo' essere negativa.");
			System.out.println("Inserisci nuovamente eta':");
			eta = tastiera.nextInt();
		}
	}

	public void stampa() {
		System.out.println("nome = " + nome);
		System.out.println("eta = " + eta);
	}

	public boolean equals(PersonaMigliorata altra) {
		return (this.nome.equalsIgnoreCase(altra.nome) && this.getEta() == altra.getEta());
	}

	public boolean stessoNome(PersonaMigliorata altra) {
		return (this.nome.equalsIgnoreCase(altra.nome));
	}

	public boolean stessaEta(PersonaMigliorata altra) {
		return (this.getEta() == altra.getEta());
	}

	public boolean piuVecchiaDi(PersonaMigliorata altra) {
		return (this.getEta() > altra.getEta());
	}

	public boolean piuGiovaneDi(PersonaMigliorata altra) {
		return (this.getEta() < altra.getEta());
	}
}
