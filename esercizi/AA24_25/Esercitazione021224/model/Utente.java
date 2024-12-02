package model;

import java.io.IOException;

public abstract class Utente {
    protected String id, nome, email;

    public Utente(String id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public abstract void generaScheda(String path) throws IOException;

    public String getId() {
        return id;
    }
}
