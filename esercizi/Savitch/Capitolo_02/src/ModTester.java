import java.util.*;

public class ModTester {

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Inserire un valore floating point.");
		double y = tastiera.nextDouble();

		double x = y % 2.0;

		System.out.println( y + " mod 2.0 is  " + x);

		int q = (int) y;
		int z = q % 2;
		System.out.println( q + " mod 2 is  " + z);
	}
}
