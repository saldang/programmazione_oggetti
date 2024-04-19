
public class ConvertiScientifico {

	/**
	 * Mostra l'ammontare in Euro e centesimi. Arrotonda dopo due decimali. Non
	 * inserisce una nuova riga dopo la fine dell'output.
	 */
	public static void scrivi(double somma) {
		if (somma >= 0) {
			System.out.print('E');
			scriviPositivo(somma);
		} else {
			double sommaPositiva = -somma;
			System.out.print('E');
			System.out.print('-');
			scriviPositivo(sommaPositiva);
		}
	}

	/**
	 * Precondizione: somma > 0 Mostra l'ammontare in Euro e centesimi. Arrotonda
	 * dopo due decimali. Non inserisce una nuova riga dopo la fine dell'output.
	 */
	public static void scriviPositivo(double somma) {
		int centesimiTotali = (int) (Math.round(somma * 100));
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
	 * Mostra l'ammontare in Euro e centesimi. Arrotonda dopo due decimali.
	 * Inserisce una nuova riga dopo la fine dell'output.
	 */
	public static void scriviRiga(double somma) {
		scrivi(somma);
		System.out.println();
	}

	
	/********************/

	/**
	 * Scrive numero con un numero di cifre decimali pari a ciferDopoPunto Arrotonda
	 * ogni cifra extra. Non inserisce una nuova riga dopo la fine dell'output.
	 */
	private static void scrivi(double numero, int cifreDopoPunto) {
		if (numero >= 0)
			scriviPositivo(numero, cifreDopoPunto);
		else {
			double numeroPositivo = -numero;
			System.out.print('-');
			scriviPositivo(numeroPositivo, cifreDopoPunto);
		}
	}

	/**
	 * Precondizione: numero >= 0. Scrive numero con cifreDopoPunto cifre dopo il punto decimale.
	 * Arrotonda ogni altra cifra.
	 */
	private static void scriviPositivo(double numero, int cifreDopoPunto) {
		int mover = (int) (Math.pow(10, cifreDopoPunto));
		// 1 seguito da cifreDopoPunto zeri

		int numeroCompleto = (int) (Math.round(numero * mover));
		int primaPunto = numeroCompleto / mover;
		int dopoPunto = numeroCompleto % mover;

		System.out.print(primaPunto);
		System.out.print('.');
		scriviFrazione(dopoPunto, cifreDopoPunto);
	}

	/**
	 * Stampa l'intero dopo il punto con abbastanza zeri davanti 
	 * in modo da far si che le cifre di cifreDopoPunto siano abbastanza
	 * */
	private static void scriviFrazione(int dopoPunto, int cifreDopoPunto) {
		int n = 1;
		while (n < cifreDopoPunto) {
			if (dopoPunto < Math.pow(10, n))
				System.out.print('0');

			++n;
		}
		System.out.print(dopoPunto);
	}

	
	/**
	 * Scrive il numero con cifreDopoPunto cifre dopo il punto decimale
	 * Arrotonda ogni cifra extra. Non inserisce una nuova riga dopo la fine dell'output.
	 */
	public static void scriviRiga(double numero, int cifreDopoPunto) {
		scrivi(numero, cifreDopoPunto);
		System.out.println();
	}

	// Notazione scientifica E
	/**
	 * Scrive numero in notazione scientifica ("e"), cioè con una cifra diversa da zero
	 * alla sinistra del punto decinale, cifreDopoPunto cifre dopo il punto decimale,
	 * e l'esponente a 10 per posizionare correttamente il punto decimale.
	 * Arrotonda ogni ulteriore cifra
	 * Non inserisce una nuova riga dopo la fine dell'output.
	 */
	private static void scriviScientifico(double numero, int cifreDopoPunto) {
		if (numero >= 0)
			scriviScientificoPositivo(numero, cifreDopoPunto);
		else {
			double numeroPositivo = -numero;
			System.out.print('-');
			scriviScientificoPositivo(numeroPositivo, cifreDopoPunto);
		}
	}

	/**
	 * Precondizione: numero >= 0. Scrive numero con una cifra diversa da zero a sinistra del punto decimale
	 * e cifreDopoPunto cifre dopo il punto decimale e esponente a 10.
	 * Arrotonda ogni altra cifra.
	 */
	private static void scriviScientificoPositivo(double numero, int cifreDopoPunto) {
		int numeroIntero = (int) numero; 
		int e = 0; // esponente iniziale

		if (numeroIntero > 0) { // Esponente positivo
			while (numeroIntero >= 10) {
				++e;
				numeroIntero = numeroIntero / 10;
			}
		} else { // Esponente negativo
			double nextValue = numero;
			while ((int) nextValue < 1) {
				--e;
				nextValue = nextValue * 10;
			}
		}

		int mover = (int) (Math.pow(10, cifreDopoPunto)); // 1 seguito da zero cifreDopoPunto
		int secondMover; 
		int allWhole;

		if (e < 0) {
			secondMover = (int) (Math.pow(10, -e));
			// il metodo pow non accetta esponenti negativi
			allWhole = (int) (Math.round(numero * mover * secondMover));
		} else { // e più grande od uguale a zero
			secondMover = (int) (Math.pow(10, e));
			allWhole = (int) (Math.round(numero * mover / secondMover));
		}

		int beforePoint = allWhole / mover;
		int afterPoint = allWhole % mover;

		System.out.print(beforePoint);
		System.out.print('.');
		scriviFrazione(afterPoint, cifreDopoPunto);
		System.out.print("e" + e);
	}

	/**
	 * Scrive numero in notazione scientifica ("e"), cioè con una cifra diversa da zero
	 * alla sinistra del punto decinale, cifreDopoPunto cifre dopo il punto decimale,
	 * e l'esponente a 10 per posizionare correttamente il punto decimale.
	 * Arrotonda ogni ulteriore cifra
	 * Inserisce una nuova riga dopo la fine dell'output.
	 */
	public static void scriviScientificoRiga(double numero, int cifreDopoPunto) {
		scriviScientifico(numero, cifreDopoPunto);
		System.out.println();
	}
}
