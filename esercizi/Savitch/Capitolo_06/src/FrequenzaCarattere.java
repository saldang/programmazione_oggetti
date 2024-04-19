import java.util.Scanner;

public class FrequenzaCarattere {

	public static void main(String[] args) {

		int[] conteggioCifre = new int[10];

		Scanner tastiera = new Scanner(System.in);

		System.out.println("Inserisci un numero di telefono: ");
		String numero = tastiera.next();

		for (int i = 0; i < numero.length(); i++) {
			// Ispeziona ogni cifra
			Character carattere = numero.charAt(i);
			switch (carattere) {
			case '0':
				conteggioCifre[0]++;
				break;
			case '1':
				conteggioCifre[1]++;
				break;
			case '2':
				conteggioCifre[2]++;
				break;
			case '3':
				conteggioCifre[3]++;
				break;
			case '4':
				conteggioCifre[4]++;
				break;
			case '5':
				conteggioCifre[5]++;
				break;
			case '6':
				conteggioCifre[6]++;
				break;
			case '7':
				conteggioCifre[7]++;
				break;
			case '8':
				conteggioCifre[8]++;
				break;
			case '9':
				conteggioCifre[9]++;
				break;

			}

		}

		System.out.println("Il conteggio per ogni cifra e': ");

		for (int i = 0; i < 10; i++) {
			System.out.println("Conteggio di " + i + " e' " + conteggioCifre[i]);
		}

	}

}
