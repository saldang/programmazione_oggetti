public class AnniDaSuperareFase1 {
	public static void main(String[] args) {
		Specie s1 = new Specie();
		Specie s2 = new Specie();
		Specie piuBassa = new Specie(); // ha una popolazione inizlae più bassa
		Specie piuAlta = new Specie();  // ha una popolazione iniziale più alta

		// Crea le due specie
		s1.leggiInput();
		s2.leggiInput();

		// Determina chi ha la popolazione inizale piu' bassa
		if (s1.getPopolazione() < s2.getPopolazione()) {
			piuBassa.setSpecie(s1.getNome(), s1.getPopolazione(), s1.getTassoCrescita());
			piuAlta.setSpecie(s2.getNome(), s2.getPopolazione(), s2.getTassoCrescita());
		} else {
			piuBassa.setSpecie(s2.getNome(), s2.getPopolazione(), s2.getTassoCrescita());
			piuAlta.setSpecie(s1.getNome(), s1.getPopolazione(), s1.getTassoCrescita());
		}

		// verifica: queste linee possono essere rimosse dopo aver verificato che il programma funzioni
		System.out.println("La specie che ha la popolazione inferiore e'");
		piuBassa.scriviOutput();
		System.out.println("La specie che ha la popolazione superiore e'");
		piuAlta.scriviOutput();
		// fine della verifica

		// Identifica il numero di anni che occorrono affinché la specie con popolazione inizlae più bassa superi quella con popolazione inizlae più alta.
	}
}
