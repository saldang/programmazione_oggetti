import java.util.Scanner;

public class Temperatura {
	private double gradi;
	private double gradiConvertiti;
	private char unita;// 'C' per Celsius, 'F' per Fahrenheit

	// Quattro costruttori

	// Costruttore che imposta sia la temperatura che l'unita'
	public Temperatura(double iGradi, char lUnita) {
		gradi = iGradi;
		unita = lUnita;
	}

	// Costruttore che specifica solo i gradi
	// Viene impostato come default i gradi Celsius
	public Temperatura(double iGradi) {
		gradi = iGradi;
		unita = 'C';
	}

	// Costruttore che specifica solo l'unita'
	// Viene impostato come default 0 gradi
	public Temperatura(char lUnita) {
		gradi = 0;
		unita = lUnita;
	}

	// Costruttore di default
	// Default: 0 gradi Celsius.
	public Temperatura() {
		gradi = 0;
		unita = 'C';
	}

	// Metodo per immettere i valori degli attributi in maniera incrementale
	public void leggiInput() {
		Scanner tastiera = new Scanner(System.in);

		System.out.println();
		System.out.println("Temperatura in gradi(ad esempio 29.6): ");
		gradi = tastiera.nextFloat();
		System.out.println();
		System.out.println("'F' (o 'f') per Fahrenheit o " + "'C' (o 'c') per Celsius: ");
		unita = tastiera.next().charAt(0);
		System.out.println();
	}

	// Tre metodi di 'scrittura' per visualizzare la temperatura

	// Metodo per visualizzare i valori della temperatura.
	public void scriviOutput() {
		System.out.println();
		System.out.println("Temperatura = " + Math.round(gradi * 10) / 10.0 + " gradi " + unita + ".");
		System.out.println();
	}

	// Metodo per stampare la temperatura in gradi C.
	// La temperatura e' arrotondata e visualizzata ad una cifra decimale	
	public void scriviC() {
		switch (unita) {
		case 'F':
		case 'f':
			gradiConvertiti = 5 * (gradi - 32) / 9;
			// Divide per 10.0 cosi' il risultato è un numero in virgola con un valore decimale
			System.out.println("Temperatura = " + Math.round(gradiConvertiti * 10) / 10.0 + " gradi Celsius.");
			break;

		case 'C':
		case 'c':
			System.out.println("Temperatura = " + Math.round(gradi * 10) / 10.0 + " gradi Celsius.");
			break;

		default:
			System.out.println("Unita' sconosciuta -");
			System.out.println("  non riesco a determinare la temperatura.");
			System.out.println("La prossima volta inserisci 'F' per Fahrenheit o 'C' per Celsius.");		}
	}

	// Metodo per stampare la temperatura in gradi F.
	// La temperatura e' arrotondata e visualizzata ad una cifra decimale
	public void scriviF() {
		switch (unita) {
		case 'F':
		case 'f':
			System.out.println("Temperatura = " + Math.round(gradi * 10) / 10.0 + " gradi Fahrenheit.");
			break;

		case 'C':
		case 'c':
			gradiConvertiti = gradi * 9 / 5 + 32;
			System.out.println("Temperatura = " + Math.round(gradiConvertiti * 10) / 10.0 + " gradi Fahrenheit.");
			break;

		default:
			System.out.println("Unita' sconosciuta -");
			System.out.println("  non riesco a determinare la temperatura.");
			System.out.println("La prossima volta inserisci 'F' per Fahrenheit o 'C' per Celsius.");
		}
	}

	// Due metodi di get per la temperatura
	// Metodo che restituisce la temperatura in C.
	// Restituisce il valore dell'attributo gradi se
	// unita' è un carattere non consentito (diverso da c, C, f, o F).
	public double getC() {
		switch (unita) {
		case 'F':
		case 'f':
			gradiConvertiti = 5 * (gradi - 32) / 9;
			return Math.round(gradiConvertiti * 10) / 10.0;

		case 'C':
		case 'c':
			return Math.round(gradi * 10) / 10.0;

		default:
			return Math.round(gradi * 10) / 10.0;
		}
	}

	// Metodo che restituisce la temperatura in F.
	// Restituisce il valore dell'attributo gradi se
	// unita' è un carattere non consentito (diverso da c, C, f, o F).
	public double getF() {
		switch (unita) {
		case 'F':
		case 'f':
			return Math.round(gradi * 10) / 10.0;

		case 'C':
		case 'c':
			gradiConvertiti = gradi * 9 / 5 + 32;
			return Math.round(gradiConvertiti * 10) / 10.0;

		default:
			return Math.round(gradi * 10) / 10.0;
		}
	}

	// Tre metodi di set per gli attributi

	// Metodo per impostare la temperatura e l'unita'
	// Postcondizione: Nessuna garanzia che il valore di unita sia valido
	public void set(double nuoviGradi, char nuovaUnita) {
		set(nuoviGradi);
		set(nuovaUnita);
	}

	// Metodo per impostare solo la temperatura
	public void set(double nuoviGradi) {
		gradi = nuoviGradi;
	}

	// Metodo per impostare solo l'unita'
	// Postcondizione: Nessuna garanzia che il valore di unita sia valido
	public void set(char nuovaUnita) {
		unita = nuovaUnita;
	}

	// Tre metodi di confronto
	// Converte le temperature in un numero intero di decimi di gradi
	// per evitare errori dovuti al confronto dei numeri in virgola mobile,
	// che spesso non possono essere memorizzati con precisione.
	public boolean equals(Temperatura another) {
		// Usa le stesse unita' per il confronto
		return (Math.round(this.getC() * 10) == Math.round(another.getC() * 10));
	}

	// Converte le temperature in un numero intero di decimi di gradi
	// per evitare errori dovuti al confronto dei numeri in virgola mobile,
	// che spesso non possono essere memorizzati con precisione.
	public boolean maggioreDi(Temperatura altra) {
		// Usa le stesse unita' per il confronto
		return (Math.round(this.getC() * 10) > Math.round(altra.getC() * 10));
	}

	// Converte le temperature in un numero intero di decimi di gradi
	// per evitare errori dovuti al confronto dei numeri in virgola mobile,
	// che spesso non possono essere memorizzati con precisione.
	public boolean minoreDi(Temperatura altra) {
		// Usa le stesse unita' per il confronto
		return (Math.round(this.getC() * 10) < Math.round(altra.getC() * 10));
	}
}
