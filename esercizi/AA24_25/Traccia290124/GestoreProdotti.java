import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GestoreProdotti implements Csv {
    ArrayList<Product> products;
    ArrayList<Product> daSalvare = new ArrayList<>();

    public GestoreProdotti() {
        products = new ArrayList<>();
    }

    @Override
    public void readCSV(String path) {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine();
            String line = br.readLine();
            while (line != null) {
                String[] info = line.split(",");
                if (info[0].equals("Phone")) {
                    products.add(new Phone(info[1], info[2], Double.parseDouble(info[3]), info[4],
                            Double.parseDouble(info[5]), Double.parseDouble(info[6]), info[7]));

                } else if (info[0].equals("Computer")) {
                    products.add(new Computer(info[1], info[2], Double.parseDouble(info[3]), info[4],
                            Double.parseDouble(info[5]), Double.parseDouble(info[6]), info[7], info[8]));
                } else {
                    products.add(new Accessory(info[1], info[2], Double.parseDouble(info[3]), info[4],
                            Double.parseDouble(info[5]),
                            Boolean.parseBoolean(info[9])));
                }
                line = br.readLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeCSV(String path, ArrayList<Product> products) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            for (Product product : products) {
                pw.println(product);
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GestoreProdotti gp = new GestoreProdotti();
        Scanner tastiera = new Scanner(System.in);
        gp.readCSV("stock.csv");

        System.out.println("Scegli attributo per raggruppare i prodotti:");
        System.out.println("""
                1 - modello
                2 - marca
                3 - prezzo
                4 - colore
                5 - peso
                6 - memoria
                7 - processore
                8 - gpu
                9 - cancellazioneRumore
                """);
        int scelta = tastiera.nextInt();
        switch (scelta) {
            case 1, 2, 4, 7, 8, 9: {
                System.out.println("Inserisci il valore dell'attributo:");
                String valore = tastiera.next();
                for (Product product : gp.products) {
                    if (product.toString().contains(valore)) {
                        gp.daSalvare.add(product);
                    }

                }
                gp.writeCSV(valore + ".csv", gp.daSalvare);
                gp.daSalvare.clear();
            }

                break;
            case 3, 5, 6: {
                System.out.println("Inserisci valore minimo e massimo in questo modo (min,max)");
                String intervallo = tastiera.next();
                double min = Double.parseDouble(intervallo.split(",")[0]);
                double max = Double.parseDouble(intervallo.split(",")[1]);
                switch (scelta) {
                    case 3: {
                        for (Product product : gp.products) {
                            if (product.prezzo > min && product.prezzo < max) {
                                gp.daSalvare.add(product);
                            }
                        }
                        gp.writeCSV(min + "-" + max + "Prezzo.csv", gp.daSalvare);
                    }
                    case 5: {
                        for (Product product : gp.products) {
                            if (product.peso > min && product.peso < max) {
                                gp.daSalvare.add(product);
                            }
                        }
                        gp.writeCSV(min + "-" + max + "Peso.csv", gp.daSalvare);
                    }
                    case 6: {
                        for (Product product : gp.products) {
                            if (product instanceof Phone) {
                                Phone phone = (Phone) product;
                                if (phone.memoria > min && phone.memoria < max) {
                                    gp.daSalvare.add(product);
                                }
                            }
                            if (product instanceof Computer) {
                                Computer computer = (Computer) product;
                                if (computer.memoria > min && computer.memoria < max) {
                                    gp.daSalvare.add(product);
                                }
                            }
                        }
                        gp.writeCSV(min + "-" + max + "Memoria.csv", gp.daSalvare);
                    }

                        break;

                    default:
                        System.out.println("Scelta errata");
                        break;
                }
            }
            default:
                System.out.println("Scelta errata");
                break;
        }

    }
}
