
/**
 Programma giocattolo che dimostra come un programmatore 
 possa accedere e modificare gli attributi privati
 della classe CoppiaAnimali
*/
public class Hacker {

	public static void main(String[] args) {
		Animale buono = new Animale("Cane da Guardia", 5, 75.0); 
		Animale altro = new Animale("Fido", 4, 60.5);
		CoppiaAnimali coppia = new CoppiaAnimali(buono, altro); 
		System.out.println("La coppia:"); 
		coppia.scriviOutput();

		Animale cattivo = coppia.getPrimo(); 
		cattivo.setAnimale("Bullo", 1200, 500);

		System.out.println("\nLa coppia ora:"); 
		coppia.scriviOutput();

		System.out.println("L'animale non era molto privato!"); 
		System.out.println("Sembra una falla di sicurezza.");
	}
}
