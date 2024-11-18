public class CameraNormale extends Camera{

    CameraNormale(int numero, double prezzo, String stato){
        super(numero, prezzo,stato);
    }
    @Override
    public void info(){
        super.info();
        System.out.println("Tipo: Normale");
    }
}
