import java.util.ArrayList;
import java.util.Scanner;

public class FrequenzaCarattere {

	public static void main(String[] args) {

		ArrayList<Integer> conteggioCifre = new ArrayList<Integer>();
        // Inizializzo il conteggio
        for(int i=0; i<10; i++){
            conteggioCifre.add(0);
        }
	
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Inserisci un numero di telefono: ");
		String numero = tastiera.next();

		for (int i = 0; i < numero.length(); i++) {
			// Ispeziona ogni cifra
			Character carattere = numero.charAt(i);
			switch (carattere) {
			case '0':
				conteggioCifre.set(0, conteggioCifre.get(0)+1);
				break;
			case '1':
				conteggioCifre.set(1, conteggioCifre.get(1)+1);
				break;
			case '2':
				conteggioCifre.set(2, conteggioCifre.get(2)+1);
				break;
			case '3':
				conteggioCifre.set(3, conteggioCifre.get(3)+1);
				break;
			case '4':
				conteggioCifre.set(4, conteggioCifre.get(4)+1);
				break;
			case '5':
				conteggioCifre.set(5, conteggioCifre.get(5)+1);
				break;
			case '6':
				conteggioCifre.set(6, conteggioCifre.get(6)+1);
				break;
			case '7':
				conteggioCifre.set(7, conteggioCifre.get(7)+1);
				break;
			case '8':
				conteggioCifre.set(8, conteggioCifre.get(8)+1);
				break;
			case '9':
				conteggioCifre.set(9, conteggioCifre.get(9)+1);
				break;
			}
		}

		System.out.println("Il conteggio per ogni cifra e': ");

		for (int i = 0; i < 10; i++) {
			System.out.println("Conteggio di " + i + " e' " + conteggioCifre.get(i));
		}
	}
}
