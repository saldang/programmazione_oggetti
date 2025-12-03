public class MaterialeCartaceo extends Materiale {
    String autore;
    int numeroPagine;
    String ISBN;

    public MaterialeCartaceo(String codice, String titolo, int annoPubblicazione, String genere, double prezzo,
            String autore, int numeroPagine, String ISBN) {
        super(codice, titolo, annoPubblicazione, genere, prezzo);
        this.autore = autore;
        this.numeroPagine = numeroPagine;
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "MaterialeCartaceo," + super.toString() + "," + this.autore + "," + this.numeroPagine + "," + this.ISBN
                + ",,,";
    }

}
