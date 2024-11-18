import javax.swing.JOptionPane;


public class InputTest {

    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("What is your name?");
        int age  = Integer.parseInt(JOptionPane.showInputDialog("How old are you?"));
        System.out.print("Hello, " + name + ". ");
        System.out.println("Next year, you'll be " + (age + 1));
        System.exit(0);
    }
    
}