import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Registro {
    ArrayList<Studente> studenti;

    public Registro() {
        studenti = new ArrayList<>();
    }

    public void aggiungi(String infoStudente) throws StudenteDuplicatoException {
        String[] info = infoStudente.split(",");
        Studente newStudente = new Studente(Integer.parseInt(info[0]), info[1], info[2], Double.parseDouble(info[3]));
        if (studenti.contains(newStudente))
            throw new StudenteDuplicatoException("Studente gia presente nel registro");
        else
            studenti.add(newStudente);

    }

    public void aggiungi(Studente s) throws StudenteDuplicatoException {
        if (studenti.contains(s))
            throw new StudenteDuplicatoException("Studente gia presente nel registro");
        else
            studenti.add(s);
    }

    public void cerca(int iD) throws StudenteNonTrovatoException {
        for (Studente studente : studenti) {
            if (studente.id == iD) {
                System.out.println(studente);
            } else
                throw new StudenteNonTrovatoException("Studente non presente nel registro");

        }

    }

    public void visualizza() {
        for (Studente studente : studenti) {
            System.out.println(studente);
        }
    }

    public void salvaSuFileBin(String path) {
        ObjectOutputStream ow = null;
        FileOutputStream fs = null;
        try {
            fs = new FileOutputStream(path);
            ow = new ObjectOutputStream(fs);
            for (Studente studente : studenti) {
                ow.writeObject(studente);
            }
            ow.close();
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leggiDaFileBin(String path) {
        FileInputStream fs = null;
        ObjectInputStream or = null;

        try {
            fs = new FileInputStream(path);
            or = new ObjectInputStream(fs);
            while (true) {
                Studente newStud = (Studente) or.readObject();
                try {
                    System.out.println("Aggiunto studente: " + newStud);
                    aggiungi(newStud);
                } catch (StudenteDuplicatoException e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch (EOFException e) {
            System.out.println("File letto correttamente");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } finally {
            try {
                or.close();
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
