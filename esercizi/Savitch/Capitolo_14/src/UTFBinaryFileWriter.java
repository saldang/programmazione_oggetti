import java.util.*;
import java.io.*;

public class UTFBinaryFileWriter {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Qual e' il nome del file da creare?");
		String fileName = input.nextLine().trim();

		int conteggioInt = 0;
		int conteggioDouble = 0;

		try {
			PrintWriter outFile = new PrintWriter(fileName);
			System.out.println("Inserisci i valori uno alla volta");
			System.out.println(
					"I valori possono essere interi o double. Qualisiasi altro valore indica il termine dell'immissione");

			// Usa il file per memorizzare temporaneamente i dati mentre li contiamo.
			// Potremmo farlo con Vector o ArrayLists poiche' si ridimensionano
			// automaticamente.
			// ma useremo gli array creati dopo aver letto tutti i dati
			boolean ancoraDati = true;
			while (ancoraDati) {
				if (input.hasNextInt()) {
					int valore = input.nextInt();
					outFile.println("i " + valore);
					conteggioInt++;

				} else if (input.hasNextDouble()) {
					double valore = input.nextDouble();
					outFile.println("d " + valore);
					conteggioDouble++;
				} else
					ancoraDati = false;
			}

			outFile.close();

			String indicatori[] = new String[conteggioInt + conteggioDouble];
			int valoriInt[] = new int[conteggioInt];
			double valoriDouble[] = new double[conteggioDouble];

			// Legge i valori dal file
			Scanner readFile = new Scanner(new File(fileName));

			int conteggio = 0;
			conteggioInt = 0;
			conteggioDouble = 0;
			while (readFile.hasNextLine()) {
				Scanner lineScanner = new Scanner(readFile.nextLine());
				String indicatore = lineScanner.next();
				indicatori[conteggio] = indicatore;
				conteggio++;
				if (indicatore.equals("i")) {
					valoriInt[conteggioInt] = lineScanner.nextInt();
					conteggioInt++;
				}
				if (indicatore.equals("d")) {
					valoriDouble[conteggioDouble] = lineScanner.nextDouble();
					conteggioDouble++;
				}
			}
			readFile.close();

			// Compone la stringa di indicatori
			String indicatoriString = "";
			for (int i = 0; i < indicatori.length; i++) {
				indicatoriString = indicatoriString + indicatori[i];
			}

			// Apre il file per scrivere
			ObjectOutputStream binaryFile = new ObjectOutputStream(new FileOutputStream(fileName));
			binaryFile.writeUTF(indicatoriString);

			conteggioInt = 0;
			conteggioDouble = 0;
			for (int i = 0; i < indicatori.length; i++) {
				if (indicatori[i].equals("i")) {
					binaryFile.writeInt(valoriInt[conteggioInt]);
					conteggioInt++;
				} else {
					binaryFile.writeDouble(valoriDouble[conteggioDouble]);
					conteggioDouble++;
				}
			}

			binaryFile.close();

			System.out.println("File creato.");
		} catch (Exception e) {
			System.out.println("Abbiamo un problema:" + e.getMessage());

		}

	}

}
