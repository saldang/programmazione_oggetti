import java.util.Scanner;

public class GradeTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean c = true;
        while (c) {
            System.out.println("Scrivi il voto da A a F da convertire. Premi Q per uscire");
            String input = in.next();
            Grade voto1 = new Grade();
            voto1.setVoto(input);
            if (input.equalsIgnoreCase("Q"))
                c = false;
            else
                System.out.println(voto1.getNumericGrade());
        }
    }
}
