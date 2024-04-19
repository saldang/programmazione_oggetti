public class Pirata implements Comparable<Pirata> {
    private String nomeOriginale;
    private String soprannome;
    private String ruolo;
    private String sesso;
    private int eta;
    private int altezza;
    private double taglia;

    public Pirata(String nomeOriginale, String soprannome, String ruolo, String sesso, int eta, int altezza,
            double taglia) {
        this.nomeOriginale = nomeOriginale;
        this.soprannome = soprannome;
        this.ruolo = ruolo;
        this.sesso = sesso;
        this.eta = eta;
        this.altezza = altezza;
        this.taglia = taglia;
    }

    public String getNomeOriginale() {
        return nomeOriginale;
    }

    public void setNomeOriginale(String nomeOriginale) {
        this.nomeOriginale = nomeOriginale;
    }

    public String getSoprannome() {
        return soprannome;
    }

    public void setSoprannome(String soprannome) {
        this.soprannome = soprannome;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    public double getTaglia() {
        return taglia;
    }

    public void setTaglia(double taglia) {
        this.taglia = taglia;
    }

    @Override
    public String toString() {
        return nomeOriginale + "," + soprannome + "," + ruolo + "," +
                sesso + "," + eta + "," + altezza + "," + taglia;
    }

    @Override
    public int compareTo(Pirata arg0) {
        if (this.taglia > arg0.taglia)
            return -1;
        else if (this.taglia < arg0.taglia)
            return 1;
        else
            return 0;
    }

}
