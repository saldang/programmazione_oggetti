package geometria;


public class TestGeometria {
 public static void main(String[] args) {
        int[] arr = new int[5];

        Cerchio c = new Cerchio(3.5);
        Triangolo t = new Triangolo(10, 7);

        System.out.println("Perimetro e area del Cerchio:");
        System.out.println(c.calcolaPerimetro()+ " " + c.calcolaArea());
        System.out.println("Perimetro e area del Triangolo:");
        System.out.println(t.calcolaPerimetro()+ " " + t.calcolaArea());
        System.out.println(arr);
    }
}
