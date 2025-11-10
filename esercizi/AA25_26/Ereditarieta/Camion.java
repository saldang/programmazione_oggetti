import Capitolo10.Persona;

public class Camion extends Veicolo {
    private double capacitaCarico;
    private double capacitaRimorchio;

    public Camion(String casaAutomobilistica, int n_cilindri, Persona proprietario, double capacitaCarico,
            double capacitaRimorchio) {
        super(casaAutomobilistica, n_cilindri, proprietario);
        this.capacitaCarico = capacitaCarico;
        this.capacitaRimorchio = capacitaRimorchio;
    }

    public double getCapacitaCarico() {
        return capacitaCarico;
    }

    public void setCapacitaCarico(double capacitaCarico) {
        this.capacitaCarico = capacitaCarico;
    }

    public double getCapacitaRimorchio() {
        return capacitaRimorchio;
    }

    public void setCapacitaRimorchio(double capacitaRimorchio) {
        this.capacitaRimorchio = capacitaRimorchio;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Camion)
            return equals(obj);
        else
            System.out.println("non e' un oggetto camion");
        return false;
    }

    public boolean equals(Camion c2) {
        return this.capacitaCarico == c2.capacitaCarico && this.capacitaRimorchio == c2.capacitaRimorchio;
    }

    @Override
    public String toString() {
        return super.toString() + " " + capacitaCarico + " " + capacitaRimorchio;
    }
}
