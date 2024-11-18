import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Pagamento[] pagamenti = new Pagamento[3];
        Scanner tastiera = new Scanner(System.in);
        for (int i = 0; i < pagamenti.length; i++) {
            System.out.println("Che pagamento vuoi inserire: \n1 - Contanti \n2 - Carta");
            int scelta = tastiera.nextInt();
            System.out.println("Inserisci l'importo del pagamento:");
            double importo = tastiera.nextDouble();
            switch (scelta) {
                case 1:
                    pagamenti[i] = new PagamentoContanti(importo);
                    break;
                case 2: {
                    System.out.println("Inserisci i dati della carta:");
                    System.out.println("Nome Intestatario:");
                    String intestatario = tastiera.next();
                    System.out.println("Numero carta:");
                    String numeroCarta = tastiera.next();
                    System.out.println("Data scadenza:");
                    String dataScadenza = tastiera.next();
                    pagamenti[i] = new PagamentoCarta(importo, intestatario, numeroCarta, dataScadenza);

                }
                    break;
                default:
                    System.out.println("Scelta errata");
                    break;
            }

        }

        for (Pagamento pagamento : pagamenti) {
            if (App.pagamentoSuperioreA(pagamento, 200.0))
                pagamento.dettaglioPagamento();
        }

        tastiera.close();
    }

    public static boolean pagamentoSuperioreA(Pagamento pagamento, Double importo) {
        if (pagamento.getImporto() > importo)
            return true;
        return false;
    }

}
