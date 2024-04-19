import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Negozio negozio = new Negozio();
        Scanner tastiera = new Scanner(System.in);
        int scelta = 0;
        do {
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Carica da file");
            System.out.println("2. Visualizza prodotti");
            System.out.println("3. Aggiungi prodotto");
            System.out.println("4. Cerca prodotto per codice");
            System.out.println("5. Esci");
            scelta = tastiera.nextInt();
            tastiera.nextLine();
            switch (scelta) {
                case 1: {
                    System.out.println("Inserisci il nome del file da caricare:");
                    String nomeFile = tastiera.nextLine();
                    negozio.caricaDaFile(nomeFile);

                }
                    break;
                case 2: {
                    System.out.println("Prodotti disponibili:");
                    negozio.visualizzaProdotti();
                }
                    break;
                case 3: {

                    System.out.println(
                            "Inserisci le informazioni separat da virgola(codice,descrizione,prezzo,taglia,materiale o codice,descrizione,prezzo,colore):");
                    String datiProdotto = tastiera.nextLine();
                    negozio.aggiungiProdotto(datiProdotto);
                    
                    // System.out.println("Che tipo di prodotto vuoi aggiungere:");
                    // String tipo = tastiera.nextLine();
                    // if (tipo.equalsIgnoreCase("abbigliamento")) {
                    // System.out.println(
                    // "Inserisci le informazioni separate da
                    // virgola(codice,descrizione,prezzo,taglia,materiale):");
                    // String[] datiAbbigliamento = tastiera.nextLine().split(",");
                    // if (negozio.verificaCodiceProdotto(datiAbbigliamento[0])) {
                    // System.out.println("Codice prodotto gia presente!");
                    // } else {

                    // negozio.aggiungiProdotto(new Abbigliamento(datiAbbigliamento[0],
                    // datiAbbigliamento[1],
                    // Double.parseDouble(datiAbbigliamento[2]), datiAbbigliamento[3],
                    // datiAbbigliamento[4]));
                    // }
                    // } else if (tipo.equalsIgnoreCase("accessorio")) {
                    // System.out.println(
                    // "Inserisci le informazioni separate da
                    // virgola(codice,descrizione,prezzo,colore):");
                    // String[] datiAbbigliamento = tastiera.nextLine().split(",");
                    // if (negozio.verificaCodiceProdotto(datiAbbigliamento[0])) {
                    // System.out.println("Codice prodotto gia presente!");
                    // } else {
                    // negozio.aggiungiProdotto(new Accessorio(datiAbbigliamento[0],
                    // datiAbbigliamento[1],
                    // Double.parseDouble(datiAbbigliamento[2]), datiAbbigliamento[3]));
                    // }

                    // } else {
                    // System.out.println("Tipo errato");
                    // }
                }
                    break;
                case 4: {
                    System.out.println("Inserisci il codice da ricercare:");
                    String codice = tastiera.nextLine();
                    try {
                        Prodotto p = negozio.cercaProdottoPerCodice(codice);
                        System.out.println(p);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
                    break;
                case 5:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    break;
            }
        } while (scelta != 5);
        tastiera.close();
    }
}
