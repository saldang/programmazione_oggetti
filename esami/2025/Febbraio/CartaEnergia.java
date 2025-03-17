public class CartaEnergia extends Carta {
    private String tipo;

    public CartaEnergia(String nome, String descrizione, String tipo) {
        super(nome, descrizione);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
