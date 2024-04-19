import java.util.Random;

public class DadoTruccato extends Random {
	public DadoTruccato() {
		super();
	}

	// Si effettua l'override del metodo nextInt della classe Random
	public int nextInt(int numero) {
		// Numero random tra 0-1 invocando il metodo della classe padre
		int r = super.nextInt(2);
		// Con la probabilita' di ottenere il piu' garnde numero possibile
		// In caso contrario restituisce un numero da 0 to numero-1 con pari
		// probabilita'
		if (r == 0)
			return numero - 1;
		else
			return super.nextInt(numero);
	}

	public static void stampaLanciDado(Random randGenerator) {
		for (int i = 0; i < 100; i++) {
			System.out.println(randGenerator.nextInt(6) + 1);
		}
	}

	public static void main(String[] args) {
		// Questa versione stampera' tanti da 1 a 6
		Random randGenerator = new Random();
		stampaLanciDado(randGenerator);

		// Questa versione stampera' tanti 6
		DadoTruccato loadedRandom = new DadoTruccato();
		stampaLanciDado(loadedRandom);
	}
}