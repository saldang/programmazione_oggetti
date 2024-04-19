import java.util.Scanner;

public class Saluta {

	public static void saluta(String nome, int n) {
		for(int i = 0; i < n; i++)
			System.out.println("Ciao " + nome);
	}
	
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Inserisci un nome: ");
		String nome = tastiera.next();
		System.out.println("Inserisci un intero positivo: ");
		int n = tastiera.nextInt();
		System.out.println();
		
		saluta(nome, n);

	}

}
