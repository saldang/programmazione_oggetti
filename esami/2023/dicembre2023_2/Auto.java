public class Auto extends Veicolo {

    int numeroPorte;
    double prezzoNoleggio;
    double prezzoVendita;

    public Auto(String marca, String modello, int numeroPorte, double prezzoNoleggio, double prezzoVendita) {
        super(marca, modello);
        this.numeroPorte = numeroPorte;
        this.prezzoNoleggio = prezzoNoleggio;
        this.prezzoVendita = prezzoVendita;
    }

    @Override
    public String descrizione() {
        return super.descrizione() + "," + numeroPorte + "," + prezzoNoleggio + "," + prezzoVendita;
    }
}
