
public class CalcolatriceDriver {

	public static void main(String[] args) {
		double risultato = Calcolatrice.somma(2, 3);
		System.out.println("Somma: " + risultato);
		
		risultato = Calcolatrice.moltiplica(2, 3);
		System.out.println("Moltiplica: " + risultato);
		
		risultato = Calcolatrice.dividi(5, 2);
		System.out.println("Dividi: " + risultato);
		
		risultato = Calcolatrice.dividi(5, 0);
		System.out.println("Dividi: " + risultato);
		
		risultato = Calcolatrice.dividi(5, 2);
		System.out.println("Sottrai: " + risultato);
	}
}
