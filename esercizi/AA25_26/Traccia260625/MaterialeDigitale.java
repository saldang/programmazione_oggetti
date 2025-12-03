public class MaterialeDigitale extends Materiale {
    String formato;
    double dimensione;
    boolean drm;

    public MaterialeDigitale(String codice, String titolo, int annoPubblicazione, String genere, double prezzo,
            String formato, double dimensione, boolean drm) {
        super(codice, titolo, annoPubblicazione, genere, prezzo);
        this.formato = formato;
        this.dimensione = dimensione;
        this.drm = drm;
    }

    @Override
    public String toString() {
        return "MaterialeDigitale," + super.toString() + ",,,," + this.formato + "," + this.dimensione + "," + this.drm;
    }

}
