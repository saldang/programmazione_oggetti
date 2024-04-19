import java.util.Vector;

public class BubbleSortDemo {
	public static void main(String[] args) {
		Vector v1 = new Vector();
		v1.add("Aaa");
		v1.add("Ccc");
		v1.add("Bbb");
		BubbleSort.sort(v1);
		System.out.println(v1);

		Vector v2 = new Vector();
		v2.add("Array");
		v2.add("InsiemiHash");
		v2.add("Vettori");
		v2.add("Mappe");
		v2.add("Collezioni");
		v2.add("MappeHash");
		v2.add("Arance");
		BubbleSort.sort(v2);
		System.out.println(v2);
	}
}
