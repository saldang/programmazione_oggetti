public class Nave {
    String nome;
    String tipo;

    public Nave(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nome + "," + tipo;
    }

}
