import java.util.Scanner;


public class SpecieTerzaProvaDemo {

	public static void main(String[] args) {
		SpecieTerzaProva specieDelMese = new SpecieTerzaProva();

		System.out.println ("Inserisci i dati sulla specie del mese:");
		specieDelMese.leggiInput();
		specieDelMese.scriviOutput();
		
		System.out.println("Inserisci il numero di anni da predire:");
		Scanner tastiera = new Scanner(System.in);
		int numeroAnni = tastiera.nextInt();
		
		int popolazioneFutura = specieDelMese.prediciPopolazione(numeroAnni);
		System.out.println("Tra " + numeroAnni + " anni la popolazione sara' di " + popolazioneFutura + " individui.");

		//Cambia la specie per verificare come 
		//si modificano i valori delle variabili di istanza:
		specieDelMese.setSpecie("Panthera tigris tigris", 3750, 30);
		System.out.println("La nuova specie del mese:"); 
		specieDelMese.scriviOutput();
		popolazioneFutura = specieDelMese.prediciPopolazione(numeroAnni);
		System.out.println("Tra " + numeroAnni + " anni la popolazione sara' di " + popolazioneFutura + " individui."); 
	}
}
