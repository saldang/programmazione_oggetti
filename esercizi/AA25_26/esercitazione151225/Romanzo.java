public class Romanzo extends Libro {
    private String genere;
    private int numeroPagine;
    private boolean saga = false;

    private final int durataPrestito = 21;

    private final double penale = 0.50;

    public Romanzo(String isbn, String titolo, String autore, int anno, boolean disponibile, String genere,
            int numeroPagine) {
        super(isbn, titolo, autore, anno, disponibile);
        this.genere = genere;
        this.numeroPagine = numeroPagine;
    }

    public Romanzo(String isbn, String titolo, String autore, int anno, boolean disponibile, String genere,
            int numeroPagine, boolean saga) {
        super(isbn, titolo, autore, anno, disponibile);
        this.genere = genere;
        this.numeroPagine = numeroPagine;
        this.saga = saga;
    }

    @Override
    public void presta() {
        disponibile = false;
        System.out.println("Preso in prestito:");
        System.out.println(this.visualizzaDettagli());
    }

    @Override
    public void restituisci() {
        disponibile = true;
        System.out.println("Restituito:");
        System.out.println(this.visualizzaDettagli());

    }

    @Override
    public boolean isDisponibile() {
        return disponibile;
    }

    @Override
    public double calcolaPenale(int giorniRitardo) {
        return giorniRitardo * penale;
    }

    @Override
    String visualizzaDettagli() {
        return "Romanzo: " + titolo + "," + autore + "," + anno + "," + genere + "," + numeroPagine + "," + isbn + ","
                + ((saga) ? "Saga" : "Singolo") + "," + ((disponibile) ? "Disponibile" : "Prestato.");
    }

    public int getDurataPrestito() {
        return durataPrestito;
    }
}
