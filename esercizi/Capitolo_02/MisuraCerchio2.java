import java.util.Scanner;

/** 
Programma che calcola l'area di un cerchio.
*/
public class MisuraCerchio2 {

    public static final double PI = 3.14159;

    public static void main(String[] args) {
        double raggio; //in metri
        double area;   //in metri quadri
        Scanner tastiera = new Scanner(System.in);

        System.out.println("Scrivi il raggio del cerchio in metri:");
        raggio = tastiera.nextDouble();
        area = PI * raggio * raggio;
        System.out.println("Un cerchio di raggio " + raggio + " metri");
        System.out.println("ha un area di " + area + " metri quadri.");
        tastiera.close();
   }
}
