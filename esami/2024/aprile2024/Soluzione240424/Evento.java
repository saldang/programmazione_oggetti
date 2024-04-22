package Soluzione240424;

public class Evento {
    private String tipo;
    private String data;
    private String ora;

    public Evento(String tipo, String data, String ora) {
        this.tipo = tipo;
        this.data = data;
        this.ora = ora;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Evento [data=" + data + ", ora=" + ora + ", tipo=" + tipo + "]";
    }

}
