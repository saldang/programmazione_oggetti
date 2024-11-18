package this_ex;

public class Test {
    public static void main(String[] args) {
        Triangolo t1 = new Triangolo();
        Triangolo t2 = new Triangolo(3, 4, 5, 4);
        Cerchio c1 = new Cerchio();
        Cerchio c2 = new Cerchio(3.14);

        System.out.println(t1.calcolaArea());
        System.out.println(t1.calcolaPerimentro());
        System.out.println(t2.calcolaArea());
        System.out.println(t2.calcolaPerimentro());
        System.out.println(c1.calcolaArea());
        System.out.println(c1.calcolaPerimentro());
        System.out.println(c2.calcolaArea());
        System.out.println(c2.calcolaPerimentro());
    }
}
