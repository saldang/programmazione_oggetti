public class Antipasto extends Piatto implements Ordinabile {
    String porzione;
    boolean vegetariano;

    public Antipasto(String nome, String descrizione, double prezzoBase, int tempoPreparazione, int codice,
            String porzione, boolean vegetariano) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzoBase = prezzoBase;
        this.tempoPreparazione = tempoPreparazione;
        this.codice = codice;
        this.porzione = porzione;
        this.vegetariano = vegetariano;
    }

    @Override
    double calcolaPrezzoFinale() {
        double prezzoFinale = prezzoBase;
        switch (porzione.toLowerCase()) {
            case "small":
                prezzoBase *= 0.8;
                break;
            case "medium":
                prezzoBase *= 1.0;
                break;
            case "large":
                prezzoBase *= 1.3;
                break;
            default:
                break;
        }
        return prezzoFinale;
    }

    @Override
    void getInfoNutrizionali() {
        System.out.println("Informazioni nutrizionali per " + nome + ":");
        System.out.println("Porzione: " + porzione);
        System.out.println("Vegetariano: " + (vegetariano ? "Sì" : "No"));
    }

    @Override
    public double aggiungiAllOrdine(int numeroTavolo, int quantita) {
        return getTempoTotale(quantita);
    }

    @Override
    public boolean rimuoviDallOrdine(int numeroTavolo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rimuoviDallOrdine'");
    }

    @Override
    public boolean getDisponibilita() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDisponibilita'");
    }

    @Override
    public int getTempoTotale(int quantita) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTempoTotale'");
    }
}
