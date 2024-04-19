import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Haberman {
    public static void main(String[] args) {
		int numeroPazientiSopravvissuti = 0;  // Numero di pazienti sopravvissuti dopo i 5 anni
		int numeroPazientiDeceduti = 0;	  // Numero di pazienti deceduti entro i 5 anni
		int numeroNoduli = 0;	
		int numeroNoduliPazientiDeceduti = 0;

        String fileName = "haberman.data";
        try {
            Scanner inputStream = new Scanner(new File(fileName));
            // Leggi il file linea per linea
            while (inputStream.hasNextLine()) {
				// Contine eta', anno dell'operazione, numero noduli e stato
				String linea = inputStream.nextLine();
				// Converte la stringa in un array di stringhe
				String[] array = linea.split(",");
				// Estrae il numero di apzienti sopravvissuti e il numero di noduli
				int noduli = Integer.parseInt(array[2]);
				int stato = Integer.parseInt(array[3]);
				
				if (stato == 1) {
					numeroNoduli += noduli;
					numeroPazientiSopravvissuti++;
				} else {
					numeroNoduliPazientiDeceduti += noduli;
					numeroPazientiDeceduti++;
				}
			}
            inputStream.close( );
			// Calcola le medie
			double mediaSopravvissuti = (double) numeroNoduli / numeroPazientiSopravvissuti;
			double mediaDeceduti = (double) numeroNoduliPazientiDeceduti / numeroPazientiDeceduti;
			System.out.printf("Il numero medio di noduli positivi per i pazienti che vivono 5 anni o più e' %1.2f\n",mediaSopravvissuti);
			System.out.printf("Il numero medio di noduli positivi per i pazienti che decedono entro i 5 anni e' %1.2f\n",mediaDeceduti);
        } catch(FileNotFoundException e) {
            System.out.println("Non riesco a trovare il file " + fileName);
        } catch(IOException e) {
            System.out.println("Problemi relativi al contenuto del file " + fileName);
        }
    }
}
