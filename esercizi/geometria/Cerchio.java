package geometria;

class Cerchio {
    double raggio;

    protected Cerchio(double raggio) {
        this.raggio = raggio;
    }

    protected double calcolaPerimetro() {
        return 2 * Math.PI * raggio;
    }

    protected double calcolaArea() {
        return 2 * Math.PI * Math.pow(raggio, 2);
    }
}
