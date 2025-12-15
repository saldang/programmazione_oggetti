public abstract class Libro implements Prestabile, Valutabile {
    protected String isbn;
    protected String titolo;
    protected String autore;
    protected int anno;
    protected boolean disponibile;

    public Libro(String isbn, String titolo, String autore, int anno, boolean disponibile) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.autore = autore;
        this.anno = anno;
        this.disponibile = disponibile;
    }

    abstract String visualizzaDettagli();
}
