import java.util.Scanner;

/**
Programma per la produzione del report delle vendite.
*/
public class ReportVendite {
    private double venditaPiuAlta;
    private double mediaVendite;
    private Venditore[] team;      //L’oggetto array e’ creato in recuperaDati.
    private int numeroDiVenditori; //Equivalente a team.length
   
    /**
    Lettura del numero di venditori e dei relativi dati.
    */
    public void recuperaDati() {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Inserire il numero di venditori:");
        numeroDiVenditori = tastiera.nextInt();
        team = new Venditore[numeroDiVenditori + 1];

        for (int i = 1; i <= numeroDiVenditori; i++) {
            team[i] = new Venditore();
            System.out.println("Inserire i dati per il venditore " + i);
            team[i].leggiValoriDaTastiera();
            System.out.println();
        }
    }

    /**
    Calcolo della vendita piu’ alta e della vendita media.
    Precondizione: deve esistere almeno un venditore associato.
    */
    public void calcolaStatistiche() {
        double venditaSuccessiva = team[1].getVendite();
        venditaPiuAlta = venditaSuccessiva;
        double somma = venditaSuccessiva;

        for (int i = 2; i <= numeroDiVenditori; i++) {
            venditaSuccessiva = team[i].getVendite();
            somma = somma + venditaSuccessiva;
            if (venditaSuccessiva > venditaPiuAlta)
                venditaPiuAlta = venditaSuccessiva; //vendita piu’ alta fino ad ora
        }
        mediaVendite = somma / numeroDiVenditori;
    }

    /**
    Visualizza il report su schermo.
    */
    public void visualizzaRisultati() {
        System.out.println("La vendita media per venditore e’ € " + mediaVendite);
        System.out.println("La vendita piu’ alta e’ pari a € " + venditaPiuAlta);
        System.out.println();
        System.out.println("Il seguente venditore ha le vendite maggiori:");

        for (int i = 1; i <= numeroDiVenditori; i++) {
            double venditaSuccessiva = team[i].getVendite();

            if (venditaSuccessiva == venditaPiuAlta) {
                team[i].scriviOutput();
                System.out.println("€" + (venditaSuccessiva - mediaVendite) + " sopra la media.");
                System.out.println();
            }
        }

        System.out.println("Le performance dei restanti sono le seguenti:");

        for (int i = 1; i <= numeroDiVenditori; i++) {
            double venditaSuccessiva = team[i].getVendite();

            if (team[i].getVendite() != venditaPiuAlta) {
                team[i].scriviOutput();

                if (venditaSuccessiva >= mediaVendite)
                    System.out.println("€ " + (venditaSuccessiva - mediaVendite) + " sopra la media.");
                else
                    System.out.println("€ " + (mediaVendite - venditaSuccessiva) + " sotto la media.");
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
    	// 1) Preparazione
    	ReportVendite report = new ReportVendite();
    	// 2) Recupero dei dati
    	report.recuperaDati();
    	// 3) Calcolo di alcune statistiche 
    	report.calcolaStatistiche();
    	// 4) Visualizzazione dei risultati
        report.visualizzaRisultati();    
    }
}
