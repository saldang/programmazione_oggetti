package esame.albergo2025;

public class ClienteNonValidoException extends Exception {
    private final String campo;

    public ClienteNonValidoException(String messaggio, String campo) {
        super(messaggio);
        this.campo = campo;
    }

    public String getCampo() {
        return campo;
    }
}
