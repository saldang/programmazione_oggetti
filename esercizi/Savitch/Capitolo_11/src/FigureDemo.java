public class FigureDemo {
	public static final int scostamento = 3;
	public static final int latoTriangolo = 21;
	public static final int lado = 5;
	public static final int basso = 10;

	public static void main(String[] args) {
		TriangoloRettangolo t1 = new TriangoloRettangolo(scostamento, latoTriangolo);
		Rettangolo r1 = new Rettangolo(scostamento, lado, basso);
		Quadrato2 s1 = new Quadrato2(scostamento, lado);

		t1.disegnaDa(1);
		System.out.println();
		System.out.println("Area del triangolo = " + t1.area());
		System.out.println();
		System.out.println("Perimetro del triangolo = " + t1.circumference());
		System.out.println();
		System.out.println("===============================");

		r1.disegnaDa(2);
		System.out.println("Area del rettangolo = " + r1.area());
		System.out.println();
		System.out.println("Perimetro del rettangolo = " + r1.perimetro());
		System.out.println();
		System.out.println("===============================");

		s1.disegnaDa(3);
		System.out.println("Area del quadrato = " + s1.area());
		System.out.println();
		System.out.println("Perimetro del quadrato = " + s1.perimetro());
		System.out.println();
		System.out.println("===============================");

	}
}
