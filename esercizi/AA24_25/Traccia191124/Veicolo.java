import java.io.Serializable;

public abstract class Veicolo implements Serializable {

    public String marca;
    public String modello;
    public int anno;
    public String colore;

    public Veicolo(String marca, String modello, int anno, String colore) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
        this.colore = colore;
    }

    public abstract void calcolaValoreMercato();

    public abstract String visualizzaInformazioniVeicolo();

    @Override
    public boolean equals(Object o) {
        Veicolo other = (Veicolo) o;
        if (marca.equalsIgnoreCase(other.marca) && modello.equalsIgnoreCase(other.modello))
            return true;
        else
            return false;
    }
}