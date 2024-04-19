public class Abbigliamento extends Prodotto {

    String taglia;
    String materiale;

    public Abbigliamento(String codice, String descrizione, double prezzo, String taglia, String materiale) {
        super(codice, descrizione, prezzo);
        this.taglia = taglia;
        this.materiale = materiale;
    }

    @Override
    public String toString() {
        return super.toString()+","+taglia+","+materiale;
    }
    

    
}
