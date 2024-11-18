public class UomoMarshmellow extends Alieno {

    UomoMarshmellow(String nome, int salute) {
        super(salute, nome);
    }

    @Override
    public int getDanno() {
        return 1;
    }

    @Override
    public String toString() {
        return "Uomo Marshmellow " + getNome() + " Salute:" + getSalute();
    }
}
