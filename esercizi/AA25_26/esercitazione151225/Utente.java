import java.time.LocalDate;

public class Utente {
    private String nome;
    private String cognome;
    private String email;
    private String tessera;
    private LocalDate dataIscrizione;

    public Utente(String nome, String cognome, String email, String tessera)
            throws UtenteNonValidoException {
        if (nome != null && !nome.isEmpty() && !nome.isBlank() && nome.length() > 2)
            this.nome = nome;
        else
            throw new UtenteNonValidoException(
                    "Il nome deve avere almeno 2 caratteri, deve essere diverso da vuoto o null", "NOME");
        if (cognome != null && !cognome.isEmpty() && !cognome.isBlank() && cognome.length() > 2)
            this.cognome = cognome;
        else
            throw new UtenteNonValidoException(
                    "Il cognome deve avere almeno 2 caratteri, deve essere diverso da vuoto o null", "COGNOME");
        if (email != null && !email.isBlank() && !email.isEmpty() && email.contains("@") && email.contains(".")
                && email.matches("[a-zA-Z0-9._]{3,}@[a-zA-Z0-9._]{3,}.[a-z]{2,}"))
            this.email = email;
        else
            throw new UtenteNonValidoException("Email non valida", "EMAL");
        if (tessera != null && !tessera.isBlank() && !tessera.isEmpty() && tessera.matches("BIB[0-9]{6}"))
            this.tessera = tessera;
        else
            throw new UtenteNonValidoException("Formato tessera non valido (BIB123456)", "TESSERA");

        this.dataIscrizione = LocalDate.now();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTessera() {
        return tessera;
    }

    public void setTessera(String tessera) {
        this.tessera = tessera;
    }

    public LocalDate getDataIscrizione() {
        return dataIscrizione;
    }

    public void setDataIscrizione(LocalDate dataIscrizione) {
        this.dataIscrizione = dataIscrizione;
    }

    @Override
    public String toString() {
        return nome + " " + cognome + " " + email + " " + tessera + " " + dataIscrizione;
    }
}
