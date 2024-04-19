
public class FormattaEuroTroncato {

	/** 
	 Mostra l'ammontare in Euro e centesimi. 
	 Tronca qualisi cifra dopo la seocnda decimale.
	 Non inserisce una nuova riga dopo la fine dell'output.
	*/
	public static void scrivi(double somma){
		if (somma >= 0) {
			System.out.print('E');
			scriviPositivo(somma);
		} else {
			double sommaPositiva = - somma; 
			System.out.print('E'); 
			System.out.print('-'); 
			scriviPositivo(sommaPositiva);
		}
	}
	
	/** 
	 Precondizione: somma > 0
	 Mostra l'ammontare in Euro e centesimi. 
	 Tronca qualisi cifra dopo la seocnda decimale.
	*/
	public static void scriviPositivo(double somma) {
		//La moltiplicazione va fatta prima di convertire ad intero. 
		//Se fatta dopo, si perdono le cifre decimali
		int centesimiTotali = (int)(somma * 100); 
		int euro = centesimiTotali / 100; 
		int centesimi = centesimiTotali % 100;

		System.out.print(euro);
		System.out.print('.');
		
		if (centesimi < 10) {
			System.out.print('0');
			System.out.print(centesimi);
		} else
			System.out.print(centesimi);	
	}
	
	/** 
	 Mostra l'ammontare in Euro e centesimi. 
	 Tronca qualisi cifra dopo la seocnda decimale.
	 Inserisce una nuova riga dopo la fine dell'output.
	*/
	public static void scriviRiga(double somma) {
		scrivi(somma);
		System.out.println();
	}
}
