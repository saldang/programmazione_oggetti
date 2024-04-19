package geometria;

public class Triangolo {
    float base;
    float latoA = 0;
    float latoB = 0;
    float altezza;

    public Triangolo(float base, float altezza) {
        this.altezza = altezza;
        this.base = base;
    }

    public Triangolo(float base, float latoA, float altezza) {
        this.altezza = altezza;
        this.base = base;
        this.latoA = latoA;
    }

    public Triangolo(float base, float latoA, float latoB, float altezza) {
        this.altezza = altezza;
        this.base = base;
        this.latoA = latoA;
        this.latoB = latoB;
    }

    public float calcolaPerimetro() {
        if (latoA != 0 && latoB != 0) {
            return latoA + latoB + base;
        } else if (latoB == 0) {
            return 2 * latoA + base;
        } else {
            return 3 * base;
        }
    }

    protected float calcolaArea() {
        return (base * altezza) / 2;
    }
}
