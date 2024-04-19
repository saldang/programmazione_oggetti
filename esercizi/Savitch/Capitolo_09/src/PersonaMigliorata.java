import java.util.Scanner;

public class PersonaMigliorata {
	private String nome;
	private int eta;

	// I 4 costruttori
	// #1 sono passati sia nome che eta. Se eta' e' negativa, viene posta a 0
	public PersonaMigliorata(String ilNome, int laEta) {
		set(ilNome, laEta);
	}

	// #2 viene passato solo nome ed eta' viene posta a 0
	public PersonaMigliorata(String ilNome) {
		set(ilNome, 0);
	}

	// #3 viene passata solo eta' e nome e' posto a "nessun nome". Se eta' e'
	// negativa, viene posta a 0
	public PersonaMigliorata(int laEta) {
		set("Nessun nome", laEta);
	}

	// #4 Costruttore di default. Nome e' posto a "nessun nome" ed eta' a 0.
	public PersonaMigliorata() {
		set("Nessun nome", 0);
	}

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

	public void set(String nuovoNome, int nuovaEta) {
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
