import java.util.Scanner;

public class DaBinario {

	public static void main(String[] args) {

		Scanner tastiera = new Scanner(System.in);

		System.out.println("Inserisci un numero binario di quattro bit.");

		String binario = tastiera.next();

		String bit0 = binario.substring(0, 1);
		String bit1 = binario.substring(1, 2);
		String bit2 = binario.substring(2, 3);
		String bit3 = binario.substring(3, 4);

		int b0 = Integer.parseInt(bit0);
		int b1 = Integer.parseInt(bit1);
		int b2 = Integer.parseInt(bit2);
		int b3 = Integer.parseInt(bit3);

		int valore = b0 * 8 + b1 * 4 + b2 * 2 + b3;

		System.out.println("Il valore di " + binario + " e' " + valore);
	}
}
