import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Catalogo implements GestioneDati {
    ArrayList<Materiale> materiali;

    public Catalogo() {
        materiali = new ArrayList<>();
    }

    public void addMateriale(Materiale m) {
        if (!materiali.contains(m))
            materiali.add(m);
        else
            System.out.println("Gia' presente in catalogo!");
    }

    public void removeMateriale(String codice) {
        int index = -1;
        for (Materiale materiale : materiali) {
            if (materiale.codice.equalsIgnoreCase(codice)) {
                index = materiali.indexOf(materiale);
            }
        }
        if (index >= 0)
            materiali.remove(materiali.get(index));
        else
            System.out.println("Articolo non presente nel catalogo!");
    }

    public void updateMateriale(Materiale m) {
        if (materiali.contains(m))
            materiali.set(materiali.indexOf(m), m);
    }

    public Materiale cerca(String codice) {
        for (Materiale materiale : materiali) {
            if (materiale.codice.equalsIgnoreCase(codice))
                return materiale;
        }
        return null;
    }

    public <T extends Materiale> ArrayList<T> soloTipo(Class<T> tipo) {

        ArrayList<T> mc = new ArrayList<T>();
        for (Materiale materiale : materiali) {
            if (tipo.isInstance(materiale))
                mc.add(tipo.cast(materiale));
        }
        return mc;
    }

    @Override
    public void salva(String percorso) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(percorso))) {
            pw.println("tipo,codice,titolo,anno,genere,prezzo,autore,pagine,ISBN,formato,dimensione,drm");
            for (Materiale materiale : materiali) {
                pw.println(materiale);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void stampaMateriali() {
        for (Materiale materiale : materiali) {
            System.out.println(materiale);
        }
    }

    @Override
    public void carica(String percorso) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(percorso));
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] info = line.split(",");
                if (info[0].equalsIgnoreCase("materialecartaceo")) {
                    materiali.add(new MaterialeCartaceo(info[1], info[2], Integer.parseInt(info[3]), info[4],
                            Double.parseDouble(info[5]), info[6], Integer.parseInt(info[7]), info[8]));
                } else {
                    materiali.add(new MaterialeDigitale(info[1], info[2], Integer.parseInt(info[3]), info[4],
                            Double.parseDouble(info[5]), info[9], Double.parseDouble(info[10]),
                            Boolean.parseBoolean(info[11])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
