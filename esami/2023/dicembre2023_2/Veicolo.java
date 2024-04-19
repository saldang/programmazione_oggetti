/**
 * Veicolo
 */
public class Veicolo {

    String marca;
    String modello;
    
    public Veicolo(String marca, String modello) {
        this.marca = marca;
        this.modello = modello;
    }

    public String descrizione(){
        return marca+","+modello;
    }
}