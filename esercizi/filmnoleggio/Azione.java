package filmnoleggio;

/**
 * Azione
 */
public class Azione extends Film {

    public Azione(int id, String titolo) {
        super(id, titolo);
    }

    @Override
    public double calcolaPenaleRitardo(int giorniDiRitardo) {

        return 3.00 * giorniDiRitardo;
    }

}
