import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Implementare una classe **Cassa** che gestisca le vendite al banco.
 * Deve consentire l'aggiunta di prodotti alla transazione corrente,
 * calcolare il totale della vendita e registrare la vendita completata.
 */

public class Cassa implements GestioneFile {

    ArrayList<Vendita> ventite;

    public Cassa() {
        ventite = new ArrayList<Vendita>();
    }

    public void creaVendita(String dataVendita) {
        ventite.add(new Vendita(dataVendita));
    }

    public void aggiungiProdotto(Prodotto p, int quantita) {
        ventite.get(ventite.size() - 1).prodottiVenduti.put(p, quantita);
    }

    public void rimuoviProdotto(Prodotto p) {
        ventite.get(ventite.size() - 1).prodottiVenduti.remove(p);
    }

    public void visualizzaVendita() {
        Vendita v = ventite.get(ventite.size() - 1);
        System.out.println("Data vendita: " + v.dataVendita);
        System.out.println("Prodotti venduti:");
        for (Prodotto p : v.prodottiVenduti.keySet()) {
            System.out.println(p.nome + " " + v.prodottiVenduti.get(p));
        }
        System.out.println("Prezzo totale: " + v.prezzoTotale);
    }

    public void registraVendita() {
        Vendita v = ventite.get(ventite.size() - 1);
        double prezzoTotale = 0;
        for (Prodotto p : v.prodottiVenduti.keySet()) {
            prezzoTotale += p.prezzo * v.prodottiVenduti.get(p);
        }
        v.prezzoTotale = prezzoTotale;
    }

    public void salva(String nomeFile) {
        try (FileWriter fw = new FileWriter(nomeFile);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {

            for (int i = 0; i < ventite.size(); i++) {
                out.println(ventite.get(i).toString());
            }

        } catch (Exception e) {
            if (e instanceof java.io.FileNotFoundException) {
                System.out.println("File non trovato");
            } else {
                System.out.println("Errore");
            }
        }
    }

    @Override
    public void carica(String nomeFile) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Operazione non supportata");
    }

}
