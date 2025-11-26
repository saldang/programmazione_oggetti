import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TestIO {

    public static void main(String[] args) {
        File cartella1 = new File("test_folder");
        File index = new File("index.md");
        File testIO = new File("/Users/saldang/Developments/programmazione_oggetti/esercizi/AA25_26/JavaIO");

        if (!cartella1.exists()) {
            System.out.println("Cartella non eseistente...creazione in corso...");
            cartella1.mkdir();
        } else {
            if (cartella1.list().length != 0) {

                for (String string : cartella1.list()) {
                    System.out.println(string);
                    File test = new File(cartella1, string);
                    System.out.println(test.canRead());
                    System.out.println(test.canExecute());
                    System.out.println(test.canWrite());
                    System.out.println(test.getAbsolutePath());
                    System.out.println(test.lastModified());

                    LocalDateTime lastMod = LocalDateTime.ofInstant(Instant.ofEpochMilli(test.lastModified()),
                            ZoneOffset.UTC);
                    System.out.println(lastMod);

                }
            } else {
                System.out.println("La cartella esiste ma e' vuota");
                File testFile = new File(cartella1, "test.txt");
                try {
                    testFile.createNewFile();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        try {
            index.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(index.length());

        for (String string : testIO.list()) {

            System.out.println(string);
        }
    }
}
