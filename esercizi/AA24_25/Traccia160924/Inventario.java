import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Inventario implements GestioneFile {
    public ArrayList<Articolo> articoli;

    public Inventario() {
        articoli = new ArrayList<>();
    }

    public void aggiungiArticolo(Articolo newArticolo) {
        for (Articolo articolo : articoli) {
            if (articolo.codice.equals(newArticolo.codice)) {
                articolo.quantita++;
                return;
            }
        }
        articoli.add(newArticolo);
    }

    public void rimuoviArticolo(String codice) {
        for (Articolo articolo : articoli) {
            if (articolo.codice.equals(codice)) {
                articoli.remove(articolo);
                break;
            }
        }

    }

    public void aggiornaQuantita(String codice, int n) {
        for (Articolo articolo : articoli) {
            if (articolo.codice.equals(codice))
                articolo.quantita += n;
        }
    }

    public void stampaInventario() {
        for (Articolo articolo : articoli) {
            System.out.println(articolo);
        }
    }

    public Articolo getArticoloByCode(String codice) throws ArticoloNonPresenteException {
        for (Articolo articolo : articoli) {
            if (articolo.codice.equals(codice))
                return articolo;
        }
        throw new ArticoloNonPresenteException("Articolo non trovato");
    }

    @Override
    public void leggiFile(String path) {
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            String line = br.readLine();
            while (line != null) {
                String[] info = line.split(",");
                if (info[0].equalsIgnoreCase("bevanda"))
                    aggiungiArticolo(new Bevanda(info[1], info[2], Double.parseDouble(info[3]),
                            Integer.parseInt(info[4]), info[5]));
                else
                    aggiungiArticolo(new Snack(info[1], info[2], Double.parseDouble(info[3]), Integer.parseInt(info[4]),
                            info[5]));
                line = br.readLine();
            }
            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void scriviFile(String path) {
        FileWriter fw;
        BufferedWriter bw;
        try {
            fw = new FileWriter(path);
            bw = new BufferedWriter(fw);

            for (Articolo articolo : articoli) {
                bw.write(articolo.toString());
                bw.newLine();
            }

            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
