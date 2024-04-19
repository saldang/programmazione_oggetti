import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Implementare una classe **Magazzino** che gestisca l'inventario dei prodotti.
 * Questa classe deve contenere un elenco di prodotti, consentire l'aggiunta e
 * la rimozione di prodotti e fornire un metodo per visualizzare l'inventario
 * corrente.
 * Implementare un'interfaccia **GestioneFile** con metodi per la lettura e la
 * scrittura su file.
 * Modificare la classe **Magazzino** in modo che implementi l'interfaccia
 * **GestioneFile** per salvare e caricare l'inventario da un file di testo.
 */

public class Magazzino implements GestioneFile {

    ArrayList<Prodotto> prodotti;

    public Magazzino() {
        prodotti = new ArrayList<Prodotto>();
    }

    public void aggiungiProdotto(Prodotto p) {
        prodotti.add(p);
    }

    public void rimuoviProdotto(int codice) {
        for (int i = 0; i < prodotti.size(); i++) {
            if (prodotti.get(i).codice == codice) {
                prodotti.remove(i);
                return;
            }
        }
    }

    public void visualizzaInventario() {
        for (int i = 0; i < prodotti.size(); i++) {
            System.out.println(prodotti.get(i).toString());
        }
    }

    public void salva(String nomeFile) {
        try (FileWriter fw = new FileWriter(nomeFile);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {

            for (int i = 0; i < prodotti.size(); i++) {
                out.println(prodotti.get(i).toString());
            }

        } catch (Exception e) {
            if (e instanceof java.io.FileNotFoundException) {
                System.out.println("File non trovato");
            } else {
                System.out.println("Errore");
            }
        }
    }

    public void carica(String nomeFile) {
        try (FileReader fr = new FileReader(nomeFile);
                BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(" ");
                if (tokens[0].equals("Parafarmaco")) {
                    int codice = Integer.parseInt(tokens[1]);
                    String nome = tokens[2];
                    double prezzo = Double.parseDouble(tokens[3]);
                    int quantita = Integer.parseInt(tokens[4]);
                    if (tokens.length == 6) {
                        String dataScadenza = tokens[4];
                        Parafarmaco p = new Parafarmaco(codice, nome, prezzo, quantita, dataScadenza);
                        prodotti.add(p);
                    } else {
                        Parafarmaco p = new Parafarmaco(codice, nome, prezzo, quantita, null);
                        prodotti.add(p);
                    }
                } else if (tokens[0].equals("Farmaco")) {
                    int codice = Integer.parseInt(tokens[1]);
                    String nome = tokens[2];
                    double prezzo = Double.parseDouble(tokens[3]);
                    int quantita = Integer.parseInt(tokens[4]);
                    String categoria = tokens[5];
                    Farmaco f = new Farmaco(codice, nome, prezzo, quantita, categoria);
                    prodotti.add(f);
                }
            }

        } catch (java.io.FileNotFoundException e) {
            System.out.println("File non trovato");
        } catch (Exception e) {
            System.out.println("Errore");
        }

    }

}
