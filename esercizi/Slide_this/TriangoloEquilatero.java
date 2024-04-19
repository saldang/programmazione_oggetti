public class TriangoloEquilatero {
    double base;
    double altezza;
    double lato;

    public TriangoloEquilatero(double base, double altezza, double lato) {
        this.base = base;
        this.altezza = altezza;
        this.lato = lato;
    }

    public double calcolaPerimetro() {
        return lato * 3;
    }

    public double calcolaArea() {
        return (base * altezza) / 2;
    }
}