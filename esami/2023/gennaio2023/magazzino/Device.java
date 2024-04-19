package magazzino;

public class Device {
    private String marca;
    private String modello;
    private double display;
    private String connessione;
    private int peso;
    private int codice;
    private int quantita;

    public Device(String marca, String modello, double display, String connessione, int peso, int codice) {
        this.marca = marca;
        this.modello = modello;
        this.display = display;
        this.connessione = connessione;
        this.peso = peso;
        this.codice = codice;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public double getDisplay() {
        return display;
    }

    public void setDisplay(double display) {
        this.display = display;
    }

    public String getConnessione() {
        return connessione;
    }

    public void setConnessione(String connessione) {
        this.connessione = connessione;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codice;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Device other = (Device) obj;
        if (codice != other.codice)
            return false;
        return true;
    }


}
