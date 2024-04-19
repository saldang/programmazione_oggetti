import java.io.Serializable;
import java.util.Scanner;

/**
 * Classe serializzabile per descrivere le specie a rischio.
 */
public class Specie implements Serializable {
	private String nome;
	private int popolazione;
	private double tassoCrescita;
	private Persona proprietario;

	public Specie(String nomeIniziale, int popolazioneIniziale,
			double tassoCrescitaIniziale, Persona proprietarioIniziale) {
		nome = nomeIniziale;
		if (popolazioneIniziale >= 0)
			popolazione = popolazioneIniziale;
		else {
			System.out.println("ERRORE: Popolazione negativa.");
			System.exit(0);
		}
		tassoCrescita = tassoCrescitaIniziale;
		proprietario = proprietarioIniziale;
	}

	public Specie() {
		this(null, 0, 0, null);
	}

	public String toString() {
		return ("Nome = " + nome + "\n" + "Popolazione = " + popolazione +
				"\n" + "Tasso di crescita = " + tassoCrescita + "%\n" + proprietario.nome + "\n");
	}

	// <Gli altri metodi sono gli stessi del Listato 8.14 del Capitolo 8,
	// ma non serviranno per la discussione in questo capitolo.>
}
