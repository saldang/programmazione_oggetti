import java.util.Scanner;


public class MesePerMese {

    public static void main(String[] args) {

        Scanner tastiera = new Scanner(System.in);

        double percentualeInteresseAnnuale = 7.0;
        double saldo = 0.0;

        //1. Per mese che va da 1 a 12
        for(int mese = 1; mese <= 12; mese++){
            //1.1. Calcola l’interesse mensile
            double percentualeInteresseMensile = percentualeInteresseAnnuale/12;

            //1.2. Calcola e aggiungi l’interesse al saldo
            double interesse = saldo * percentualeInteresseMensile / 100;
            saldo += interesse;

            // 1.3. Chiedi all’utente se fa un deposito o un prelievo.
            System.out.println("Vuoi depositare (d) o prelevare (p)?");
            String risposta = tastiera.next();

            //1.4. Ottieni l’ammontare dall’utente
            System.out.println("Qual e' l'ammontare?");
            double ammontare = tastiera.nextDouble();

            //1.5. Se fa un deposito
            if(risposta.equals("d")) {
                //1.5.1. Aggiungi l’ammontare al saldo
                saldo += ammontare;
            } else { //1.6. Altrimenti
                // 1.6.1. Sottrai l’ammontare dal saldo
                saldo -= ammontare;
            }

            //1.7. Mostra l’attuale saldo
            System.out.println("Il tuo saldo attuale e' " + saldo);
        }
    }

}

