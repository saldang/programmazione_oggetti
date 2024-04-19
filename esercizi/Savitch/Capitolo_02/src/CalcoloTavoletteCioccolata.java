import java.util.Scanner;

public class CalcoloTavoletteCioccolata {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		int eta;
		int peso;
		int altezza;

		System.out.println("Questo programma calcola il numro di barrette di cioccalata da 230 Kcal ");
		System.out.println("cche si possono mangaier per mantenere il proprio peso.");
		System.out.println("Qual e' la tua eta' in anni?");
		eta = tastiera.nextInt();
		System.out.println("Qual e' la tua altezza in cm?"); 
		altezza = tastiera.nextInt();
		System.out.println("qual e' il tuo peso in kg?");
		peso = tastiera.nextInt();

		double calorieUomo, calorieDonna;

		calorieUomo = 66 + (13.8 * peso) + (5.0 * altezza) - (6.8 * eta);
		calorieDonna = 655 + (9.6 * peso) + (1.8 * altezza) - (4.7 * eta);

		System.out.println("Una donna con i valori inseriti dovrebbe mangiare " + (calorieDonna / 230)
				+ " barrette di cioccalata da 230 Kcal al giorno per mantenere il suo peso.");
		System.out.println("Un uomo con i valori inseriti dovrebbe mangiare " + (calorieUomo / 230)
				+ " barrette di cioccalata da 230 Kcal al giorno per mantenere il suo peso.");
	}
}