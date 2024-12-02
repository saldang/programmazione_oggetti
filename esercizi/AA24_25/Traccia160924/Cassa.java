import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Cassa implements GestioneFile {
    public Inventario inventario;
    ArrayList<Ordine> ordini;

    public Cassa() {
        inventario = new Inventario();
        ordini = new ArrayList<>();
    }

    public Ordine creaOrdine() {
        Ordine newOrdine = new Ordine(LocalDateTime.now());
        ordini.add(newOrdine);
        return newOrdine;
    }

    public void calcolaTotale(Ordine ordine) {
        double totale = 0;
        for (Articolo articolo : ordine.articoli.keySet()) {
            totale += articolo.prezzo * ordine.articoli.get(articolo);
        }
        ordine.setTotaleOrdine(totale);
    }

    @Override
    public void leggiFile(String path) {
        throw new UnsupportedOperationException("Unimplemented method 'leggiFile'");
    }

    @Override
    public void scriviFile(String path) {
        FileWriter fw;
        BufferedWriter bw;
        try {
            fw = new FileWriter(path);
            bw = new BufferedWriter(fw);
            for (Ordine ordine : ordini) {
                bw.write(ordine.data.toString());
                bw.newLine();
                bw.write("Articolo,Codice,Quantità,PrezzoUnitario,Totale\n");
                for (Articolo articolo : ordine.articoli.keySet()) {
                    bw.write(articolo.nome + "," + articolo.codice + "," + ordine.articoli.get(articolo) + ","
                            + articolo.prezzo + "," + articolo.prezzo * ordine.articoli.get(articolo) + "\n");
                }
                bw.write("Totale Vendita: " + ordine.totaleOrdine + "\n\n\n");
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
