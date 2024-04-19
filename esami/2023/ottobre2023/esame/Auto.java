package esame;
public class Auto extends Veicolo implements Comparable<Auto> {

    String modello;

    public Auto(String targa, String marca, String modello) {
        super(targa, marca);
        this.modello = modello;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        if (modello != null && modello.length() > 0) {
            this.modello = modello;
        }
    }

    @Override
    public String toString() {
        return "Auto [modello=" + modello + ", targa=" + targa + ", marca=" + marca + "]";
    }

    @Override
    public int compareTo(Auto o) {
        return this.modello.compareTo(o.modello);
    }
}
