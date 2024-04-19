/**
 * Questo programma fa quanto segue: Crea un'istanza della classe "Contatore"
 * per testare i metodi definiti: 1. Imposta il contatore su zero usando il
 * metodo setZero(). 2. Aumenta il contatore utilizzando incrementa() quindi
 * stampa il suo valore due volte, una volta utilizzando stampaContatore(), e di
 * nuovo utilizzando getContatore(), in un ciclo che si ripete 10 volte. 3. Allo
 * stesso modo, decrementa il contatore utilizzando decrementa() quindi stampa
 * il suo valore ogni volta tramite un ciclo che si ripete 11 volte (per
 * assicurarsi che non può scendere sotto lo zero).
 * 
 * Note: il codice è stato messo in entrambi i cicli per fermare il programma in
 * modo da può vedere il risultato di ogni iterazione..
 */

public class ContatoreTest {
	public static void main(String[] args) {
		Contatore testContatore = new Contatore();

		testContatore.setZero();
		System.out.println("Dopo setZero(): " + testContatore.getValore());

		int i;
		for (i = 0; i < 10; i++) {
			System.out.println("Ciclo numero = " + i);
			testContatore.incrementa();
			System.out.println("Dopo incrementa() usando stampaContatore(): ");
			testContatore.stampaContatore();
			System.out.println("Usando getValore() per restituire il valore: " + testContatore.getValore());
		}

		for (i = 0; i < 11; i++) {
			System.out.println("Ciclo numero = " + i);
			testContatore.decrementa();
			System.out.println("Dopo decrementa() usando stampaContatore(): ");
			testContatore.stampaContatore();
			System.out.println("Usando getValore() per restituire il valore: "  + testContatore.getValore());
		}
	}
}
