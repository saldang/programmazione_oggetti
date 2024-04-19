import java.util.*;

public class CartaBrano {

	private int brani;
	private boolean attivata;

	public CartaBrano(int n) {
		brani = n;
		attivata = false;
	}

	public void activate() {
		attivata = true;
	}

	public void compraBrano() throws CartaNonAttivataException, CartaEsauritaException {
		if (!attivata)
			throw new CartaNonAttivataException("Carta non attivata");
		if (brani <= 0)
			throw new CartaEsauritaException("Carta esaurita");

		brani--;
	}

	public int braniRimanenti() {
		return brani;
	}

	public String toString() {
		String result = "La carta ha  " + brani + " brani ed e' ";
		if (attivata)
			result = result + "attivata";
		else
			result = result + "non attivata";
		return result;
	}

	public static void main(String[] args) {
		CartaBrano sc = new CartaBrano(10);
		System.out.println(sc);

		System.out.println("\nCompro un brano");
		try {
			sc.compraBrano();
		} catch (CartaEsauritaException e) {
			System.out.println("Catturo l'eccezione: " + e.getMessage());
		} catch (CartaNonAttivataException e) {
			System.out.println("Catturo l'eccezione: " + e.getMessage());
		}
		System.out.println(sc);

		System.out.println("Attivo la carta");
		sc.activate();
		System.out.println(sc);

		System.out.println("\nCompro brani");
		try {
			for (int i = 0; i < 20; i++) {
				sc.compraBrano();
				System.out.println("Acquistato un brano: " + sc);
			}
		} catch (CartaEsauritaException e) {
			System.out.println("Catturo l'eccezione: " + e.getMessage());
		} catch (CartaNonAttivataException e) {
			System.out.println("Catturo l'eccezione: " + e.getMessage());
		}
		System.out.println(sc);
	}
}
