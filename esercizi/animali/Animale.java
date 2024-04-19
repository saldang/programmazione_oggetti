package animali;

/**
 * Animale
 */
public class Animale implements Comparable<Animale> {

    String nome;
    int eta;
    int peso;

    public Animale(String nome, int eta, int peso) {
        this.nome = nome;
        this.eta = eta;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + eta;
        result = prime * result + peso;
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
        Animale other = (Animale) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (eta != other.eta)
            return false;
        if (peso != other.peso)
            return false;
        return true;
    }

    @Override
    public int compareTo(Animale altroAnimale) {
        if (nome.compareToIgnoreCase(altroAnimale.nome) > 0)
            return 1;
        else if (nome.compareToIgnoreCase(altroAnimale.nome) < 0)
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "Animale [nome=" + nome + ", eta=" + eta + ", peso=" + peso + "]";
    }

}
