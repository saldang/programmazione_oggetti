package this_ex;

public class Cerchio {
    double raggio;
    double area;
    double circonferenza;

    public Cerchio() {
        this(3.14);
    }

    public Cerchio(double raggio) {
        this.raggio = raggio;
    }

    double calcolaArea() {
        double area = 0;
        area = Math.PI * Math.pow(raggio, 2);
        this.area = area;
        return this.area;
    }

    double calcolaPerimentro() {
        circonferenza = 2 * Math.PI * raggio;
        return this.circonferenza;
    }
}
