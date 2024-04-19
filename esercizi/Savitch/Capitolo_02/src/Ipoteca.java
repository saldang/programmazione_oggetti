
import java.util.*;

public class Ipoteca {
	public static final double TASSO_ANNUO = 0.0749; // tasso di interesse annuo

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Inserisci l'importo pagato questo mese (in euro):");
		int pagamento = tastiera.nextInt();

		System.out.println("Inserisci il debito rimanente (in euro):");
				//Enter the principal owed (in whole dollars):");
		int debitoRimanente = tastiera.nextInt();

		int interessi = (int) (debitoRimanente * TASSO_ANNUO / 12);

		int quotaDebito = pagamento - interessi;

		int nuovoDebitoRimanente = debitoRimanente - quotaDebito;

		System.out.println("Saldo precedente: " + debitoRimanente);
		System.out.println("Pagamento: " + pagamento);
		System.out.println("Interessi: " + interessi);
		System.out.println("Importo debito: " + quotaDebito);
		System.out.println("Nuovo saldo: " + nuovoDebitoRimanente);
	}
}
