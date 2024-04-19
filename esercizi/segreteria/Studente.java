package segreteria;

public class Studente extends Persona {
    public int matricola;

    public Studente(int matricola, String nome, String cognome) {
        super(nome, cognome);
        this.matricola = matricola;

    }
    @Override
    public void stampa() {
        System.out.println("Studente: " + this.nome + " " + this.cognome + " " + this.matricola);
    }
    
    @Override
    public boolean equals(Object obj) {

        return super.equals(obj) && this.matricola == ((Studente) obj).matricola;
    }

    @Override
    public String toString() {
        return "Studente: Matr." + matricola + " " + nome + " " + cognome;

    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash = hash + matricola;
        System.out.println(matricola);
        hash = hash + (nome == null ? 0 : nome.hashCode());
        System.out.println(nome.hashCode());
        hash = hash + (cognome == null ? 0 : cognome.hashCode());
        System.out.println(cognome.hashCode());
        return hash;
    }

}
