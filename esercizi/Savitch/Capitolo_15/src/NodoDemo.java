import java.util.Scanner;

public class NodoDemo {
	public static void main(String[] args) {
		Nodo A = new Nodo('A');
		Nodo B = new Nodo('B');
		Nodo C = new Nodo('C');
		Nodo D = new Nodo('D');
		Nodo E = new Nodo('E');
		Nodo F = new Nodo('F');
		Nodo G = new Nodo('G');
		Nodo H = new Nodo('H');
		Nodo I = new Nodo('I');
		Nodo J = new Nodo('J');
		Nodo K = new Nodo('K');
		Nodo L = new Nodo('L');

		A.setConnessioni(null, E, B, null);
		B.setConnessioni(null, F, null, A);
		C.setConnessioni(null, G, D, null);
		D.setConnessioni(null, null, null, C);
		E.setConnessioni(A, I, null, null);
		F.setConnessioni(B, null, G, null);
		G.setConnessioni(C, K, H, F);
		H.setConnessioni(null, L, null, G);
		I.setConnessioni(E, null, J, null);
		J.setConnessioni(null, null, null, I);
		K.setConnessioni(G, null, null, null);
		L.setConnessioni(H, null, null, null);

		Nodo corrente = A;

		while (corrente != L) {
			System.out.println("Ti trovi nella stanza " + corrente.getID()
					+ " di un labirinto di passaggi tortuosi, tutti uguali.");
			System.out.println("Puoi andare: ");
			if (corrente.getNord() != null)
				System.out.println("  Nord");
			if (corrente.getSud() != null)
				System.out.println("  Sud");
			if (corrente.getEst() != null)
				System.out.println("  Est");
			if (corrente.getOvest() != null)
				System.out.println("  Ovest");

			Scanner tastiera = new Scanner(System.in);
			String s;
			s = tastiera.next();
			if ((s.charAt(0) == 'N') && (corrente.getNord() != null))
				corrente = corrente.getNord();
			else if ((s.charAt(0) == 'S') && (corrente.getSud() != null))
				corrente = corrente.getSud();
			else if ((s.charAt(0) == 'E') && (corrente.getEst() != null))
				corrente = corrente.getEst();
			else if ((s.charAt(0) == 'W') && (corrente.getOvest() != null))
				corrente = corrente.getOvest();
		}
		System.out.println("Hai raggiunto l'uscita del labirinto!");
	}
}
