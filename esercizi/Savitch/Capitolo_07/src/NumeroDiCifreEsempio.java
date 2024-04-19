import java.util.*;

public class NumeroDiCifreEsempio {
	public static int numeroDiCifre(int n) {
		if (n < 0)
			n = -n; // non considera il segno -

		if (n / 10 == 0) // una sola cifra
			return 1;
		else
			return (numeroDiCifre(n / 10) + 1);
	}

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Inserisci un intero:");
		int numero = tastiera.nextInt();
		System.out.println(numero + " contiene " + numeroDiCifre(numero) + " cifre.");
	}
}
