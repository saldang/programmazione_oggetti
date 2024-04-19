import java.util.Scanner;

enum Mese {
	GEN, FEB, MAR, APR, MAG, GIU, LUG, AGO, SET, OTT, NOV, DIC
}

public class Frammenti {
	public static void main(String[] args) {

		// Esercizio 1
		Scanner tastiera = new Scanner(System.in);
		String parola = "";

		System.out.println("Inserire delle parole. Per terminare inserire 'fine'");
		parola = tastiera.next();
		while (!parola.equals("fine")) {
			if (parola.charAt(0) == parola.charAt(parola.length() - 1)) {
				System.out.println("La parola " + parola + " ha il primo e l'ultimo carattere uguale.");
			}
			parola = tastiera.next();
		}

		System.out.println("Inserire delle parole. Per terminare inserire 'fine'");
		boolean finito = false;
		do {
			parola = tastiera.next();
			if (parola.equals("fine")) {
				finito = true;
			} else {
				if (parola.charAt(0) == parola.charAt(parola.length() - 1)) {
					System.out.println("La parola " + parola + " ha il primo e l'ultimo carattere uguale.");
				}
			}
		} while (!finito);

		
		// Esercizio 4
		int n = 5;
		int somma = 0;
		int dispari = 1;
		for (int i = 0; i < n; i++) {
			somma += dispari;
			dispari += 2;
		}
		System.out.println("La somma dei primi " + n + " numeri dispari e' " + somma);

		
		// Esercizio 5
		int s = 0;
		int t = 1;
		int i = 0;
		while (i < 10) {
			s = s + i;
			int j = i;
			while (j > 0) {
				t = t * (j - i);
				j--;
			}
			s = s * t;
			System.out.println("T vale " + t);
			i++;
		}
		System.out.println("S vale " + s);

		
		// Esercizio 6
		somma = 0;
		for (i = 1; i <= n; i++) {
			somma += i * i;
		}
		System.out.println("La somma e' " + somma);

		
		// Esercizio 7
		for (somma = 0, i = 1; i <= n; somma += i * i, i++) {
		}
		System.out.println("La somma e' " + somma);

		
		// Esercizio 11
		int numeroPartecipanti = 8;
		int stretteDiMano = 0;
		for (int persona = 1; persona <= numeroPartecipanti; persona++) {
			stretteDiMano += (persona - 1);
			// Quando arriva la persona k, lei stringera'
			// la mano alle k-1 persone già presenti
		}
		System.out.println("La somma e' " + somma);

		
		// Esercizio 12
		//enum Mese {GEN, FEB, MAR, APR, MAG, GIU, LUG, AGO, SET, OTT, NOV, DIC}
		for (Mese prossimo : Mese.values())
			System.out.print(prossimo + " ");
		System.out.println();

		
		// Esercizio 13
		int innings = 9;
		int squadra1Totale = 0;
		int squadra2Totale = 0;
		Scanner tastiera1 = new Scanner(System.in);
		
		for (int inning = 1; inning <= innings; inning++) {
			System.out.println("Quanti punti sono stati ottenuti all'inning " + inning + " da ogni squadra?");
			squadra1Totale = squadra1Totale + tastiera1.nextInt();
			squadra2Totale = squadra2Totale + tastiera1.nextInt();
		}
		System.out.println("La prima squadra ha totalizzato: " + squadra1Totale + " punti e la seconda squadra ha totalizzato: " + squadra2Totale + " punti");

		
		// Esercizio 14
		double volume = 0.0;
		double altezza = 0.0;
		double raggio = 0.0;
		double costo = 0.0;
		String risposta;
		Scanner tastiera2 = new Scanner(System.in);

		do {
			System.out.println("Inserisci il volume e il raggio del cilindro ");
			volume = tastiera2.nextDouble();
			raggio = tastiera2.nextDouble();

			altezza = volume / (Math.PI * raggio * raggio);
			costo = 2 * Math.PI * raggio * (raggio + altezza);

			System.out.println("L'altezza richiesta e' " + altezza + " e il costo e' " + costo);

			System.out.println("Vuoi calcolare il costo per un volume ed un'altezza diversi?");
			System.out.println("Scrivi si o no.");
			risposta = tastiera2.next();
		} while (risposta.equalsIgnoreCase("si"));

		
		// Esercizio 15
		int conteggio = 0;
		double valore = 0.0;
		double prodotto = 1.0;
		
		Scanner tastiera3 = new Scanner(System.in);

		System.out.println("Inserisci i valori per i quali si vuole calcolare la media geometrica.");
		System.out.println("Inserisci un valore negativo dopo che hai inserito tutti i vlori.");
		valore = tastiera3.nextDouble();
		while (valore >= 0) {
			prodotto = prodotto * valore;
			conteggio++;
			valore = tastiera3.nextDouble();
		}
		System.out.println("La media geometrica e' " + Math.pow(prodotto, 1.0 / conteggio));
	}
}
