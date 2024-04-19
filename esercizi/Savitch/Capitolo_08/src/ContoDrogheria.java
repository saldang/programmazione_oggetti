
public class ContoDrogheria {
	public static void main(String[] args) {
		double costoTotale = 0;
		Acquisto item = new Acquisto();

		item.setNome("Arance");
		item.setPrezzo(10, 2.99);
		item.setArticoliAcquistati(24);
		item.writeOutput();
		System.out.println("Subtotale: € " + item.getCostoTotale());
		costoTotale = costoTotale + item.getCostoTotale();

		item.setNome("Uova");
		item.setPrezzo(12, 1.69);
		item.setArticoliAcquistati(36);
		item.writeOutput();
		System.out.println("Subtotale: € " + item.getCostoTotale());
		costoTotale = costoTotale + item.getCostoTotale();

		item.setNome("Mele");
		item.setPrezzo(3, 1.00);
		item.setArticoliAcquistati(20);
		item.writeOutput();
		System.out.println("Subtotale: € " + item.getCostoTotale());
		costoTotale = costoTotale + item.getCostoTotale();

		item.setNome("Angurie");
		item.setPrezzo(1, 4.39);
		item.setArticoliAcquistati(2);
		item.writeOutput();
		System.out.println("Subtotale: € " + item.getCostoTotale());
		costoTotale = costoTotale + item.getCostoTotale();

		item.setNome("Bagels");
		item.setPrezzo(6, 3.50);
		item.setArticoliAcquistati(12);
		item.writeOutput();
		System.out.println("Subtotale: € " + item.getCostoTotale());
		costoTotale = costoTotale + item.getCostoTotale();

		System.out.println();
		System.out.println("Totale: € " + costoTotale);
	}
}