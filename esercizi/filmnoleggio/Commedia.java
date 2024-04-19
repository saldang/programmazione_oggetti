package filmnoleggio;

/**
 * Commedia
 */
public class Commedia extends Film {

    protected Commedia(int id, String titolo) {
        super(id, titolo);
    }

    @Override
    public double calcolaPenaleRitardo(int giorniDiRitardo) {
        return 2.50 * giorniDiRitardo;
    }

}
