
public class MetodiPerArray2D {

	// Esercizio 13
		public static double[][] cercaFigura(double[][] figura, double soglia) {
			int maxRiga = figura.length;
			int maxColonna = figura[0].length;
			double[][] nuovaFigura = new double[maxRiga][maxColonna];

			double somma = 0.0;

			for (int i = 0; i < maxRiga; i++) {
				for (int j = 0; j < maxColonna; j++) {
					somma += figura[i][j];
				}
			}

			double media = somma / (maxRiga * maxColonna);
			double trigger = media * soglia;

			System.out.println("La media e' " + media + " ogni valore sopra " + trigger + " sara' 1.0");

			for (int i = 0; i < maxRiga; i++) {
				for (int j = 0; j < maxColonna; j++) {
					if (figura[i][j] > trigger) {
						nuovaFigura[i][j] = 1.0;
					} else {
						nuovaFigura[i][j] = 0.0;
					}
				}
			}

			return nuovaFigura;
		}

	// Esercizio 14
	public static double[][] blur(double[][] immagine) {

		int maxRiga = immagine.length;
		int maxColonna = immagine[0].length;
		double[][] nuovaImmagine = new double[maxRiga][maxColonna];

		for (int i = 0; i < maxRiga; i++) {
			for (int j = 0; j < maxColonna; j++) {
				double somma = 0.0;
				double conteggio = 0;

				if (indiciValidi(i - 1, j - 1, maxRiga, maxColonna)) {
					somma += immagine[i - 1][j - 1];
					conteggio += 1;
				}
				if (indiciValidi(i - 1, j, maxRiga, maxColonna)) {
					somma += 2 * immagine[i - 1][j];
					conteggio += 2;
				}
				if (indiciValidi(i - 1, j + 1, maxRiga, maxColonna)) {
					somma += immagine[i - 1][j + 1];
					conteggio += 1;
				}

				// 3 medie
				if (indiciValidi(i, j - 1, maxRiga, maxColonna)) {
					somma += 2 * immagine[i][j - 1];
					conteggio += 2;
				}
				if (indiciValidi(i, j, maxRiga, maxColonna)) {
					somma += 4 * immagine[i][j];
					conteggio += 4;
				}
				if (indiciValidi(i, j + 1, maxRiga, maxColonna)) {
					somma += 2 * immagine[i][j + 1];
					conteggio += 2;
				}

				// 3 inferiori
				if (indiciValidi(i + 1, j - 1, maxRiga, maxColonna)) {
					somma += immagine[i + 1][j - 1];
					conteggio += 1;
				}
				if (indiciValidi(i + 1, j, maxRiga, maxColonna)) {
					somma += 2 * immagine[i + 1][j];
					conteggio += 2;
				}
				if (indiciValidi(i + 1, j + 1, maxRiga, maxColonna)) {
					somma += immagine[i + 1][j + 1];
					conteggio += 1;
				}

				nuovaImmagine[i][j] = somma / conteggio;
			}
		}

		return nuovaImmagine;
	}

	private static boolean indiciValidi(int riga, int colonna, int maxRiga, int maxColonna) {
		return (riga >= 0 && riga < maxRiga && colonna >= 0 && colonna < maxColonna);
	}

	
	public static void main(String[] args) {
		double[][] campione = { { 1.2, 1.3, 4.5, 6.0, 2.7 }, { 1.7, 3.3, 4.4, 10.5, 17.0 }, { 1.1, 4.5, 2.1, 25.3, 9.2 },
				{ 1.0, 9.5, 8.3, 2.9, 2.1 } };

		System.out.println("L'array originale e': ");
		mostraArrayConPrecisione(campione, 2);

		double[][] changed = blur(campione);
		System.out.println("L'array dopo l'operazione di blur e': ");
		mostraArrayConPrecisione(changed, 2);

		double[][] figure = cercaFigura(campione, 0.6);
		System.out.println("Limmagine per una soglia di 0.6 e': ");
		mostraArrayConPrecisione(figure, 1);
	}

	public static void mostraArrayConPrecisione(double[][] data, int cifre) {
		double moltiplicatore = Math.pow(10.0, cifre);
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				double daMostrare = Math.round(data[i][j] * moltiplicatore) / moltiplicatore;
				System.out.print(daMostrare + "  ");
			}
			System.out.println();
		}

	}

}
