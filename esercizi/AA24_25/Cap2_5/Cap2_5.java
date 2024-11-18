import java.util.Scanner;

public class Cap2_5 {

    public static void main(String[] args) {

        Scanner tastiera = new Scanner(System.in);
        int eta;
        String nome;

        System.out.println("Digita la tua eta'.");

        eta = tastiera.nextInt();// \n

        System.out.println("Digita il tuo nome completo.");

        nome = tastiera.next(); // sostituire nextline con next

        nome = nome.toUpperCase(); // assegnare il ritorno del metodo toUpperCase ad una stringa

        System.out.println("Il tuo nome in maiuscolo e' " + nome + " e hai " + eta + " anni.");

    }

}