package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Studente extends Utente {
    public String classe;
    public double mediaVoti;

    public Studente(String id, String nome, String email, String classe, double mediaVoti) {
        super(id, nome, email);
        this.classe = classe;
        this.mediaVoti = mediaVoti;
    }

    @Override
    public void generaScheda(String path) throws IOException {
        File file = new File(path + "/studente_" + id + ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("ID:" + id + "\n");
            writer.write("Nome:" + nome + "\n");
            writer.write("Email:" + email + "\n");
            writer.write("Classe:" + classe + "\n");
            writer.write("MediaVoti:" + mediaVoti + "\n");
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nNome: " + nome + "\nEmail: " + email + "\nClasse: " + classe + "\nMediaVoti: "
                + mediaVoti;
    }
}