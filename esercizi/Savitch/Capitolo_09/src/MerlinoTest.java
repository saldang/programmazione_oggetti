import java.util.Scanner;

public class MerlinoTest {

	public static void main(String[] args) {
		Merlino mago1 = Merlino.chiama();
		Merlino mago2 = Merlino.chiama();

		System.out.println("Il mago dice: " + mago1.consulta());

		System.out.println("Il primo mago e' " + mago1.toString());
		System.out.println("Il secondo amgo e' " + mago2.toString());

		// L'istruzione commentata sotto da un errore in compilazione
		// Merlino mago = new Merlino();
	}
}
