public abstract class Piatto {
    String nome;
    String descrizione;
    double prezzoBase;
    int tempoPreparazione; // in minuti
    int codice; // codice univoco del piatto

    abstract double calcolaPrezzoFinale();

    abstract void getInfoNutrizionali();

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public double getPrezzoBase() {
        return prezzoBase;
    }

    public int getTempoPreparazione() {
        return tempoPreparazione;
    }

    public int getCodice() {
        return codice;
    }
}
