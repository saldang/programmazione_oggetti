package downcasting;
public class Persona {
    String nome;
    String cognome;

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public void miPresento(){
        System.out.println("Sono "+nome+" "+cognome);
    }
}
