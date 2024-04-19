import java.util.Scanner;

public class Compleanno {

	public static void main(String[] args) {
		System.out.println("Ciao!");

		int anno, eta;

		Scanner tastiera = new Scanner(System.in);
		System.out.println("In quale anno sei nato?");
		anno = tastiera.nextInt();
		System.out.println("Scegli un'eta' in anni.");
		eta = tastiera.nextInt();

		System.out.println("Raggiungerai l'eta di " + eta + " anni nell'anno ");
		System.out.println(anno + eta);
	}
}
