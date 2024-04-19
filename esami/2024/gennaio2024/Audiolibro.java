public class Audiolibro extends RisorsaDigitale {
    private int durata;

    public Audiolibro(String titolo, String autore, String annoPubblicazioneString, int durata) {
        super(titolo, autore, annoPubblicazioneString);
        this.durata = durata;
    }

    @Override
    public String mostraDettagli() {
        return "Audiolibro," + getTitolo() + "," + getAutore() + "," + getAnnoPubblicazioneString() + ",," + durata;
    }
}
