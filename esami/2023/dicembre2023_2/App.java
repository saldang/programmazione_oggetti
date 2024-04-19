import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Concessionario concessionario = new Concessionario(CsvReader.leggiCsv());
        Scanner tastiera = new Scanner(System.in);
        int scelta = 0;
        while (scelta != 8) {
            System.out.println("Scegli l'operazione che vuoi effettuare:");
            System.out.println("1 - Aggiungi veicolo;");
            System.out.println("2 - Visualizza inventario");
            System.out.println("3 - Acquista veicolo");
            System.out.println("4 - Noleggia veicolo");
            System.out.println("5 - Visualizza guadagno noleggio");
            System.out.println("6 - Visualizza guadagno vendita ");
            System.out.println("7 - Visualizza guadagno totale");
            System.out.println("8 - Esci");

            scelta = Integer.parseInt(tastiera.nextLine());

            switch (scelta) {
                case 1: {

                    System.out.println("Inserisci il tipo:");
                    String tipo = tastiera.nextLine();
                    if (tipo.equalsIgnoreCase("auto")) {
                        System.out.println(
                                "Inserisci i dati dell'auto separati da virgola(marca,modello,numPorte,prezzoNoleggio,prezzovendita):\n");
                        String[] datiAuto = tastiera.nextLine().split(",");
                        concessionario.aggiungiVeicolo(new Auto(datiAuto[0], datiAuto[1], Integer.parseInt(datiAuto[2]),
                                Double.parseDouble(datiAuto[3]), Double.parseDouble(datiAuto[4])));
                    } else if (tipo.equalsIgnoreCase("moto")) {
                        System.out.println(
                                "Inserisci i dati della moto separati da virgola(marca,modello,cilindrata,prezzoNoleggio,prezzovendita):\n");
                        String[] datiMoto = tastiera.nextLine().split(",");
                        concessionario.aggiungiVeicolo(new Moto(datiMoto[0], datiMoto[1], Integer.parseInt(datiMoto[2]),
                                Double.parseDouble(datiMoto[3]), Double.parseDouble(datiMoto[4])));
                    } else {
                        System.out.println("Tipo errato!");
                    }
                }
                    break;
                case 2: {
                    concessionario.visualizzaInventario();
                }
                    break;
                case 3: {
                    for (int i = 0; i < concessionario.inventario.size(); i++) {
                        System.out.println(i + ":" + concessionario.inventario.get(i).descrizione());
                    }
                    System.out.println("Inserisci il codice del veicolo da acquistare:");
                    int codice = tastiera.nextInt();
                    tastiera.nextLine();

                    if (codice >= 0 && codice < concessionario.inventario.size())
                        concessionario.acquistaVeicolo(concessionario.inventario.get(codice));
                    else
                        System.out.println("Codice errato!");
                }
                    break;
                case 4: {
                    for (int i = 0; i < concessionario.inventario.size(); i++) {
                        System.out.println(i + ":" + concessionario.inventario.get(i).descrizione());
                    }
                    System.out.println("Inserisci il codice del veicolo da noleggiare:");
                    int codice = tastiera.nextInt();
                    tastiera.nextLine();

                    if (codice >= 0 && codice < concessionario.inventario.size())
                        concessionario.noleggiaVeicolo(concessionario.inventario.get(codice));
                    else
                        System.out.println("Codice errato!");
                }
                    break;
                case 5: {
                    System.out.printf("Guadagno Noleggio: %f\n", concessionario.calcolaGuadagnoNoleggio());
                }
                    break;
                case 6: {
                    System.out.printf("Guadagno Vendita: %f\n", concessionario.calcolaGuadagnoVendita());
                }
                    break;
                case 7: {
                    System.out.printf("Guadagno Totale: %f\n", concessionario.calcolaGuadagnoTotale());
                }
                    break;
                case 8:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta errata");
                    break;
            }

        }
        tastiera.close();
    }
}
