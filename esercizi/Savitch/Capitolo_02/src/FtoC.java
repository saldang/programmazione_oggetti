
import java.util.*;

public class FtoC {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Inserisci una temperatura (numero intero) in gradi Fahrenheit.");
		int gradiF = tastiera.nextInt();

		double gradiC = 5 * (double) (gradiF - 32) / 9;

		System.out.println(gradiF + " gradi Fahrenheit = " + gradiC + " gradi Celsius.");
	}
}
