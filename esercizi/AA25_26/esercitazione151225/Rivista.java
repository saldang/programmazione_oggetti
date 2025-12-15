public class Rivista extends Libro {
    private String periodicita;
    private int numeroEdizione;
    private String mese;
    private boolean conAllegato = false;

    private final int durataPrestito = 7;


    private final double penale = 0.30;

    public Rivista(String isbn, String titolo, String autore, int anno, boolean disponibile, String periodicita,
            int numeroEdizione, String mese, boolean conAllegato) {
        super(isbn, titolo, autore, anno, disponibile);
        this.periodicita = periodicita;
        this.numeroEdizione = numeroEdizione;
        this.mese = mese;
        this.conAllegato = conAllegato;
    }

    public Rivista(String isbn, String titolo, String autore, int anno, boolean disponibile, String periodicita,
            int numeroEdizione, String mese) {
        super(isbn, titolo, autore, anno, disponibile);
        this.periodicita = periodicita;
        this.numeroEdizione = numeroEdizione;
        this.mese = mese;
    }

    @Override
    public void presta() {
        disponibile = false;
        System.out.println("Prestato:");
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

        return ((conAllegato) ? (penale * giorniRitardo * 1.2) : (penale * giorniRitardo));
    }

    @Override
    String visualizzaDettagli() {
        return "Rivista: " + titolo + "," + autore + "," + anno + "," + periodicita + "," + numeroEdizione + "," + mese
                + "," + isbn + ","
                + ((conAllegato) ? "con Allegato" : "") + "," + ((disponibile) ? "Disponibile" : "Prestato.");
    }

    public int getDurataPrestito() {
        return durataPrestito;
    }
}
