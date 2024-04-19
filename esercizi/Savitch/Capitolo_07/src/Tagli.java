import java.util.Scanner;

public class Tagli {

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Calcolo del numero di modi in cui è possibile tagliare una barretta di cioccolato.");
		System.out.println(
				"Inserisci un numero intero k (Numero di pezzi in cui vuoi venga tagliata la barretta di cioccolato): ");
		int numero = tastiera.nextInt();

		System.out.println("Il numero di modi per tagliare la barretta con tagli in qualsiasi ordine: " + c(numero));
		System.out.println(
				"Il numero di modi per tagliare la barretta con tagli solo nel pezzo più a sinistra: " + d(numero));
	}

	public static long c(int k) {
		long result;

		if (k == 0) {
			result = 1;
		} else {
			result = k * c(k - 1);
		}

		return result;
	}

	public static long d(int k) {
		long result;

		if (k == 0) {
			result = 1;
		} else {
			result = 0;
			for (int i = 1; i <= k; i++) {
				result += d(i - 1) * d(k - i);
			}
		}
		return result;
	}

}
