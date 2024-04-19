public class AnniDaSuperare {
	public static void main(String[] args) {
		Specie s1 = new Specie();
		Specie s2 = new Specie();
		Specie piuBassa = new Specie(); // ha una popolazione inizlae più bassa
		Specie piuAlta = new Specie();  // ha una popolazione iniziale più alta

		// Crea le due specie
		s1.leggiInput();
		s2.leggiInput();

		// Caso speciale:
		// Cosa succede se le due specie hanno la spessa popolazione iniziale?
		// Determina chi ha la popolazione inizale piu' bassa
		// Se hanno la stessa popolazione iniziale, assegna a piuBassa la prima specie ed a piuALta la seconda specie
		if (s1.getPopolazione() <= s2.getPopolazione()) {
			piuBassa.setSpecie(s1.getNome(), s1.getPopolazione(), s1.getTassoCrescita());
			piuAlta.setSpecie(s2.getNome(), s2.getPopolazione(), s2.getTassoCrescita());
		} else {
			piuBassa.setSpecie(s2.getNome(), s2.getPopolazione(), s2.getTassoCrescita());
			piuAlta.setSpecie(s1.getNome(), s1.getPopolazione(), s1.getTassoCrescita());
		}

		// Identifica il numero di anni che occorrono affinché la specie con popolazione iniziale più bassa superi quella con popolazione iniziale più alta
		int anni = 1;
		int prossimaPiuBassa = piuBassa.getPopolazione();
		int prossimaPiuAlta = piuAlta.getPopolazione();
		while (prossimaPiuBassa <= prossimaPiuAlta && anni <= 10) {
			prossimaPiuBassa = piuBassa.prediciPopolazione(anni);
			prossimaPiuAlta = piuAlta.prediciPopolazione(anni);
			anni++; // ATTENZIONE: il valori di anni all'uscita del ciclo avra' un elemento di troppo
		}

		// Aggiusta anni in modo che il valore sia corretto
		anni--;

		// Porre attenzione quando anni = 10
		// la popolazione piuBassa potrebbe non aver superato la popolazione di piuAlta
		// occorre quindi fare una verifica finale

		if (anni == 10 && prossimaPiuBassa <= prossimaPiuAlta) {
			System.out.println("Specie " + piuBassa.getNome() + " non superera' " + piuAlta.getNome() + ".");
		} else {
			System.out.println(
					"Specie " + piuBassa.getNome() + " superera' " + piuAlta.getNome() + " in " + anni + " anni.");
		}
	}
}
