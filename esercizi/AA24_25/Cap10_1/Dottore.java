public class Dottore extends Persona {
    private String specializzazione;
    private Double parcella;

    public Dottore(String nomeIniziale, String specializzazione, Double parcella) {
        super(nomeIniziale);
        this.specializzazione = specializzazione;
        this.parcella = parcella;
    }

    public String getSpecializzazione() {
        return specializzazione;
    }

    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }

    public Double getParcella() {
        return parcella;
    }

    public void setParcella(Double parcella) {
        this.parcella = parcella;
    }

    public boolean equals(Dottore doc) {
        if (this.getNome().equals(doc.getNome()) && parcella == doc.getParcella()
                && specializzazione.equals(doc.getSpecializzazione()))
            return true;
        else
            return false;
    }
}
