public class Libro extends RisorsaDigitale {
    private int numeroPagine;

    public Libro(String titolo, String autore, String annoPubblicazioneString, int numeroPagine) {
        super(titolo, autore, annoPubblicazioneString);
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String mostraDettagli() {
        return "Libro," + getTitolo() + "," + getAutore() + "," + getAnnoPubblicazioneString() + "," + numeroPagine
                + ",";
    }
}
