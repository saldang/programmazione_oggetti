import java.util.Scanner;

/**
 Classe per l'acquisto di molteplici quantita' di 
 un solo tipo di articolo, come 3 arance.
 I prezzi sono memorizzati nello stile delle offerte
 di un supermercato, come 5 per 1.25 Euro
*/
public class Acquisto {

	private String nome; 
	private int dimGruppo;  	    //Parte del prezzo, come il 5
                           		    //in 5 per E 1.25. 
	private double prezzoGruppo;    //Parte del prezzo, come il 1.25
                               	    //in 5 per E 1.25. 
	private int articoliAcquistati; //Numero di articoli acquistati.


	public void setNome(String nuovoNome) {
		nome = nuovoNome;
	}

	/**
	  Imposta il prezzo per numeroArticoli pezzi a Euro prezzo.
	  Per esempio, 2 per E 1.99 
	*/
	public void setPrezzo(int numeroArticoli, double prezzo) {
		if ((numeroArticoli <= 0) || (prezzo <= 0)) {
			System.out.println("Errore: parametro errato in setPrezzo.");
			System.exit(0);
		} else {
			dimGruppo = numeroArticoli;
			prezzoGruppo = prezzo; 
		}
	}
	
	public void setArticoliAcquistati(int numero) {
		if (numero <= 0) {
			System.out.println("Errore: parametro non corretto in setArticoliAcquistati.");
			System.exit(0);
		} else
			articoliAcquistati = numero;
	}
	
	/**
	 * Legge dalla tastiera il prezzo ed il numero di un acquisto
	 */
	public void leggiInput() {
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Inserisci il nome dell'articolo che intendi acquistare:");
		nome = tastiera.nextLine();
		System.out.println("Inserisci il prezzo dell'articolo usando due cifre.");
		System.out.println("Per esempio 3 per 2.99 Euro viene scritto come");
		System.out.println("3 2.99");
		System.out.println("Inserisci il prezzo dell'articolo usando due cifre:");
		dimGruppo = tastiera.nextInt();
		prezzoGruppo = tastiera.nextDouble();
		while ((dimGruppo <= 0) || (prezzoGruppo <= 0)) { //Prova ancora
			System.out.println("Entrambi i numeri devono essere positivi, riprova.");
			System.out.println("Inserisci il prezzo dell'articolo usando due cifre.");
			System.out.println("Per esempio 3 per 2.99 Euro viene scritto come");
			System.out.println("3 2.99");
			System.out.println("Inserisci il prezzo dell'articolo usando due cifre:");
			dimGruppo = tastiera.nextInt();
			prezzoGruppo = tastiera.nextDouble();
		}

		System.out.println("Inserisci il numero di articoli acquistati:");
		articoliAcquistati = tastiera.nextInt();
		while (articoliAcquistati <= 0) { //Prova ancora:
			System.out.println("Il numero deve essere positivo, prova ancora.");
			System.out.println("Inserisci il numero di articoli acquistati: ");
			articoliAcquistati = tastiera.nextInt();
		}
	}
	
	/**
	 * Mostra il prezzo e il numero di articoli acquistati
	 */
	public void writeOutput() {
		System.out.println(articoliAcquistati + " " + nome);
		System.out.println("al prezzo di " + dimGruppo +
				" per " + prezzoGruppo + " Euro.");
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getCostoTotale() {
		return (prezzoGruppo / dimGruppo) * articoliAcquistati;
	}
	
	public double getCostoUnitario() {
		return prezzoGruppo / dimGruppo;
	}
	
	public int getArticoliAcquistati(){
		return articoliAcquistati;
	}
}
