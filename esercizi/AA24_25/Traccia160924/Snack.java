public class Snack extends Articolo{
    public String dataScadenza;

    public Snack(String codice, String nome, double prezzo, int quantita, String dataScadenza) {
        super(codice, nome, prezzo, quantita);
        this.dataScadenza = dataScadenza;
    }

    @Override
    public String toString() {
        return "Snack,"+super.toString()+","+dataScadenza;
    }

    
}
