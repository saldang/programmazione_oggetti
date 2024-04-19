public class Enigmista {
	public static void main(String[] args) {
		// Prova tutti gli indirizzi da 1000 a 9999 w verifica se soddisfano i vincoli
		int indirizzo;
		int migliaia, centinaia, decine, unita; // Cifre

		/* Versione che usa un solo numero intero */
		for (migliaia = 0; migliaia <= 9; migliaia++) {
			for (centinaia = 0; centinaia <= 9; centinaia++) {
				for (decine = 0; decine <= 9; decine++) {
					for (unita = 0; unita <= 9; unita++) {
						// Verifica tutte le condizoni
						boolean differentDigits;
						differentDigits = (migliaia != centinaia) && (migliaia != decine) && (migliaia != unita)
								&& (centinaia != decine) && (centinaia != unita) && (decine != unita);
						indirizzo = migliaia * 1000 + centinaia * 100 + decine * 10 + unita;
						boolean isOdd = ((indirizzo % 2) == 1);
						boolean thousandsValue = (migliaia == 3 * decine);
						boolean sum27 = (migliaia + centinaia + decine + unita) == 27;

						// Stampa l'indirizzo se tutte le condizoni sono verificate
						if (differentDigits && isOdd && thousandsValue && sum27)
							System.out.println("L'indirizzo e' " + migliaia + " " + centinaia + " " + decine + " " + unita
									+ " su Pennsylvania Avenue.");
					}
				}
			}
		}

		/* Da qui in giu' fa la setssa cosa, ma controlla le singole cifre */
		for (indirizzo = 1000; indirizzo <= 9999; indirizzo++) { // Prendi ogni cifra
			migliaia = (indirizzo / 1000) % 10;
			centinaia = (indirizzo / 100) % 10;
			decine = (indirizzo / 10) % 10;
			unita = indirizzo % 10;

			// Verifica tutte le condizoni
			boolean cifrediverse = (migliaia != centinaia) && (migliaia != decine) && (migliaia != unita)
					&& (centinaia != decine) && (centinaia != unita) && (decine != unita);
			boolean dispari = ((indirizzo % 2) == 1);
			boolean valoreMigliaia = (migliaia == 3 * decine);
			boolean somma27 = (migliaia + centinaia + decine + unita) == 27;

			// Stampa l'indirizzo se tutte le condizoni sono verificate
			if (cifrediverse && dispari && valoreMigliaia && somma27)
				System.out.println("L'indirizzo e' " + indirizzo + " su Pennsylvania Avenue.");
		}

	}
}