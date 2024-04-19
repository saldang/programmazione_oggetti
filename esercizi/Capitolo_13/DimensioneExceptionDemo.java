
import java.util.*;

public class DimensioneExceptionDemo {
	public static int scostamento;
	public static int latoTriangolo;
	public static int lato;
	public static int basso;

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);

		char repeat;
		do { // Ripete se l'utente dice si
			try {
				System.out.println();
				System.out.println("Inserisci uno scostamento:");
				scostamento = tastiera.nextInt();
				if (scostamento < 0)
					throw new DimensioneException("scostamento", scostamento);
				System.out.println();
				System.out.println("Inserisci il lato del triangolo:");
				latoTriangolo = tastiera.nextInt();
				if (latoTriangolo <= 0)
					throw new DimensioneException("lato triangolo", latoTriangolo);
				System.out.println();
				System.out.println("Inserisci il lato del rettangolo e del quadrato:");
				lato = tastiera.nextInt();
				if (lato <= 0)
					throw new DimensioneException("lato", lato);
				System.out.println();
				System.out.println("Inserisci al base del rettangolo:");
				basso = tastiera.nextInt();
				if (basso <= 0)
					throw new DimensioneException("base", basso);

				TriangoloRettangolo t1 = new TriangoloRettangolo(scostamento, latoTriangolo);
				Rettangolo r1 = new Rettangolo(scostamento, lato, basso);
				Quadrato2 s1 = new Quadrato2(scostamento, lato);

				t1.disegnaDa(1);
				System.out.println();
				System.out.println("Area del triangolo = " + t1.area());
				System.out.println();
				System.out.println("Perimetro del triangolo = " + t1.circumference());
				System.out.println();
				System.out.println("================================");

				r1.disegnaDa(2);
				System.out.println("Area del rettangolo = " + r1.area());
				System.out.println();
				System.out.println("Perimetro del rettangolo = " + r1.perimetro());
				System.out.println();
				System.out.println("================================");

				s1.disegnaDa(3);
				System.out.println("Area del quadrato = " + s1.area());
				System.out.println();
				System.out.println("Perimetro del quadrato = " + s1.perimetro());
			} // end try

			catch (DimensioneException e) {
				System.out.println(e.getMessage());
			}

			System.out.println();
			System.out.println("Ancora? (s o S per si)");
			repeat = tastiera.next().charAt(0);

		} while ((repeat == 's') || (repeat == 'S'));
	}
}
