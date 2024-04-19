public class StrattaDiMano {
	public static int strettaDiMano(int n) {
		// Il acso base: o o 1 stretta di mano per 2 o meno persone
		if (n <= 1)
			return 0;
		else if (n == 2)
			return 1;

		// Caso ricorsivo: l'ennesima persona stringe la mano a n-1 persone.
		// Poi calcola quante strette di mano per le persone rimanenti (n-1)
		return (n - 1) + strettaDiMano(n - 1);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 101; i++) {
			System.out.println("Se ci sono " + i + " persone " + "nella stanza, allora abbiamo un totale di "
					+ strettaDiMano(i) + " strette di mano.");
		}
	}
}