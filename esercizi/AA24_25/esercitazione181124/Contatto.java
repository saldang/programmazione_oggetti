public class Contatto {

    String nome;
    String cognome;
    String numeroTelefono;

    public Contatto(String nome, String cognome, String numeroTelefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public String toString() {
        return nome + ";" + cognome + ";" + numeroTelefono;
    }

    @Override
    public boolean equals(Object o) {
        if (((Contatto) o).nome.equalsIgnoreCase(nome) &&
                ((Contatto) o).cognome.equalsIgnoreCase(cognome) &&
                ((Contatto) o).numeroTelefono.equalsIgnoreCase(numeroTelefono))
            return true;
        else
            return false;
    }

}