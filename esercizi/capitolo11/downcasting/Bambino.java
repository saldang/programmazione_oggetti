package downcasting;
public class Bambino extends Persona{
    String giocattolo;

    public Bambino(String nome, String cognome, String giocattolo) {
        super(nome, cognome);
        this.giocattolo = giocattolo;
    };

    public void gioca(){
        System.out.println("Sto giocando con il "+giocattolo);
    }
    
}
