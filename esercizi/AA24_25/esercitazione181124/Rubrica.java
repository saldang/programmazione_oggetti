import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Rubrica {
    ArrayList<Contatto> contatti;

    public Rubrica() {
        contatti = new ArrayList<>();
    }

    public void aggiungiContatto(String infoContatto) throws ContattoDuplicatoException {
        Contatto newContatto = leggiContatto(infoContatto);
        if (contatti.contains(newContatto)) {
            throw new ContattoDuplicatoException("Contatto gia' presente in rubrica!");
        }
        contatti.add(leggiContatto(infoContatto));
    }

    public void stampaContatti(){
        for (Contatto contatto : contatti) {
            System.out.println(contatto);
        }
    }

    public void salvaSuFile(String path) {
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(path);
            pw = new PrintWriter(fw);
            for (Contatto contatto : contatti) {
                pw.println(contatto);
            }
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }

    public void leggiDaFile(String path) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                try {
                    aggiungiContatto(line);
                } catch (ContattoDuplicatoException e) {
                    System.out.println(e.getMessage());
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    private Contatto leggiContatto(String infoContatto) {
        String[] info = infoContatto.split(";");
        return new Contatto(info[0], info[1], info[2]);
    }
}
