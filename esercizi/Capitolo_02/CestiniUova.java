/**
 * Questo programma calcola il numero totale di uova
 * in un certo numero di cestini.
 */
public class CestiniUova {

	public static void main(String[] args) {
		int numeroDiCestini, uovaPerCestino, totaleUova;

		numeroDiCestini = 10;
		uovaPerCestino = 6;

		totaleUova = numeroDiCestini * uovaPerCestino;

		System.out.println("Se hai");
		System.out.println(uovaPerCestino + " uova per cestino e");
		System.out.println(numeroDiCestini + " cestini");
		System.out.println("il numero totale di uova e' " + totaleUova);
	}
}