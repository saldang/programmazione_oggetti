
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;

public class CronometroGiri {
	private boolean inEsecuzione;
	private int numeroGiri;
	private int giriCompletati;
	private long tempoDiPartenza;
	private long tempoDiPartenzaGiroCorrente;
	private long durataUltimoGiro;
	private long tempoTotale;

	private PrintWriter outputStream;
	
	public CronometroGiri(int n) {
		inEsecuzione = false;
		numeroGiri = n;
		giriCompletati = 0;
		tempoDiPartenza = 0;
		tempoDiPartenzaGiroCorrente = 0;
		durataUltimoGiro = 0;
		tempoTotale = 0;
		
		 outputStream = null;
	}

	
	public CronometroGiri(int n, String persona, String nomeFile) throws FileNotFoundException {
		inEsecuzione = false;
		numeroGiri = n;
		giriCompletati = 0;
		tempoDiPartenza = 0;
		tempoDiPartenzaGiroCorrente = 0;
		durataUltimoGiro = 0;
		tempoTotale = 0;
		        
		        outputStream = null;
		        try {
		            outputStream = new PrintWriter(nomeFile);
		        } catch(FileNotFoundException e) {
		            throw e; // Rilanciamo l'eccezione
		        }
		        
		        outputStream.println("Registra informazioni giri per" + persona);
		        
		    }
	
	
	public void parti() throws CronometroException {
		if (inEsecuzione == true || giriCompletati > 0)
			throw new CronometroException("Il timer e' gia' partito");
		inEsecuzione = true;
		tempoDiPartenza = Calendar.getInstance().getTimeInMillis();
		tempoDiPartenzaGiroCorrente = tempoDiPartenza;
	}

	public void marcaGiro() throws CronometroException {
		if (!inEsecuzione)
			if (giriCompletati == 0)
				throw new CronometroException("Il timer non e' partito");
			else
				throw new CronometroException("Tutti i giri sono stati completati");

		giriCompletati++;
		long currentTime = Calendar.getInstance().getTimeInMillis();
		durataUltimoGiro = currentTime - tempoDiPartenzaGiroCorrente;
		tempoTotale = currentTime - tempoDiPartenza;
		tempoDiPartenzaGiroCorrente = currentTime;

		if (giriCompletati == numeroGiri)
			inEsecuzione = false;
		
		
		 if(outputStream != null){
	            outputStream.println("Giro completato " + giriCompletati + " in " + durataUltimoGiro + " millisecondi");
	            outputStream.println("\t\t il tempo totale e's " + tempoTotale + " millisecondi");
	            if(!inEsecuzione){
	                outputStream.println("Terminati tutti i giri.");
	                outputStream.close();
	                outputStream = null;
	            }
	            
	        }
		
	}

	public long getDurataUltimoGiro() throws CronometroException {
		if (giriCompletati == 0)
			throw new CronometroException("Nessun giro e' stato completato");

		return durataUltimoGiro;
	}

	public long getTempoTotale() throws CronometroException {
		if (giriCompletati == 0)
			throw new CronometroException("Nessun giro e' stato completato");

		return tempoTotale;
	}

	public int getGiriRimanenti() {
		return numeroGiri - giriCompletati;
	}

	
	
	
	// This is a small main program to test out the changes we made in LapTimer
    public static void main(String[] args){
    	CronometroGiri basic = new CronometroGiri(4);
        System.out.println("Creo un cronometro base per 4 giri. \nImmetti qualsiasi carattere seguito da return per marcare la fine di un giro");
        
        Scanner tastiera = new Scanner(System.in);
        try {
            basic.parti();
            for(int i=1; i<=4; i++){
                System.out.println("Marca la fine del giro " + i);
                tastiera.next();
                basic.marcaGiro();
                System.out.println("Il tempo del giro e' " + basic.getDurataUltimoGiro());
            }
        } catch (CronometroException e){
            System.out.println("Oops, si e' verificato un errore: " + e.getMessage());
        }
        CronometroGiri cindy = null;
        try {
            cindy = new CronometroGiri(6, "Cindy", "cindyData.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("Mi spiace non posso memorizzare i tempi sul file: " + ex.getMessage());
        }
        System.out.println("Ho creato un cronometro per 6 giri. ");
        System.out.println("Immetti qualsiasi carattere seguito da return per marcare la fine di un giro" );
        System.out.println("Registro i tempi sul file cindyData.txt");
        
        try {
            cindy.parti();
            for(int i=1; i<=6; i++){
                System.out.println("Marca la fine del giro " + i);
                tastiera.next();
                cindy.marcaGiro();
                System.out.println("Il tempo del giro e'  " + cindy.getDurataUltimoGiro());
            }
        } catch (CronometroException e){
            System.out.println("Oops, si e' verificato un errore: " + e.getMessage());
        }
    }
}
