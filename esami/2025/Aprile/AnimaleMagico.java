public abstract class AnimaleMagico implements PotereMagico {
    private String nome;
    private int eta;
    private double velocitaBase;

    public AnimaleMagico(String nome, int eta, double velocitaBase) {
        this.nome = nome;
        this.eta = eta;
        this.velocitaBase = velocitaBase;
    }

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    public double getVelocitaBase() {
        return velocitaBase;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public void setVelocitaBase(double velocitaBase) {
        this.velocitaBase = velocitaBase;
    }

    abstract double calcolaTempoPercorrenza(double distanza);

    String descrizione() {
        return "Nome: " + nome + ", Età: " + eta + ", Velocità Base: " + velocitaBase;
    }
}