
import Capitolo09.Animale;

public class Cane extends Animale{
    String razza;
    boolean comandoDiRichiamo;

    public Cane(String nome, int eta, double peso, String razza, boolean comandoDiRichiamo){
        super(nome, eta, peso);
        this.razza = razza;
        this.comandoDiRichiamo = comandoDiRichiamo;
    }

    public String getRazza(){
        return razza;
    }

    public boolean getComandoDiRichiamo(){
        return comandoDiRichiamo;
    }

}
