package filmnoleggio;

/**
 * Dramma
 */
public class Dramma extends Film {

    protected Dramma(int id, String titolo) {
        super(id, titolo);
    }

    @Override
    public double calcolaPenaleRitardo(int giorniDiRitardo) {
        return 2.00 * giorniDiRitardo;
    }

}
