public class SpecieTest {
	public static void main(String[] args) {
		Specie provaSpecie = new Specie();
		// Prova il metodo setSpecie
		provaSpecie.setSpecie("Leone", 100, 50);
		if (provaSpecie.getNome().equals("Leone") &&
				(provaSpecie.getPopolazione() == 100) &&
				(provaSpecie.getTassoCrescita() >= 49.99) &&
				(provaSpecie.getTassoCrescita() <= 50.01)) {
			System.out.println("Superato: test setSpecie.");
		} else {
			System.out.println("FALLITO: test setSpecie.");
		}

		// Prova il metodo prediciPopolazione
		if ((provaSpecie.prediciPopolazione(-1) == 100) &&
				(provaSpecie.prediciPopolazione(1) == 150) &&
				(provaSpecie.prediciPopolazione(5) == 759)) {
			System.out.println("Superato: test prediciPopolazione.");
		} else {
			System.out.println("FALLITO: test prediciPopolazione.");
		}
	}
} 
