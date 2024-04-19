public class Farmaco extends Prodotto{
    String categoria;

    public Farmaco(int codice, String nome, double prezzo, int quantita, String categoria) {
        super(codice, nome, prezzo, quantita);
        this.categoria = categoria;
    }


}
