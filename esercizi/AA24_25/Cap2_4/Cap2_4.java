import java.util.Scanner;

/**
 * Cap2_3
 */
public class Cap2_4 {

    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        System.out.println("Inserisci un intero(string):");
        String input = tastiera.next();

        for (int i = 0; i < input.length(); i++)
            System.out.println(input.charAt(i));

        System.out.println("Inserisci un intero:");

        int res;
        int num = tastiera.nextInt();
        int mod = 10;
        int count = 0;
        res = num;
        while (res != 0) {
            res = res / mod;
            count++;
        }

        mod = (int) Math.pow(mod, count - 1);
        for (int i = 0; i < count; i++) {
            System.out.println((num / mod));
            num = num % mod;
            mod /= 10;

        }

    }
}