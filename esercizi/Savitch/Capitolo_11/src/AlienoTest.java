
public class AlienoTest {
	// ======================
	// main method.
	// Si crea un gruppo di alieni e si calcola il suo danno totale(17).
	// ======================
	public static void main(String[] args) {
		AlienoOrco brutus = new AlienoOrco(100, "brutus");
		AlienoSerpente slimy = new AlienoSerpente(100, "slimy");
		AlienoMarshmallow puffy = new AlienoMarshmallow(100, "puffy");

		GruppoAlieni pack = new GruppoAlieni(3); // 3 alieni
		pack.aggiungiAlieno(brutus, 0);
		pack.aggiungiAlieno(slimy, 1);
		pack.aggiungiAlieno(puffy, 2);

		System.out.println("Danno comlessivo inflitto dal gruppo di alieni = " + pack.calcolaDanni());
	}
}
