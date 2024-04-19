public class Cerchio {
    double raggio;
    private double perimetro;
    private double area;

    public Cerchio(double raggio) {
        this.raggio = raggio;
    }

    public Cerchio calcolaPerimetro() {
        perimetro = 2 * Math.PI * raggio;
        return this;
    }

    public Cerchio calcolaArea() {
        area = Math.PI * Math.pow(raggio, 2);
        return this;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public double getArea() {
        return area;
    }
}
