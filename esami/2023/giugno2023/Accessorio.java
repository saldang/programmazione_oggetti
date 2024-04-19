public class Accessorio extends Prodotto{

    String colore;

    public Accessorio(String codice, String descrizione, double prezzo, String colore) {
        super(codice, descrizione, prezzo);
        this.colore = colore;
    }

    @Override
    public String toString() {
        return super.toString()+","+colore;
    }
    
}
