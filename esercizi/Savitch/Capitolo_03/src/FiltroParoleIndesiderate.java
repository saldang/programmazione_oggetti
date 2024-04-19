import java.util.Scanner;
public class FiltroParoleIndesiderate {

    public static void main(String[] args) {
        System.out.println("Inserisci una riga di testo");

        Scanner tastiera = new Scanner(System.in);
        String rigaTesto = tastiera.nextLine();

        String rigaTestoMinuscola = rigaTesto.toLowerCase();

        int consoleIndice = rigaTestoMinuscola.indexOf("console");
        int censoreIndice = rigaTestoMinuscola.indexOf("censore");
        int magistratoIndice = rigaTestoMinuscola.indexOf("magistrato");

        System.out.println("La tua riga di testo ");
        if(consoleIndice > -1)
            System.out.println("\tcontiene console");
        else
            System.out.println("\t non contiene console");

        if(censoreIndice > -1)
            System.out.println("\tcontiene censore");
        else
            System.out.println("\t non contiene coensore");

        if(magistratoIndice > -1)
            System.out.println("\tcontiene magistrato");
        else
            System.out.println("\t non contiene magistrato");

        if(consoleIndice > -1 || censoreIndice > -1 || magistratoIndice > -1)
            System.out.println("Questa riga di testo contiene parole indesiderate.");
        else
            System.out.println("Questa riga di testo non contiene parole indesiderate");



    }



}


