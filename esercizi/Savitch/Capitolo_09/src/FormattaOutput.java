public class FormattaOutput {
	/**
	 * Scrive il numero con cifreDopoPunto cifre dopo il punto decimale. Arrotonda
	 * le cifre extra. Non avanza alla linea successiva dopo l'uscita.
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

	// Precondition: number >= 0

	/**
	 * Scrive il numero con cifreDopoPunto cifre dopo il punto decimale. 
	 * Arrotonda le cifre extra.
	 * Precondizone: numero >= 0
	 * */
	private static void scriviPositivo(double numero, int cifreDopoPunto) {
		int mover = (int) (Math.pow(10, cifreDopoPunto));
		// 1 seguito da cifreDopoPunto zeri
		int allWhole;// numero con il punto decimale
		allWhole = (int) (Math.round(numero * mover));
		int primaDelPunto = allWhole / mover;
		int dopoIlPunto = allWhole % mover;

		System.out.print(primaDelPunto);
		System.out.print('.');
		scriviFrazione(dopoIlPunto, cifreDopoPunto);
	}

	// Stampa l'intero dipoIlPuntocon abbastanza zeri davanti
	// per renderlo lungo quanto ciferDopoPunto.
	private static void scriviFrazione(int dopoIlPunto, int ciferDopoPunto) {
		int n = 1;
		while (n < ciferDopoPunto) {
			if (dopoIlPunto < Math.pow(10, n))
				System.out.print('0');
			n = n + 1;
		}
		System.out.print(dopoIlPunto);
	}

	/**
	 * Scrive il numero con cifreDopoPunto cifre dopo il punto decimale. Arrotonda
	 * le cifre extra. Avanza alla linea successiva dopo l'uscita.
	 */
	public static void scriviACapo(double numero, int cifreDopoPunto) {
		scrivi(numero, cifreDopoPunto);
		System.out.println();
	}
}