
/**
 File name: TimeFormatExceptionDemo.java

 Questa classe converte un orario espresso in 24 ore in orario espresso in 12 ore e genera
 un'eccezione di tipo FormatoOrarioException se il formato non è corretto.  
 Il formato corretto è hh:mm, dove hh deve essere un numero di due cifre inferiore a
 24 (gli zeri iniziali sono richiesti per ore inferiori a 10)
 e mm è un numero a due cifre inferiore a 60.  Il terzo
 deve essere un due punti.
 */
import java.util.*;

public class FormatoOrarioExceptionDemo {
	private String mattinaOSera; // am o pm
	private String restoDellaLinea;
	private char char1, char2, char3, char4, char5;
	private int ore;
	private int minuti;

	public void converti() {
		mattinaOSera = "AM"; // default setting

		try {
			Scanner tastiera = new Scanner(System.in);
			String orarioStringa;

			System.out.println("Inserire un orario nella notazione 24 ore:");
			orarioStringa = tastiera.next();

			// Inserisce spazi se necessario per evitare
			// StringIndexOutOfRangeExceptions
			if (orarioStringa.length() < 5) {
				orarioStringa += "     ";
			}

			char1 = orarioStringa.charAt(0);
			char2 = orarioStringa.charAt(1);
			char3 = orarioStringa.charAt(2);
			char4 = orarioStringa.charAt(3);
			char5 = orarioStringa.charAt(4);
			// ottiene il rimanente della stringa
			restoDellaLinea = tastiera.nextLine();

			switch (char1) {
			case '0':
				ore = 0;
				break;
			case '1':
				ore = 10;
				break;
			case '2':
				ore = 20;
				break;
			default:
				throw new FormatoOrarioException();
			}

			switch (char2) {
			case '0':
				break;
			case '1':
				ore = ore + 1;
				break;
			case '2':
				ore = ore + 2;
				break;
			case '3':
				ore = ore + 3;
				break;
			case '4':
				ore = ore + 4;
				break;
			case '5':
				ore = ore + 5;
				break;
			case '6':
				ore = ore + 6;
				break;
			case '7':
				ore = ore + 7;
				break;
			case '8':
				ore = ore + 8;
				break;
			case '9':
				ore = ore + 9;
				break;
			default:
				throw new FormatoOrarioException();
			}

			if (ore > 23)
				throw new FormatoOrarioException();
			if (ore > 11)
				mattinaOSera = "PM";
			if (ore > 12)
				ore = ore - 12;
			if (char3 != ':')
				throw new FormatoOrarioException();

			switch (char4) {
			case '0':
				minuti = 0;
				break;
			case '1':
				minuti = 10;
				break;
			case '2':
				minuti = 20;
				break;
			case '3':
				minuti = 30;
				break;
			case '4':
				minuti = 40;
				break;
			case '5':
				minuti = 50;
				break;
			default:
				throw new FormatoOrarioException();
			}

			switch (char5) {
			case '0':
				break;
			case '1':
				minuti = minuti + 1;
				break;
			case '2':
				minuti = minuti + 2;
				break;
			case '3':
				minuti = minuti + 3;
				break;
			case '4':
				minuti = minuti + 4;
				break;
			case '5':
				minuti = minuti + 5;
				break;
			case '6':
				minuti = minuti + 6;
				break;
			case '7':
				minuti = minuti + 7;
				break;
			case '8':
				minuti = minuti + 8;
				break;
			case '9':
				minuti = minuti + 9;
				break;
			default:
				throw new FormatoOrarioException();
			}

			System.out.println("L’equivalente in notazione 12 ore e’:");
			System.out.print(ore + ":");
			if (minuti < 10)
				System.out.print("0");
			if (ore == 12 && minuti == 0)
				mattinaOSera = "noon";
			System.out.println(minuti + " " + mattinaOSera);
		}

		catch (FormatoOrarioException e) {
			System.out.print(e.getMessage());
			System.out.print(char1);
			System.out.print(char2);
			System.out.print(char3);
			System.out.print(char4);
			System.out.print(char5);
			System.out.println(restoDellaLinea);
			System.exit(0);
		}
	}
	
	
	public static void main(String[] args) {
		FormatoOrarioExceptionDemo formatoOrario = new FormatoOrarioExceptionDemo();
		Scanner tastiera = new Scanner(System.in);

		char ripete;
		// Ripete se l'utente risponde di si
		do {
			formatoOrario.converti();
			System.out.println();
			System.out.println("Di nuovo? (s/n)");
			ripete = tastiera.next().charAt(0);

		} while ((ripete == 's') || (ripete == 'S'));
	}
}
