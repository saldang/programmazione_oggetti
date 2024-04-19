import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class EsempioScritturaSpecieFileTesto {
	public static void main(String a[]){
		Specie unEsemplare = new Specie("Condor della California", 27, 0.02, new Persona("John Smith"));
		System.out.println(unEsemplare.toString());
		System.out.println(unEsemplare);

		String nomeFile = "specie.txt"; 

		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(nomeFile);
		} catch (FileNotFoundException e) {
			System.out.println("Errore nell'apertura del file " + nomeFile);
			System.exit(0);
		}

		outputStream.println(unEsemplare);
		outputStream.println(unEsemplare.toString());
		
		outputStream.close();		
	}
}
