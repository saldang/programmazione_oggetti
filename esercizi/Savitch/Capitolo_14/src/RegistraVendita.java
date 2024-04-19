import java.io.*;
import java.util.*;

public class RegistraVendita {

	public static void main(String[] args) {

		Scanner tastiera = new Scanner(System.in);

		String nomeFile = "RegistroVendite.txt";

		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileOutputStream(nomeFile, true));
		} catch (FileNotFoundException e) {
			System.out.println("Errore nell'aprire il file " + nomeFile);
			System.exit(0);
		}

		outputStream.println("Inizio nuova vendita.");

		boolean fatto = false;
		double totale = 0.0;

		while (!fatto) {
			System.out.println(
					"Qual e' il nome dell'articolo, la quantita' ed il costo? \n(Separare con uno spazio e il nome deve essere una unica parola) ");
			try {
				String nome = tastiera.next();
				int qta = tastiera.nextInt();
				double costo = tastiera.nextDouble();
				double subTotale = qta * costo;
				totale += subTotale;

				System.out.println("Il sub-totale per " + nome + " e' " + subTotale);
				System.out.println("Il totale e' " + totale);
				outputStream.println(qta + " " + nome + " @ " + costo + " e' " + subTotale);

				System.out.println("Vendita terminata? (s/n) ");
				String risposta = tastiera.next().trim().toLowerCase();
				if (risposta.equals("s"))
					fatto = true;

			} catch (Exception ex) {
				System.out.println("C'e' stato un problema con il formato di input, riprovare.");
				tastiera.nextLine();
			}

		}

		System.out.println("Vendita completata, il totale e' " + totale);
		outputStream.println("Vendita completata, il totale e'" + totale);
		outputStream.close();

		System.out.println("Il file " + nomeFile +" e' stato scritto.");
	}

}
