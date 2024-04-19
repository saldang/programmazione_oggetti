
public class AcquistoDemo {

	public static void main(String[] args) {
		Acquisto unAcquisto = new Acquisto();
		unAcquisto.leggiInput();
		unAcquisto.writeOutput();
		System.out.println("Costo unitario: " + unAcquisto.getCostoUnitario()+ " Euro.");
		System.out.println("Costo totale: " + unAcquisto.getCostoTotale() + " Euro.");
	}
}
