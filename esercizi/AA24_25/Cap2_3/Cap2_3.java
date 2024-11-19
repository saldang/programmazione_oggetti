
import java.util.Scanner;

public class Cap2_3 {

    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        final double interesse;
        // final double ipoteca = 150000;
        System.out.println("Inserisci l'ammontare dell'ipoteca:");
        double ipoteca = tastiera.nextDouble();
        System.out.println("Inserisci il tasso di interesse:");
        interesse = tastiera.nextDouble();
        double debito = ipoteca;
        // boolean esci = false;
        int count = 0;

        // while (!esci) {
        // System.out.println("Vuoi inserire un pagamento?(Y/N):");
        // String scelta = tastiera.next();
        // if (scelta.equalsIgnoreCase("n")) {
        // break;
        // } else if (scelta.equalsIgnoreCase("y")) {
        // esci = false;
        // } else {
        // System.out.println("Scelta errata");
        // }

        System.out.println("Inserisci l'ammontare da versare (eg. 1250.50):");
        double pagamentoMensile = tastiera.nextDouble();

        while (debito > 0) {
            System.out.println(debito);

            debito -= pagamentoMensile;
            double interesseMensile = debito * ((interesse / 100) / 12);
            debito += debito * ((interesse / 100) / 12);
            System.out.println(interesseMensile);
            System.out.println(debito);
            count++;
        }
        System.out.println("Hai impiegato " + count / 12 + " anni per estinguere l'ipoteca!");
        System.out.println("Ciao!");
        tastiera.close();
    }
}
