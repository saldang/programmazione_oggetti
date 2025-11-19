package esame.albergo2025;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

public class Cliente {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private final String nome;
    private final String cognome;
    private final String email;
    private final String telefono;
    private final LocalDate dataRegistrazione;

    public Cliente(String nome, String cognome, String email, String telefono) throws ClienteNonValidoException {
        this(nome, cognome, email, telefono, LocalDate.now());
    }

    public Cliente(String nome, String cognome, String email, String telefono, LocalDate dataRegistrazione)
            throws ClienteNonValidoException {
        this.nome = validaNome(nome);
        this.cognome = validaCognome(cognome);
        this.email = validaEmail(email);
        this.telefono = validaTelefono(telefono);
        this.dataRegistrazione = Objects.requireNonNullElse(dataRegistrazione, LocalDate.now());
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public LocalDate getDataRegistrazione() {
        return dataRegistrazione;
    }

    public void valida() throws ClienteNonValidoException {
        validaNome(nome);
        validaCognome(cognome);
        validaEmail(email);
        validaTelefono(telefono);
    }

    public String getInformazioniPerFile() {
        return String.join(";", nome, cognome, email.toLowerCase(Locale.ROOT), telefono.replace(";", ""),
                dataRegistrazione.toString());
    }

    @Override
    public String toString() {
        return "[Cliente] " + nome + " " + cognome + " - Email: " + email + " - Tel: " + telefono;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cliente other)) {
            return false;
        }
        return email.equalsIgnoreCase(other.email);
    }

    @Override
    public int hashCode() {
        return email.toLowerCase(Locale.ROOT).hashCode();
    }

    private static String validaNome(String valore) throws ClienteNonValidoException {
        if (valore == null || valore.trim().length() < 2) {
            throw new ClienteNonValidoException("Errore nel campo NOME: deve contenere almeno 2 caratteri", "NOME");
        }
        return valore.trim();
    }

    private static String validaCognome(String valore) throws ClienteNonValidoException {
        if (valore == null || valore.trim().length() < 2) {
            throw new ClienteNonValidoException("Errore nel campo COGNOME: deve contenere almeno 2 caratteri",
                    "COGNOME");
        }
        return valore.trim();
    }

    private static String validaEmail(String valore) throws ClienteNonValidoException {
        if (valore == null || valore.trim().isEmpty() || !EMAIL_PATTERN.matcher(valore.trim()).matches()) {
            throw new ClienteNonValidoException("Errore nel campo EMAIL: formato email non valido", "EMAIL");
        }
        return valore.trim();
    }

    private static String validaTelefono(String valore) throws ClienteNonValidoException {
        if (valore == null || valore.trim().isEmpty()) {
            throw new ClienteNonValidoException("Errore nel campo TELEFONO: deve essere specificato", "TELEFONO");
        }
        String pulito = valore.replaceAll("[\\s-]", "");
        String numerico = pulito.startsWith("+") ? pulito.substring(1) : pulito;
        if (!numerico.chars().allMatch(Character::isDigit) || numerico.length() < 7) {
            throw new ClienteNonValidoException("Errore nel campo TELEFONO: formato non valido", "TELEFONO");
        }
        return valore.trim();
    }
}
