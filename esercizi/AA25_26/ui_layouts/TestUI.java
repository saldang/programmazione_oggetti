import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestUI extends JFrame {

    JLabel labelNome = new JLabel("Nome");
    JTextField fieldNome = new JTextField();
    JLabel labelCognome = new JLabel("Cognome");
    JTextField fieldCognome = new JTextField();

    JButton b1 = new JButton("Bottone 1");
    JButton b2 = new JButton("Bottone 2");
    JButton b3 = new JButton("Bottone 3");

    JPanel nuovoContatto = new JPanel();
    JPanel infoContatto = new JPanel();
    JPanel azioni = new JPanel();

    public TestUI(String title) {
        super(title);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        nuovoContatto.setName("Nuovo Contatto");
        setContentPane(nuovoContatto);
        nuovoContatto.setLayout(new BoxLayout(nuovoContatto, BoxLayout.Y_AXIS));
        infoContatto.setLayout(new BoxLayout(infoContatto, BoxLayout.X_AXIS));

        infoContatto.add(labelNome);
        infoContatto.add(fieldNome);
        infoContatto.add(labelCognome);
        infoContatto.add(fieldCognome);

        azioni.add(b1);
        azioni.add(b2);
        azioni.add(b3);

        nuovoContatto.add(infoContatto);
        nuovoContatto.add(azioni);
    }

    public static void main(String[] args) {
        TestUI testFrame = new TestUI("Test");
        testFrame.setVisible(true);

    }

}
