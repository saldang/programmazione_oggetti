import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Gestore implements CSVReader {

    ArrayList<Product> prodotti = new ArrayList<Product>();
    ArrayList<Product> raggruppamento = new ArrayList<Product>();

    public Gestore(String nomeFile) {
        readCSV(nomeFile);
    }

    public void raggruppaProdotti(String test) {
        String[] inputDaTastiera = test.split(",");
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Scegli l'attributo per cui vuoi raggruppare i prodotti:");
        System.out.println("1. Marca");
        System.out.println("2. Modello");
        System.out.println("3. Colore");
        System.out.println("4. Processore");
        System.out.println("5. GPU");
        System.out.println("6. Memoria");
        System.out.println("7. Peso");
        System.out.println("8. Prezzo");
        System.out.println("9. Cancellazione rumore");
        System.out.println("0. Esci");

        // int scelta = tastiera.nextInt();
        // tastiera.nextLine();

        int scelta = Integer.parseInt(inputDaTastiera[0]);
        System.out.println("scelta: " + scelta);
        switch (scelta) {
            case 1, 2, 3, 4, 5: {
                // System.out.println("Inserisci il valore dell'attributo:");
                // String attributo = tastiera.nextLine();
                String attributo = inputDaTastiera[1];
                System.out.println("attributo: " + attributo);
                switch (scelta) {
                    case 1: {
                        for (Product p : prodotti) {
                            if (p.marca.equalsIgnoreCase(attributo)) {
                                raggruppamento.add(p);
                            }
                        }
                    }
                        break;
                    case 2: {
                        for (Product p : prodotti) {
                            if (p.modello.equalsIgnoreCase(attributo)) {
                                raggruppamento.add(p);
                            }
                        }
                    }
                        break;
                    case 3: {
                        for (Product p : prodotti) {
                            if (p.colore.equalsIgnoreCase(attributo)) {
                                raggruppamento.add(p);
                            }
                        }
                    }
                        break;
                    case 4: {
                        for (Product p : prodotti) {
                            if (p instanceof Phone) {
                                // Downcasting
                                if (((Phone) p).processore.equalsIgnoreCase(attributo)) {
                                    raggruppamento.add(p);
                                }
                            }
                            if (p instanceof Computer) {
                                // Downcasting
                                Computer computer = (Computer) p;
                                if (computer.processore.equalsIgnoreCase(attributo)) {
                                    raggruppamento.add(p);
                                }
                            }
                        }
                    }
                        break;
                    case 5: {
                        for (Product p : prodotti) {
                            if (p instanceof Computer) {
                                // Downcasting
                                Computer computer = (Computer) p;
                                if (computer.gpu.equalsIgnoreCase(attributo)) {
                                    raggruppamento.add(p);
                                }
                            }
                        }
                    }
                        break;

                    default:
                        break;
                }
                writeCSV(attributo + ".csv");
            }
                break;
            case 6, 7, 8: {
                // System.out.println("Inserisci il valore minino dell'attributo:");
                // int min = tastiera.nextInt();

                // System.out.println("Inserisci il valore massimo dell'attributo:");
                // int max = tastiera.nextInt();
                int min = Integer.parseInt(inputDaTastiera[1]);
                int max = Integer.parseInt(inputDaTastiera[2]);
                System.out.println("min: " + min);
                System.out.println("max: " + max);

                switch (scelta) {
                    case 6: {
                        for (Product p : prodotti) {
                            if (p instanceof Phone) {
                                // Downcasting
                                if (((Phone) p).memoria >= min && ((Phone) p).memoria <= max) {
                                    raggruppamento.add(p);
                                }
                            }
                            if (p instanceof Computer) {
                                // Downcasting
                                Computer computer = (Computer) p;
                                if (computer.memoria >= min && computer.memoria <= max) {
                                    raggruppamento.add(p);
                                }
                            }
                        }
                        writeCSV("Memoria" + min + "-" + max + ".csv");
                    }
                        break;
                    case 7: {
                        for (Product p : prodotti) {
                            if (p.peso >= min && p.peso <= max) {
                                raggruppamento.add(p);
                            }
                        }
                        writeCSV("Peso" + min + "-" + max + ".csv");
                    }
                        break;
                    case 8: {
                        for (Product p : prodotti) {
                            if (p.prezzo >= min && p.prezzo <= max) {
                                raggruppamento.add(p);
                            }
                        }
                        writeCSV("Prezzo" + min + "-" + max + ".csv");
                    }
                        break;
                    default:
                        break;
                }
            }

                break;
            case 9: {
                // System.out.println("Inserisci il valore dell'attributo:");
                // boolean attributo = tastiera.nextBoolean();
                boolean attributo = Boolean.parseBoolean(inputDaTastiera[1]);
                System.out.println("attributo: " + attributo);
                for (Product p : prodotti) {
                    if (p instanceof Accessory) {
                        // Downcasting
                        if (((Accessory) p).cancellazioneRumore == attributo) {
                            raggruppamento.add(p);
                        }
                    }
                }
                writeCSV("Cancellazione rumore-" + attributo + ".csv");
            }

                break;
            case 0:
                System.exit(0);
            default:
                break;
        }
    }

    @Override
    public void readCSV(String nomeFile) {

        try {
            FileReader file = new FileReader(nomeFile);
            BufferedReader reader = new BufferedReader(file);
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                String[] dati = line.split(",");
                if (dati[0].equals("Phone")) {
                    Phone phone = new Phone(dati[1], dati[2], dati[4], Integer.parseInt(dati[3]),
                            Integer.parseInt(dati[5]), Integer.parseInt(dati[6]), dati[7]);
                    prodotti.add(phone);
                }
                if (dati[0].equals("Computer")) {
                    Computer computer = new Computer(dati[1], dati[2], dati[4], Integer.parseInt(dati[3]),
                            Integer.parseInt(dati[5]), Integer.parseInt(dati[6]), dati[7], dati[8]);
                    prodotti.add(computer);
                }
                if (dati[0].equals("Accessory")) {
                    Accessory accessory = new Accessory(dati[1], dati[2], dati[4], Integer.parseInt(dati[3]),
                            Integer.parseInt(dati[5]), Boolean.parseBoolean(dati[9]));
                    prodotti.add(accessory);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void writeCSV(String nomeFile) {
        try {
            FileWriter file = new FileWriter(nomeFile);
            BufferedWriter writer = new BufferedWriter(file);
            writer.write("Tipo,Modello,Marca,Colore,Prezzo,Peso,Memoria,Processore,GPU,Cancellazione rumore");
            writer.newLine();
            for (Product p : raggruppamento) {
                writer.write(p.scriviDettagli());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
