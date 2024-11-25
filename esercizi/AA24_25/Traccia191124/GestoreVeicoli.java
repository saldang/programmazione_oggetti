import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class GestoreVeicoli {
    RepositoryVeicoli repoVeicoli = new RepositoryVeicoli();

    public static void main(String[] args) {
        GestoreVeicoli gv = new GestoreVeicoli();
        Scanner tastiera = new Scanner(System.in);
        int scelta = -1;

        while (scelta != 0) {
            System.out.println("""
                    1 - Aggiungi Veicolo;
                    2 - Rimuovi Veicolo;
                    3 - Leggi veicoli;
                    4 - Stampa valore veicolo;
                    5 - Calcola valore veicolo;
                    6 - Accelera, Frena, Visualizza distanza;
                    7 - Salva lista in file binario;
                    8 - Carica lista da file csv;
                    0 - Esci.
                    Cosa voui fare?
                    """);

            scelta = tastiera.nextInt();
            switch (scelta) {
                case 1: {
                    System.out.println("""
                            Cosa vuoi inserire:
                            1 - automobile
                            2 - motocicletta
                            3 - bicicletta""");

                    int tipo = tastiera.nextInt();

                    System.out.println("Inserisci marca,modello, anno, colore");
                    String[] input = tastiera.next().split(",");
                    switch (tipo) {
                        case 1:
                            gv.repoVeicoli
                                    .aggiungi(new Automobile(input[0], input[1], Integer.parseInt(input[2]), input[3]));
                            break;
                        case 2:
                            gv.repoVeicoli
                                    .aggiungi(
                                            new Motocicletta(input[0], input[1], Integer.parseInt(input[2]), input[3]));
                            break;
                        case 3:
                            gv.repoVeicoli
                                    .aggiungi(new Bicicletta(input[0], input[1], Integer.parseInt(input[2]), input[3]));
                            break;

                        default:
                            System.out.println("Scelta errata!");
                            break;
                    }

                }
                    break;
                case 2:

                {
                    System.out.println("Inserisci marca,modello");
                    String[] input = tastiera.next().split(",");

                    gv.repoVeicoli
                            .rimuovi(input[0], input[1]);

                }
                    break;
                case 3:
                    gv.repoVeicoli.leggiVeicoli();

                    break;
                case 4: {
                    System.out.println("Inserisci marca, modello:");
                    String[] infoValore = tastiera.next().split(",");
                    for (Veicolo veicolo : gv.repoVeicoli.veicoli) {
                        if (veicolo.marca.equalsIgnoreCase(infoValore[0])
                                && veicolo.modello.equalsIgnoreCase(infoValore[1])) {
                            veicolo.calcolaValoreMercato();
                        }

                    }
                }

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7: {
                    FileOutputStream fw = null;
                    ObjectOutputStream os = null;
                    try {
                        fw = new FileOutputStream("./veicoli.dat");
                        os = new ObjectOutputStream(fw);
                        for (Veicolo veicolo : gv.repoVeicoli.veicoli) {
                            os.writeObject(veicolo);

                        }
                    }

                    catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            os.close();
                            fw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                    break;
                case 8: {
                    FileReader fr = null;
                    BufferedReader br = null;
                    try {
                        fr = new FileReader("./veicoli.csv");
                        br = new BufferedReader(fr);
                        String line = br.readLine();
                        line = br.readLine();
                        while (line != null) {
                            System.out.println(line);
                            String[] info = line.split(",");
                            if (info[3].equals("automobile")) {
                                gv.repoVeicoli
                                        .aggiungi(new Automobile(info[0], info[1], Integer.parseInt(info[2]), info[9]));
                            } else if (info[3].equals("motocicletta")) {
                                gv.repoVeicoli
                                        .aggiungi(
                                                new Motocicletta(info[0], info[1], Integer.parseInt(info[2]), info[9]));
                            } else {
                                gv.repoVeicoli
                                        .aggiungi(new Bicicletta(info[0], info[1], Integer.parseInt(info[2]), info[9]));
                            }
                            line = br.readLine();

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                    break;
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    break;
            }
        }

    }
}
