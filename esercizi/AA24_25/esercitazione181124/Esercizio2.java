import java.util.Scanner;

public class Esercizio2 {
    public static void main(String[] args) {
        Registro registro = new Registro();
        int scelta = -1;
        Scanner tastiera = new Scanner(System.in);
        while (scelta != 0) {
            System.out.println("1 - Aggiungi studente manualmente");
            System.out.println("2 - Aggiungi studenti da file");
            System.out.println("3 - Salva studenti su file");
            System.out.println("4 - Stampa studenti");
            System.out.println("5 - Cerca Studente");
            System.out.println("0 - Esci");
            scelta = tastiera.nextInt();
            switch (scelta) {
                case 1: {
                    System.out.println("Inserisci id,nome, cognome,media voti separato da ','");
                    String infoStudente = tastiera.next();
                    try {
                        registro.aggiungi(infoStudente);
                    } catch (StudenteDuplicatoException e) {
                        System.out.println(e.getMessage());
                    }
                }
                    break;
                case 2: {
                    System.out.println("Inserisci il percorso del file da leggere:");
                    String path = tastiera.next();
                    registro.leggiDaFileBin(path);
                }
                    break;
                case 3: {
                    System.out.println("Inserisci il percorso dove salvare il file:");
                    String path = tastiera.next();
                    registro.salvaSuFileBin(path);
                }
                    break;
                case 4:
                    registro.visualizza();
                    break;
                case 5: {
                    System.out.println("Inserisci la matricola da cercare:");
                    int iD = tastiera.nextInt();
                    try {
                        registro.cerca(iD);
                    } catch (StudenteNonTrovatoException e) {
                        System.out.println(e.getMessage());
                    }
                }

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
