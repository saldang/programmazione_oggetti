import java.util.Scanner;

public class OttieniInput {

	private int minimo;
	private int massimo;
	private String sollecito;

	public void initialize(int min, int max, String p) {
		minimo = min;
		massimo = max;
		sollecito = p;

		if (minimo > massimo) {
			minimo = max;
			massimo = min;
			System.out.println("Il minimo era piu' grande del massimo "
					+ "imposta quindi il minimo al valore piu' piccolo e il massimo al valore piu' grande.");
		}
	}

	public int getValore() {
		System.out.println(sollecito);
		Scanner tastiera = new Scanner(System.in);

		int valore = tastiera.nextInt();
		while (valore > massimo || valore < minimo) {
			System.out.println("Il valore deve essere nel range [" + minimo + " - " + massimo + "]");
			System.out.println();
			System.out.println(sollecito);
			valore = tastiera.nextInt();
		}

		return valore;
	}

	
	public static void main(String[] args) {

		OttieniInput istanza1 = new OttieniInput();
		OttieniInput istanza2 = new OttieniInput();
		OttieniInput istanza3 = new OttieniInput();
		istanza1.initialize(10, 0, "Inserisci un valore tra 10 e 0.");
		istanza2.initialize(0, 10, "Inserisci un valore tra 0 e 10.");
		istanza3.initialize(-150, 0, "Qual e' una temperatura di congelamento?");

		int data;

		data = istanza1.getValore();
		System.out.println("Valore ottenuto " + data + "\n");

		data = istanza2.getValore();
		System.out.println("Valore ottenuto " + data + "\n");

		data = istanza3.getValore();
		System.out.println("Valore ottenuto " + data + "\n");

	}

}
