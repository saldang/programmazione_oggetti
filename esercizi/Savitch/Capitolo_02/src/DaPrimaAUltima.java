import java.util.*;

public class DaPrimaAUltima {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Scrivi una riga di testo senza punteggiatura.");
		String rigaTesto = tastiera.nextLine();
		int endOfFirstWord = rigaTesto.indexOf(" ");

		System.out.println("La riga e' stata modificata in: ");
		System.out.println(rigaTesto.substring(endOfFirstWord + 1) + " " + rigaTesto.substring(0, endOfFirstWord));
	}
}
