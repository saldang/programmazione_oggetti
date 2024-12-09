import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Ciurma {

    String nome;
    ArrayList<Nave> navi;
    List<Pirata> pirati;

    public Ciurma(String nome) {
        this.nome = nome;
        navi = new ArrayList<>();
        pirati = new ArrayList<>();
    }

    public void stampa() {
        System.out.println("PIRATI");
        for (Pirata pirata : pirati) {
            System.out.printf("%-20s|%-20s|%-20s|%-20c|%-20d|%-20f|%-20f\n", pirata.nome, pirata.soprannome,
                    pirata.ruolo, pirata.sesso,
                    pirata.eta, pirata.altezza, pirata.taglia);
        }
        System.out.println("NAVI");
        for (Nave nave : navi) {
            System.out.printf("%-20s|%-20s\n", nave.nome, nave.tipo);
        }
    }

    public void stampaMale(String path) {
        List<Pirata> malePirati = new ArrayList<>();
        for (Pirata pirata : pirati) {
            if (pirata.sesso == 'M')
                malePirati.add(pirata);
        }
        stampaSuFile(path, malePirati);

    }

    public void stampaOrdinato(String path, boolean crescente) {
        Collections.sort(pirati);
        if (!crescente)
            Collections.reverse(pirati);
        stampaSuFile(path, pirati);

        // TreeMap<Double, String> bigbounty = new TreeMap<>();
        // for (Pirata pirata : pirati) {
        //     bigbounty.put(pirata.taglia, pirata.nome);
        // }
        // for (double taglia : bigbounty.descendingKeySet()) {
        //     System.out.println(bigbounty.get(taglia) + " " + taglia);
        // }
    }

    private void stampaSuFile(String path, List<Pirata> lista) {
        FileWriter fw;
        PrintWriter pw;
        try {
            fw = new FileWriter(path);
            pw = new PrintWriter(fw);

            for (Pirata pirata : pirati) {
                pw.println(pirata);
            }
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}