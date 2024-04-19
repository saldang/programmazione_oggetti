
public class SpeciePrimaProvaDemo {

	public static void main(String[] args) {
		
		SpeciePrimaProva specieDelMese = new SpeciePrimaProva();
		
		System.out.println("Inserisci i dati della specie del mese:");
		specieDelMese.leggiInput();
		specieDelMese.scriviOutput();
		
		int popolazioneFutura = specieDelMese.prediciPopolazione(10);
		System.out.println("Tra dieci anni la popolazione sara' di " + 
				           popolazioneFutura + " individui.");
		
		//Cambia la specie per verificare come 
		//si modificano i valori delle variabili di istanza:
		specieDelMese.nome = "Panthera tigris tigris";
		specieDelMese.popolazione = 3750;
		specieDelMese.tassoCrescita = 30;
		
		System.out.println("La nuova specie del mese:");
		specieDelMese.scriviOutput();
		System.out.println("Tra dieci anni la popolazione sara' di " + 
				specieDelMese.prediciPopolazione(10) + " individui.");
	}
}
