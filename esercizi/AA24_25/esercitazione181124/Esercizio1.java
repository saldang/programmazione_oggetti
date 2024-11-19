import java.util.Scanner;

public class Esercizio1 {
    public static void main(String[] args) {
        Rubrica rubrica = new Rubrica();
        int scelta = -1;
        Scanner tastiera = new Scanner(System.in);
        while (scelta != 0) {
            System.out.println("1 - Aggiungi contatto manualmente");
            System.out.println("2 - Aggiungi contatti da file");
            System.out.println("3 - Salva contatti su file");
            System.out.println("4 - Stampa contatti");
            System.out.println("0 - Esci");
            scelta = tastiera.nextInt();
            switch (scelta) {
                case 1: {
                    System.out.println("Inserisci nome, cognome e numero di telefono separato da ';'");
                    String infoContatto = tastiera.next();
                    try {
                        rubrica.aggiungiContatto(infoContatto);
                    } catch (ContattoDuplicatoException e) {
                        System.out.println(e.getMessage());
                    }
                }
                    break;
                case 2: {
                    System.out.println("Inserisci il percorso del file da leggere:");
                    String path = tastiera.next();
                    rubrica.leggiDaFile(path);
                }
                    break;
                case 3: {
                    System.out.println("Inserisci il percorso dove salvare il file:");
                    String path = tastiera.next();
                    rubrica.salvaSuFile(path);
                }
                    break;
                case 4:
                    rubrica.stampaContatti();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Scelta errata");
                    break;
            }

        }
        tastiera.close();
    }
}
