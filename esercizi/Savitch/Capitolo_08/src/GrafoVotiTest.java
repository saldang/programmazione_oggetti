public class GrafoVotiTest {
	public static void main(String[] args) {
		int numeroA;
		int numeroB;
		int numeroC;
		int numeroD;
		int numeroF;

		System.out.println();
		System.out.println("Test case 1: leggiInput() and scrivi()");
		GrafoVoti voti = new GrafoVoti();
		voti.leggiInput();
		System.out.println();
		voti.stampa();
		System.out.println();
		System.out.println("===============================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 2:");
		System.out.println("imposta i punteggi contemporaneamente: A=1, B=2, etc.");
		voti.set(1, 2, 3, 4, 5);
		System.out.println();
		System.out.println("Verifica con stampa():");
		voti.stampa();
		System.out.println("===============================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 3:");
		System.out.println("imposta i punteggi individualmente");
		System.out.println("A=10, B=9, etc.");
		voti.setNumeroA(10);
		voti.setNumeroB(9);
		voti.setNumeroC(8);
		voti.setNumeroD(7);
		voti.setNumeroF(6);
		System.out.println();
		System.out.println("Verifica con stampa():");
		voti.stampa();
		System.out.println("===============================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 4:");
		System.out.println("stampa i conteggi indivisualmente:");
		System.out.println();
		System.out.println("Verifica A=10, B=9, etc.");
		System.out.println();
		voti.stampaNumeroA();
		voti.stampaNumeroB();
		voti.stampaNumeroC();
		voti.stampaNumeroD();
		voti.stampaNumeroF();
		System.out.println("===============================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 5:");
		System.out.println("get i conteggi individualmente:");
		System.out.println();
		System.out.println("Verifica A=10, B=9, etc.");
		System.out.println();
		System.out.println("Numero di A = " + voti.getNumeroA());
		System.out.println("Numero di B = " + voti.getNumeroB());
		System.out.println("Numero di C = " + voti.getNumeroC());
		System.out.println("Numero di D = " + voti.getNumeroD());
		System.out.println("Numero di F = " + voti.getNumeroF());
		System.out.println();
		System.out.println("===============================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 6:");
		System.out.println("get il numero totale di voti");
		System.out.println();
		System.out.println("Verifica totale = 40");
		System.out.println();
		System.out.println("Totale numero di voti = " + voti.getNumeroTotaleVoti());
		System.out.println();
		System.out.println("===============================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 7:");
		System.out.println("get la percentuale di ogni voto");
		System.out.println();
		System.out.println("Varifica A=25, B=23, C=20, D=18, & F=15");
		System.out.println();
		System.out.println("Percentuale di A = " + voti.getPercentualeA());
		System.out.println("Percentuale di B = " + voti.getPercentualeB());
		System.out.println("Percentuale di C = " + voti.getPercentualeC());
		System.out.println("Percentuale di D = " + voti.getPercentualeD());
		System.out.println("Percentuale di F = " + voti.getPercentualeF());
		System.out.println();
		System.out.println("===============================");
		System.out.println();

		System.out.println();
		System.out.println("Test case 8:");
		System.out.println("Disegna il grafo delle percentuali dei voti");
		System.out.println();
		System.out.println("Verifica A=25, B=23, C=20, D=18, & F=15");
		System.out.println();
		voti.disegna();

		System.out.println();
		System.out.println("Test case 9:");
		System.out.println("Disegna il grafo delle percentuali dei voti");
		System.out.println();
		System.out.println("Verifica A=100%");
		voti.set(1, 0, 0, 0, 0);
		System.out.println();
		voti.disegna();

		System.out.println();
		System.out.println("Test case 10:");
		System.out.println("Disegna il grafo delle percentuali dei voti");
		System.out.println();
		System.out.println("Verifica tutte a 0%");
		voti.set(0, 0, 0, 0, 0);
		System.out.println();
		voti.disegna();

	}
}
