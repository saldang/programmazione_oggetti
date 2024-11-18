public class Serpente extends Alieno {
    public Serpente(String nome, int salute) {
        super(salute, nome);
    }

    @Override
    public int getDanno() {
        return 10;
    }

    public int bite() {
        return 20;
    }

    @Override
    public String toString() {
        return "Serpente " + getNome() + " Salute:" + getSalute();
    }
}
