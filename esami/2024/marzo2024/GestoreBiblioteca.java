
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class GestoreBiblioteca {
    public ArrayList<Item> items = new ArrayList<Item>();

    public void add(Item item) {
        items.add(item);
        log("Aggiunto item " + item.getId());
    }

    public void remove(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                items.remove(item);
                break;
            }
        }
        log("Rimosso item " + id);
    }

    public void presta(int id, String utente) {
        for (Item item : items) {
            if (item.getId() == id) {
                if (item instanceof Prestabile) {
                    ((Prestabile) item).presta(utente, LocalDate.now());
                } else {
                    throw new UnsupportedOperationException("Item non prestabile");
                }
            }
        }
        log("Prestato item " + id + " a " + utente);
    }

    public void restituisci(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                if (item instanceof Prestabile) {
                    ((Prestabile) item).restituisci();
                } else {
                    throw new UnsupportedOperationException("Item non prestabile");
                }
            }
        }
        log("Restituzione item " + id);
    }

    public void printItems() {
        for (Item item : items) {
            System.out.println(item);
        }
        log("Stampa items");
    }

    public void caricaCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equalsIgnoreCase("libro")) {
                    add(new Libro(Integer.parseInt(values[1]), values[2], Integer.parseInt(values[3]), values[4],
                            Integer.parseInt(values[5])));
                } else if (values[0].equalsIgnoreCase("rivista")) {
                    add(new Rivista(Integer.parseInt(values[1]), values[2], Integer.parseInt(values[3]), values[6],
                            Integer.parseInt(values[7])));
                }
            }
            log("Caricamento da file CSV " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvaCSV(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Item item : items) {
                if (item instanceof Libro) {
                    bw.write("Libro," + item.getId() + "," + item.getTitolo() + "," + item.getAnno() + ","
                            + ((Libro) item).getAutore() + "," + ((Libro) item).getPagine());
                } else if (item instanceof Rivista) {
                    bw.write("Rivista," + item.getId() + "," + item.getTitolo() + "," + item.getAnno() + ","
                            + ((Rivista) item).getPeriodicita() + "," + ((Rivista) item).getNumero());
                }
                bw.newLine();
            }
            log("Salvataggio su file CSV " + filename);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void salvaPrestati() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("prestati.csv"))) {
            for (Item item : items) {
                if (item instanceof Prestabile) {
                    if (!((Prestabile) item).isDisponibile()) {
                        bw.write(item.getId() + "," + item.getTitolo() + "," + item.getUtente() + "," + item.getData());
                        bw.newLine();
                    }
                }
            }
            log("Salvataggio prestati");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String message) {

        System.out.println(message);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true))) {
            bw.write(message);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
