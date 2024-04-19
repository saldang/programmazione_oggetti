/**
Visualizza una tabella bi-dimensionale mostrando come
i tassi di interesse influiscono sui bilanci delle banche.
*/
public class TabellaInteressi {

	public static void main(String[] args) {
		int[][] tabella = new int[10][6];

		for (int riga = 0; riga < 10; riga++)
			for (int colonna = 0; colonna < 6; colonna++)
				tabella[riga][colonna] = getBilancio(1000.00, riga + 1, (5 + 0.5 * colonna));

		System.out.println("Bilanci per vari Tassi di Interesse Capitalizzazione annuale");
		System.out.println("(Arrotondato a Valori Interi di Euro)");
		System.out.println();
		System.out.println("Anni 5.00% 5.50% 6.00% 6.50% 7.00% 7.50%");

		for (int riga = 0; riga < 10; riga++) {
			System.out.print((riga + 1) + "    ");

			for (int colonna = 0; colonna < 6; colonna++)
				System.out.print("€" + tabella[riga][colonna] + " ");

			System.out.println();
		}
	}

	/**
	Restituisce il bilancio in conto dopo un dato numero di anni
	e il tasso di interesse con un bilancio iniziale di bilancioIniziale.
	L’interesse e’ calcolato annualmente. Il bilancio e’ arrotondato
	ad un numero intero.
	*/
	public static int getBilancio(double bilancioIniziale, int anni, double tasso) {
		double bilancioCorrente = bilancioIniziale;

		for (int conteggio = 1; conteggio <= anni; conteggio++)
			bilancioCorrente = bilancioCorrente * (1 + tasso / 100);

		return (int)(Math.round(bilancioCorrente));
	}
}
