public class Orco extends Alieno {

    Orco(String nome, int salute){
        super(salute, nome);
    }
    
    @Override
    public int getDanno(){
        return 6;
    }
    @Override
    public String toString() {
        return "Orco " + getNome() + " Salute:" + getSalute();
    }
}
