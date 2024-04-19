package esame;
/**
 * Veicolo
 */
public class Veicolo {

    String targa;
    String marca;

    public Veicolo(String targa, String marca) {
        this.targa = targa;
        this.marca = marca;
    }

    public String getTarga() {
        return targa;
    }

    public String getMarca() {
        return marca;
    }
    
}