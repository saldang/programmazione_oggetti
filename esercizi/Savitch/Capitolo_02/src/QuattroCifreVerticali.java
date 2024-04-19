import java.util.*;

public class QuattroCifreVerticali {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Inserusci un numero intero a 4 cifre, ad esempio 1974: ");
		String quattroCifre = tastiera.nextLine();

		System.out.println(quattroCifre.charAt(0));
		System.out.println(quattroCifre.charAt(1));
		System.out.println(quattroCifre.charAt(2));
		System.out.println(quattroCifre.charAt(3));
	}
}
