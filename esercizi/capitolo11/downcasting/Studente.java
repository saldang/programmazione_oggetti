package downcasting;
public class Studente extends Persona {
    int matricola;

    Studente(String nome, String cognome, int matricola) {
        super(nome, cognome);
        this.matricola = matricola;
    }

    public void studio(){
        System.out.println("Sto studiando");
    }
}