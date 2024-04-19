package filmnoleggio;

/**
 * FilmTest
 */
public class FilmTest {

    public static void main(String[] args) {
        Azione dieHard = new Azione(1, "Die Hard");
        Commedia americanPie = new Commedia(2, "American Pie");
        Dramma viaColVento = new Dramma(3, "Via col vento");
        Azione dieHard2 = new Azione(1, "Die Hard, second copy");

        System.out.println("Stai restituendo il film:" + dieHard.getTitolo()
                + " con 3 giorni di ritardo. La penale da pagare e':" + dieHard.calcolaPenaleRitardo(3));
        System.out.println("Stai restituendo il film:" + americanPie.getTitolo()
                + " con 3 giorni di ritardo. La penale da pagare e':" + americanPie.calcolaPenaleRitardo(3));
        System.out.println("Stai restituendo il film:" + viaColVento.getTitolo()
                + " con 3 giorni di ritardo. La penale da pagare e':" + viaColVento.calcolaPenaleRitardo(3));
        System.out.println("Verifica film uguali:" + dieHard.equals(dieHard2));
    }
}
