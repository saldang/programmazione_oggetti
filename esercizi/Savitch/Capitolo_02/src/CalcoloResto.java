import java.util.*;

public class CalcoloResto {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Scrivi il prezzo del prodotto");
		System.out.println("(da 25 centesimi a un Euro, con incrementi di 5 centesimi):");
		int quantitaOriginale = tastiera.nextInt();

		if(quantitaOriginale < 25)
			System.out.println("Non valido: meno di 25 centesimi.");
		else if(quantitaOriginale > 100)
			System.out.println("Non valido: piu' di 100 centesimi.");
		else if(quantitaOriginale%5 != 0)
			System.out.println("Non valido: non un multiplo di 5 centesimi.");
		else {//input valido
			int cambio = 100 - quantitaOriginale;

			int cinquata = cambio / 50;
			cambio = cambio % 50;// resto dopo aver tolto i 50 centesimi
			int venti = cambio / 20;
			cambio = cambio % 20;// resto dopo aver tolto anche i 20 centesimi
			int dieci = cambio / 10;
			cambio = cambio % 10;// resto dopo aver tolto anche i 10 centesimi
			int cinque = cambio / 5;

			System.out.println("Hai comprato un prodotto da " + quantitaOriginale + " centesimi inserendo un Euro.");
			System.out.println("il tuo resto e':");
			System.out.println(cinquata + " monete da cinquanta centesimi,");
			System.out.println(venti + " monete da venti centesimi,");
			System.out.println(dieci + " monete da dieci centesimi,");
			System.out.println(cinque + " monete da cinque centesimi.");
		}
	}
}