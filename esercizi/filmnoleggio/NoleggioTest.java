package filmnoleggio;

import java.util.ArrayList;

/**
 * NoleggioTest
 */
public class NoleggioTest {

    // public double calcolaPenaliRitardo(Noleggio[] noleggi) {
    public double calcolaPenaliRitardo(ArrayList<Noleggio> noleggi) {
        double totalePenali = 0;

        for (Noleggio noleggio : noleggi) {
            // for (int i = 0; i < noleggi.length; i++) {
            // totalePenali += noleggi[i].calcolaPenaleRitardo();
            // noleggi.indexOf(noleggio);

            totalePenali += noleggio.calcolaPenaleRitardo();
        }
        return totalePenali;
    }

    public static void main(String[] args) {
        Azione dieHard = new Azione(1, "Die Hard");
        Commedia americanPie = new Commedia(2, "American Pie");
        Dramma viaColVento = new Dramma(3, "Via col vento");
        ArrayList<Noleggio> noleggi = new ArrayList<>();
        noleggi.add(new Noleggio(viaColVento, 0, 3));
        noleggi.add(new Noleggio(americanPie, 0, 3));
        noleggi.add(new Noleggio(dieHard, 0, 3));

        // Noleggio[] noleggi = new Noleggio[] {
        // new Noleggio(viaColVento, 0, 3),
        // new Noleggio(americanPie, 0, 2),
        // new Noleggio(dieHard, 0, 3),
        // };

      
        NoleggioTest nt = new NoleggioTest();
        System.out.println("Totale penali da pagare:" + nt.calcolaPenaliRitardo(noleggi));

    }
}
