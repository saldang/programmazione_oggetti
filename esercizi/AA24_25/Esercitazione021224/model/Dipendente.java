package model;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Dipendente extends Utente{
    private String ruolo;
    private double stipendio;
    
    public Dipendente(String id, String nome, String email, String ruolo, double stipendio) {
        super(id, nome, email);
        this.ruolo = ruolo;
        this.stipendio = stipendio;
    }

    @Override
    public void generaScheda(String path) throws IOException {
        File file = new File(path + "/dipendente_" + id + ".txt");
        try (
            BufferedWriter writer = new BufferedWriter(new FileWriter(file))
        ) {
            writer.write("ID:" + id + "\n");
            writer.write("Nome:" + nome + "\n");
            writer.write("Email:" + email + "\n");
            writer.write("Ruolo:" + ruolo + "\n");
            writer.write("Stipendio:" + stipendio + "\n");
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nNome: " + nome + "\nEmail: " + email + "\nRuolo: " + ruolo + "\nStipendio: " + stipendio;
    }

}
