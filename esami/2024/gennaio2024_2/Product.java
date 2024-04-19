/**
 * Product
 */
public class Product {

    String modello;
    String marca;
    String colore;
    int prezzo;
    int peso;

    public Product(String modello, String marca, String colore, int prezzo, int peso) {
        this.modello = modello;
        this.marca = marca;
        this.colore = colore;
        this.prezzo = prezzo;
        this.peso = peso;
    }

    public String scriviDettagli(){
        return modello+","+marca+","+prezzo+","+colore+","+peso;
    }

}