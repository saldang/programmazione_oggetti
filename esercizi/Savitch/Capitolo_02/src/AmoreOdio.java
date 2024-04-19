import java.util.*;

public class AmoreOdio {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Scrivi una riga di testo con la parola \"odio.\"");
		String rigaTesto = tastiera.nextLine();
		int hateIndex = rigaTesto.indexOf("odio");

		System.out.println("La riga e' stata modificata in: ");
		System.out.println(rigaTesto.substring(0, hateIndex) + "amo" + rigaTesto.substring(hateIndex + 4));
	}
}
