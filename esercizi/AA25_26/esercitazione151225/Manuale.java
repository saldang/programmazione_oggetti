public class Manuale extends Libro {
    private String argomento;
    private int edizione;
    private boolean universitario = true;

    private final int durataPrestito = 30;

    private final double penale = 1.0;

    public Manuale(String isbn, String titolo, String autore, int anno, boolean disponibile, String argomento,
            int edizione, boolean universitario) {
        super(isbn, titolo, autore, anno, disponibile);
        this.argomento = argomento;
        this.edizione = edizione;
        this.universitario = universitario;
    }

    public Manuale(String isbn, String titolo, String autore, int anno, boolean disponibile, String argomento,
            int edizione) {
        super(isbn, titolo, autore, anno, disponibile);
        this.argomento = argomento;
        this.edizione = edizione;
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

        return ((universitario) ? (penale * giorniRitardo * 1.5) : (penale * giorniRitardo));
    }

    @Override
    String visualizzaDettagli() {
        return "Manuale: " + titolo + "," + autore + "," + anno + "," + argomento + "," + edizione + "," + isbn + ","
                + ((universitario) ? "Universitario" : "") + "," + ((disponibile) ? "Disponibile" : "Prestato.");
    }

    public int getDurataPrestito() {
        return durataPrestito;
    }
}
