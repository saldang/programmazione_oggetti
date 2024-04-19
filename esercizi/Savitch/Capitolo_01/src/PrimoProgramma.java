import java.util.Scanner;

public class PrimoProgramma {

	public static void main(String[] args) {
		System.out.println("Ciao!");
		System.out.println("Eseguo la somma di due numeri.");
		System.out.println("Digita entrambi i numeri sulla stessa riga:");

		int n1, n2;

		Scanner tastiera = new Scanner(System.in);

		n1 = tastiera.nextInt();
		n2 = tastiera.nextInt();

		System.out.println("Ecco la somma dei due numeri:");
		System.out.println(n1 + n2);
	}
}