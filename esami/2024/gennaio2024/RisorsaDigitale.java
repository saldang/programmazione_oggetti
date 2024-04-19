abstract class RisorsaDigitale {
    private String titolo;
    private String autore;
    private String annoPubblicazioneString;

    public RisorsaDigitale(String titolo2, String autore2, String annoPubblicazioneString2) {
        this.titolo = titolo2;
        this.autore = autore2;
        this.annoPubblicazioneString = annoPubblicazioneString2;
    }

    abstract public String mostraDettagli();

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getAnnoPubblicazioneString() {
        return annoPubblicazioneString;
    }

    public void setAnnoPubblicazioneString(String annoPubblicazioneString) {
        this.annoPubblicazioneString = annoPubblicazioneString;
    }
}
