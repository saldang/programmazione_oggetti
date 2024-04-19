import java.util.Scanner;

public class AnimaleDemo {
	
	public static void main(String[] args) {
		Animale tuoAnimale = new Animale("Fido");
		System.out.println("Le mie informazioni sul tuo animale non sono accurate.");
		System.out.println("Ecco quello che so:"); 
		tuoAnimale.scriviOutput( );
		
		Scanner tastiera = new Scanner(System.in); 
		System.out.println("Inserisci il nome corretto:"); 
		String nomeCorretto = tastiera.nextLine();
		tuoAnimale.setNome(nomeCorretto);
		
		System.out.println("Inserisci l'eta corretta:"); 
		int etaCorretta = tastiera.nextInt();
		tuoAnimale.setEta(etaCorretta);
		
		System.out.println("Inserisci il peso corretto:"); 
		double pesoCorretto = tastiera.nextDouble();
		tuoAnimale.setPeso(pesoCorretto);
		
		System.out.println("Dati aggiornati:");
		tuoAnimale.scriviOutput();
	}
}