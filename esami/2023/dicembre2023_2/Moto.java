public class Moto extends Veicolo {
    int cilindrata;
    double prezzoNoleggio;
    double prezzoVendita;

    public Moto(String marca, String modello, int cilindrata, double prezzoNoleggio, double prezzoVendita) {
        super(marca, modello);
        this.cilindrata = cilindrata;
        this.prezzoNoleggio = prezzoNoleggio;
        this.prezzoVendita = prezzoVendita;
    }

    @Override
    public String descrizione() {

        return super.descrizione() + "," + cilindrata + "," + prezzoNoleggio + "," + prezzoVendita;
    }

}
