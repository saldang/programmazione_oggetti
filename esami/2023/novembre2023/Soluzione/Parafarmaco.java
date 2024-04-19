public class Parafarmaco extends Prodotto {
    String dataScadenza;

    public Parafarmaco(int codice, String nome, double prezzo, int quantita, String dataScadenza) {
        super(codice, nome, prezzo, quantita);
        this.dataScadenza = dataScadenza;
    }

    
}
