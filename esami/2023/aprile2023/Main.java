package aprile2023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Distributore d = new DistributoreImpl();
        ArrayList<String[]> inputs = new ArrayList<>();
        try (FileReader fr = new FileReader(
                "/home/salvatoredangelo/Insync/totore86@gmail.com/Google Drive/RTDa2021/Didattica/PAO-ASD/PAO/dangelo/Esercizi/esame/aprile2023/input.csv")) {
            BufferedReader br = new BufferedReader(fr);
            // Leggi file input.csv
            String linea = br.readLine();
            while (linea != null) {
                String[] input = linea.split(",");
                inputs.add(input);
                linea = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        do {
            System.out.println("Benvenuto nel distributore automatico");
            System.out.println("1. Acquista prodotto");
            System.out.println("2. Aggiungi prodotto");
            System.out.println("3. Carica il distributore");
            System.out.println("0. Esci");
            String scelta;
            for (int i = 0; i < inputs.size(); i++) {
                scelta = inputs.get(i)[0];
                System.out.println("Scelta: " + scelta);
                switch (scelta) {
                    case "1": {
                        String scelta2 = "";
                        do {

                            System.out.println("Inserisci moneta o 0 per terminare");
                            for (String moneta : inputs.get(i)[1].split(" ")) {
                                scelta2 = moneta;
                                if (!scelta2.equals("0"))
                                    d.aggiungiMoneta(Moneta.valueOf(scelta2));
                            }
                        } while (!scelta2.equals("0"));
                        String codice;
                        codice = inputs.get(i)[2];
                        d.acquista(codice);
                        d.stampaCredito();
                        d.stampaStock();
                        break;
                    }
                    case "2": {
                        String codice;
                        String nome;
                        double prezzo;
                        int quantita;
                        codice = inputs.get(i)[1].split(" ")[0];
                        nome = inputs.get(i)[1].split(" ")[1];
                        prezzo = Double.parseDouble(inputs.get(i)[1].split(" ")[2]);
                        if (inputs.get(i)[1].split(" ").length == 4) {
                            quantita = Integer.parseInt(inputs.get(i)[1].split(" ")[3]);
                            d.aggiungiProdotto(new Prodotto(codice, nome, prezzo, quantita));
                        } else {
                            d.aggiungiProdotto(new Prodotto(codice, nome, prezzo));
                        }
                        break;
                    }
                    case "3": {
                        d.carica(
                                "/home/salvatoredangelo/Insync/totore86@gmail.com/Google Drive/RTDa2021/Didattica/PAO-ASD/PAO/dangelo/Esercizi/esame/aprile2023/"
                                        + inputs.get(i)[1]);
                        d.stampaStock();
                        break;
                    }
                    case "0": {
                        System.out.println("Grazie per aver usato il distributore");
                        System.exit(0);
                        break;
                    }
                    default:
                        System.out.println("Scelta non valida");
                        break;
                }
            }
        } while (true);
    }
}
