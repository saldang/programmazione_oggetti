public class Esempio1 {
	public static void main(String[] args) {
		System.out.println("Il risultato e’:");
		metodo(23);
	}

	public static void metodo(int numero) {
		if (numero > 0) {
			metodo(numero / 2);
			System.out.print(numero % 2);
		}
	}
}
