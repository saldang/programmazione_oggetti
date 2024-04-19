import java.util.*;

public class ConvertitoreDiTipo {

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Inserire un valore floating point.");
		double y = tastiera.nextDouble();

		int x = (int) y;

		System.out.println("Il valore floating value " + y + " convertito in un valore int " + x);

		byte z = (byte) y;
		System.out.println("Il valore  value " + y + " convertito in un valore byte " + z);

	}
}