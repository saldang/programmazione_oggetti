import java.io.Serializable;

public class Studente implements Serializable {
    int id;
    String nome;
    String cognome;
    double mediaVoti;

    public Studente(int id, String nome, String cognome, double mediaVoti) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.mediaVoti = mediaVoti;
    }

    @Override
    public String toString() {
        return "Studente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", mediaVoti=" + mediaVoti + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Studente other = (Studente) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
