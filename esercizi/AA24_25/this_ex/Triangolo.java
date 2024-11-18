package this_ex;

public class Triangolo {
    double area;
    double perimetro;
    double latoA;
    double latoB;
    double latoC;
    double altezza;

    public Triangolo() {

        this(3, 4, 5, 4);
    }

    public Triangolo(double latoA, double latoB, double latoC, double altezza) {
        this.altezza = altezza;
        this.latoA = latoA;
        this.latoB = latoB;
        this.latoC = latoC;
    }

    double calcolaPerimentro() {
        this.perimetro=latoA+latoB*latoC;
        return this.perimetro;
    }

    double calcolaArea() {
        this.area=(latoB*altezza)/2;
        return this.area;
    }
}
