public class Fattura {
    private Paziente paziente;
    private Dottore dottore;

    public Fattura(Paziente paziente, Dottore dottore) {
        this.paziente = paziente;
        this.dottore = dottore;
    }

    public Paziente getPaziente() {
        return paziente;
    }

    public void setPaziente(Paziente paziente) {
        this.paziente = paziente;
    }

    public Dottore getDottore() {
        return dottore;
    }

    public void setDottore(Dottore dottore) {
        this.dottore = dottore;
    }

    public boolean equals(Fattura f) {
        if (this.dottore.equals(f.getDottore()))
            return true;
        else
            return false;
    }

}
