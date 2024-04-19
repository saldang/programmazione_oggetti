
public class FilmTest {
	public static void main(String[] args) {
		Azione killbill2 = new Azione(0, "Kill Bill: Volume 2");
		Commedia meangirls = new Commedia(1, "Mean Girls");
		Dramma mystic = new Dramma(2, "Mystic River");
		Dramma mysticCopy2 = new Dramma(2, "Mystic River, Second Copy");

		System.out.println(
				"Se " + killbill2.getTitolo() + " e' in ritardo di 2 giorni la penale e' " + killbill2.calcolaPenaleRitardo(2));
		System.out.println(
				"Se " + killbill2.getTitolo() + " e' in ritardo di 3 giorni la penale e' " + killbill2.calcolaPenaleRitardo(3));
		System.out.println(
				"Se " + meangirls.getTitolo() + " e' in ritardo di 3 giorni la penale e' " + meangirls.calcolaPenaleRitardo(3));
		System.out.println(
				"Se " + mystic.getTitolo() + "  e' in ritardo di 3 giorni la penale e' " + mystic.calcolaPenaleRitardo(3));

		// Test our equals method
		System.out.println(
				killbill2.getTitolo() + " e' uguale a " + mystic.getTitolo() + "? " + killbill2.equals(mystic));
		System.out.println(
				meangirls.getTitolo() + " e' uguale a " + mystic.getTitolo() + "? " + meangirls.equals(mystic));
		System.out.println(
				mystic.getTitolo() + " e' uguale a " + mysticCopy2.getTitolo() + "? " + mystic.equals(mysticCopy2));
	}
}
