import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Negozio {
    ArrayList<Prodotto> prodotti;

    public Negozio() {
        prodotti = new ArrayList<>();
    }

    public void caricaDaFile(String nomeFile) {
        BufferedReader br;
        FileReader fr;
        try {
            fr = new FileReader(nomeFile);
            br = new BufferedReader(fr);
            String riga = br.readLine();
            while (riga != null) {
                String[] tokens = riga.split(",");
                if (tokens[0].equalsIgnoreCase("abbigliamento")) {
                    prodotti.add(new Abbigliamento("P" + Integer.parseInt(tokens[1].substring(1)), tokens[2],
                            Double.parseDouble(tokens[3]), tokens[4],
                            tokens[5]));
                } else {
                    prodotti.add(new Accessorio("A" + Integer.parseInt(tokens[1].substring(1)), tokens[2],
                            Double.parseDouble(tokens[3]), tokens[4]));
                }
                riga = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void aggiungiProdotto(Prodotto prodotto) {
        prodotti.add(prodotto);

    }

    public void aggiungiProdotto(String datiProdotto) {
        String[] info = datiProdotto.split(",");
        if (info.length == 5) {
            int codice = 0;
            if (info[0].contains("*")) {
                for (Prodotto prodotto : prodotti) {
                    
                    if (prodotto instanceof Abbigliamento) {
                        if (Integer.parseInt(prodotto.codice.substring(1)) > codice)
                            codice = Integer.parseInt(prodotto.codice.substring(1));
                    }
                }
                prodotti.add(new Abbigliamento("P" + ++codice, info[1], Double.parseDouble(info[2]), info[3], info[4]));
            } else if (!verificaCodiceProdotto(info[0])) {
                prodotti.add(new Abbigliamento(info[0], info[1], Double.parseDouble(info[2]), info[3], info[4]));
            } else {
                System.out.println("Prodotto gia presente");
            }

        } else if (info.length == 4) {
            int codice = 0;
            if (info[0].contains("*")) {
                for (Prodotto prodotto : prodotti) {
                    if (prodotto instanceof Accessorio) {
                        if (Integer.parseInt(prodotto.codice.substring(1)) > codice)
                            codice = Integer.parseInt(prodotto.codice.substring(1));
                    }
                }
                prodotti.add(new Accessorio("P" + ++codice, info[1], Double.parseDouble(info[2]), info[3]));
            } else if (!verificaCodiceProdotto(info[0])) {
                prodotti.add(new Accessorio(info[0], info[1], Double.parseDouble(info[2]), info[3]));
            } else {
                System.out.println("Prodotto gia presente");
            }
        } else {
            System.out.println("Dati inseriti non corretti!");
        }
    }

    public void visualizzaProdotti() {
        for (Prodotto prodotto : prodotti) {

            System.out.println(prodotto);
        }

    }

    public boolean verificaCodiceProdotto(String codice) {
        codice = codice.substring(0, 1) + Integer.parseInt(codice.substring(1));
        for (Prodotto prodotto : prodotti) {
            if (prodotto.codice.equalsIgnoreCase(codice))
                return true;
        }
        return false;
    }

    public Prodotto cercaProdottoPerCodice(String codice) throws Exception {
        codice = codice.substring(0, 1) + Integer.parseInt(codice.substring(1));
        for (Prodotto prodotto : prodotti) {
            if (prodotto.codice.equalsIgnoreCase(codice))
                return prodotto;
        }
        throw new Exception("Prodotto non trovato");
    }
}
