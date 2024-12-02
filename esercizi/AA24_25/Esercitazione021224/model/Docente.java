package model;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Docente extends Dipendente {
    private String materia;
    private double stipendio;
    private String ruolo;

    public Docente(String id, String nome, String email, String ruolo, double stipendio, String materia) {
        super(id, nome, email, ruolo, stipendio);
        this.materia = materia;
    }

    @Override
    public void generaScheda(String path) throws IOException {
        File file = new File(path + "/docente_" + id + ".txt");
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("ID:" + id + "\n");
            writer.write("Nome:" + nome + "\n");
            writer.write("Email:" + email + "\n");
            writer.write("Ruolo:" + ruolo + "\n");
            writer.write("Stipendio:" + stipendio + "\n");
            writer.write("Materia:" + materia + "\n");
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nNome: " + nome + "\nEmail: " + email + "\nRuolo: " + ruolo + "\nStipendio: " + stipendio + "\nMateria: " + materia;
    }
}
