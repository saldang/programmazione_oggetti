import java.util.Scanner;

/**
 * Classe che rappresenta una quantità di soldi non negativa
 */
public class Soldi {
	private long euro;
	private long centesimi;
	
	public void set(long nuoviEuro) {
		if (nuoviEuro < 0) {
			System.out.println("Errore: somme negative di soldi non sono permesse.");
			System.exit(0);
		} else {
			euro = nuoviEuro; 
			centesimi = 0;
		}
	}
	
	public void set(double nuovaSomma) {
		if (nuovaSomma < 0) {
			System.out.println("Errore: somme negative di soldi non sono permesse.");
			System.exit(0);
		} else {
			long centesimiTotali = Math.round(nuovaSomma * 100);
			euro = centesimiTotali / 100; 
			centesimi = centesimiTotali % 100;
		}
	}
	
	public void set(Soldi altriSoldi){
		this.euro = altriSoldi.euro;
		this.centesimi = altriSoldi.centesimi;
	}
	
	/** 
	 Precondizione: L’argomento è una rappresentazione corretta 
	 di una quantità di soldi, con o senza segno.
	 Frazioni di centesimi non sono ammesse.
	*/
	public void set(String sommaString)	{
		String stringaEuro; 
		String stringaCentesimi;
		//Cancella 'E' iniziale se presente:
		if (sommaString.charAt(0) == 'E') 
			sommaString = sommaString.substring(1);
		sommaString = sommaString.trim();

		//Trova il punto decimale:
		int posizionePunto = sommaString.indexOf("."); 
		if (posizionePunto < 0) { //Se non presente
			centesimi = 0; 
			euro = Long.parseLong(sommaString);
		} else { //La stringa ha un punto decimale. 
			stringaEuro = sommaString.substring(0, posizionePunto);
			stringaCentesimi = sommaString.substring(posizionePunto + 1);
			//una cifra nei centesimi significa decine di Euro
			if (stringaCentesimi.length() <= 1) 
				stringaCentesimi = stringaCentesimi + "0";
			// converte in formato numerico
			euro = Long.parseLong(stringaEuro); 
			centesimi = Long.parseLong(stringaCentesimi); 
			if ((euro < 0) || (centesimi < 0) || (centesimi > 99)) {
				System.out.println("Errore: rappresentazione illegale di soldi.");
				System.exit(0);
			}
		}
	}
	
	public void leggiInput() {
		System.out.println("Scrivi l'ammontare su una riga:"); 
		Scanner tastiera = new Scanner(System.in); 
		String somma = tastiera.nextLine();
		set(somma.trim());
	}
	
	/** 
	 Non va a capo dopo aver scritto l'ammontare di soldi.
	*/
	public void scriviOutput() {
		System.out.print("E" + euro);
		 if (centesimi < 10)
			 System.out.print(".0" + centesimi);
		 else
			 System.out.print("." + centesimi);
	}
	
	/** 
	 Moltiplica i soldi per il valore n fornito in input
	*/
	public Soldi moltiplica(int n) {
		Soldi prodotto = new Soldi();
		prodotto.centesimi = n * centesimi; 
		long riporto = prodotto.centesimi / 100; 
		prodotto.centesimi = prodotto.centesimi % 100; 
		prodotto.euro = n * euro + riporto;
		return prodotto;
	}
	
	/** 
	 Restituisce la somma tra l'oggetto invocante 
	 e l'argomento fornito in input
	*/
	public Soldi somma(Soldi altriSoldi) {
		Soldi somma = new Soldi();
		somma.centesimi = this.centesimi + altriSoldi.centesimi;
		long riporto = somma.centesimi / 100; 
		somma.centesimi = somma.centesimi % 100; 
		somma.euro = this.euro + altriSoldi.euro + riporto;
		return somma;
	}
}
