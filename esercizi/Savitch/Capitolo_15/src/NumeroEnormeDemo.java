
public class NumeroEnormeDemo {

	public static void main(String[] args) {
		// Crea il numero enorme 123456789
		NumeroEnorme h1 = new NumeroEnorme();
		for (int i = 9; i >= 1; i--) {
			h1.aggiungiCifra(i);
		}
		System.out.println(h1.toString());

		// Crea il numero enorme 55555555558888888888
		NumeroEnorme h2 = new NumeroEnorme();
		for (int i = 0; i < 10; i++) {
			h2.aggiungiCifra(8);
		}
		for (int i = 0; i < 10; i++) {
			h2.aggiungiCifra(5);
		}
		System.out.println(h2.toString());

		// Reset h1
		h1.reimpostaValore();
		System.out.println(h1.toString());
	}

}
