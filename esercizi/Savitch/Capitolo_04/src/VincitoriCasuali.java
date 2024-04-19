public class VincitoriCasuali {
	public static void main(String[] args) {
		// In amniera casuake seleziona 3 numeri fino a che sotto diversi fra loro
		int n1, n2, n3;
		do {
			n1 = (int) (Math.random() * 10) + 1;
			n2 = (int) (Math.random() * 10) + 1;
			n3 = (int) (Math.random() * 10) + 1;
		} while ((n1 == n2) || (n1 == n3) || (n2 == n3));
		System.out.println("I numeri fortunati sono " + n1 + ", " + n2 + ", e " + n3 + "!");
	}
}
