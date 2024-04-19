public class Esempio2 {
	public static void main(String[] args) {
		System.out.println("Il risultato e’:");
		metodo(11156);
		System.out.println();
	}

	public static void metodo(int numero) {
		if (numero > 0) {
			int d = numero % 10;
			boolean dispari = (numero / 10) % 2 == 1;
			metodo(numero / 10);
			if (dispari)
				System.out.print(d / 2 + 5);
			else
				System.out.print(d / 2);
		}
	}
}
