import Capitolo10.Persona;

class Veicolo {
    private String casaAutomobilistica;
    private int n_cilindri;
    private Persona proprietario;

    public Veicolo(String casaAutomobilistica, int n_cilindri, Persona proprietario) {
        this.casaAutomobilistica = casaAutomobilistica;
        this.n_cilindri = n_cilindri;
        this.proprietario = proprietario;
    }

    public String getCasaAutomobilistica() {
        return casaAutomobilistica;
    }

    public int getN_cilindri() {
        return n_cilindri;
    }

    public Persona getProprietario() {
        return proprietario;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return proprietario.getNome()+" "+casaAutomobilistica+" "+n_cilindri;
    }

}
