
import java.util.*;

public class FraseSciocca {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Inserisci il nome di qualcuno che conosci:");
		String nome = tastiera.nextLine();

		System.out.println("Inserisci il tuo colore preferito: ");
		String colore = tastiera.nextLine();

		System.out.println("Inserisci il tuo piatto preferito: ");
		String cibo = tastiera.nextLine();

		System.out.println("Inserisci il tuo animale preferito: ");
		String animale = tastiera.nextLine();

		System.out.println("Ho sognato che " + nome + " aveva mangiato un " + animale + " " + colore);
		System.out.println("e aveva detto che sapeva di " + cibo + "!");
	}
}
