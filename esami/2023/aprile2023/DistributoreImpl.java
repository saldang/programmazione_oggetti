package aprile2023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DistributoreImpl implements Distributore{
    double credito = 0;
    ArrayList<Prodotto> prodotti = new ArrayList<>();


    @Override
    public void aggiungiProdotto(Prodotto p) {
        for (Prodotto prodotto : prodotti) {
            if (prodotto.getCodice().equals(p.getCodice())) {
                prodotto.setQuantita(prodotto.getQuantita() + p.getQuantita());
                return;
            } else {
                prodotti.add(p);
            }
        }
    }

    @Override
    public void aggiungiMoneta(Moneta m) {
        credito += m.getValore();
    }

    @Override
    public void acquista(String codice) {
        for (Prodotto p : prodotti) {
            if (p.getCodice().equals(codice)) {
                if (p.getPrezzo() <= credito) {
                    if (p.getQuantita() > 0) {
                        credito -= p.getPrezzo();
                        p.setQuantita(p.getQuantita() - 1);
                        System.out.println("Acquisto effettuato");
                    } else {
                        System.out.println("Prodotto esaurito");
                    }
                } else {
                    System.out.println("Credito insufficiente");
                }
            }
        }
    }

    @Override
    public void carica(String nomeFile) {

        try {
            FileReader fr = new FileReader(nomeFile);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                String[] campi = linea.split(",");
                Prodotto p = new Prodotto(campi[0], campi[1], Double.parseDouble(campi[2]), Integer.parseInt(campi[3]));
                prodotti.add(p);
                linea = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void restituisciResto() {
        System.out.println("Resto: " + credito);
    }

    @Override
    public void stampaStock() {
        for (Prodotto p : prodotti) {
            System.out.println(p.getCodice() + " " + p.getNome() + " " + p.getPrezzo() + " " + p.getQuantita());
        }
    }

    @Override
    public void stampaCredito() {
        System.out.println("Credito: " + credito);
    }
}
