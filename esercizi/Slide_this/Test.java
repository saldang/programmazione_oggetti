public class Test {
    public static void main(String[] args) {
        TriangoloEquilatero t = new TriangoloEquilatero(3, 4, 5);
        Cerchio c = new Cerchio(3);
        System.out.println("Perimetro triangolo: " + t.calcolaPerimetro());
        System.out.println("Area triangolo: " + t.calcolaArea());
        c = c.calcolaArea();
        c = c.calcolaPerimetro();
        System.out.println("Perimetro cerchio: " + c.getPerimetro());
        System.out.println("Area cerchio: " + c.getArea());
    }
}
