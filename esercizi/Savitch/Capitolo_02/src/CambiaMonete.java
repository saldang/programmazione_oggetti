import java.util.Scanner;

public class CambiaMonete {

	public static void main(String[] args) {
		int quantita, quantitaIniziale;
		int cinquantaCent, ventiCent, dieciCent, cinqueCent, dueCent, unCent;
		
		int euro;
		
		//System.out.println("Inserisci un intero compreso tra 1 e 99.");
		System.out.println("Inserisci un intero maggiore di zero.");
		System.out.println("Identificheroo' una combinazione di monete");
		System.out.println("che corrisponde a tale cifra.");
		Scanner tastiera = new Scanner(System.in);
		quantita = tastiera.nextInt();
		quantitaIniziale = quantita;
		
		euro = quantita / 100;
		quantita = quantita % 100;
		
		cinquantaCent = quantita / 50;
		quantita = quantita % 50;
		ventiCent = quantita / 20;
		quantita = quantita % 20;
		dieciCent = quantita / 10;
		quantita = quantita % 10;
		cinqueCent = quantita / 5;
		quantita = quantita % 5;
		dueCent = quantita / 2;
		quantita = quantita % 2;
		unCent = quantita;
		
		System.out.println(quantitaIniziale + " Euro in moneta corrispondono a:");
		//System.out.println(quantitaIniziale + " centesimi in moneta corrispondono a:");
		System.out.println(euro + " monete da un euro");
		
		System.out.println(cinquantaCent + " monete da cinquanta centesimi");
		System.out.println(ventiCent + " monete da venti centesimi");
		System.out.println(dieciCent + " monete da dieci centesimi");
		System.out.println(cinqueCent + " monete da cinque centesimi");
		System.out.println(dueCent + " monete da due centesimi e");
		System.out.println(unCent + " monete da un centesimo");
	}
}