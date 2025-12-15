public class UtenteNonValidoException extends Exception {
    public UtenteNonValidoException(String messaggio, String campo) {
        super("Errore nel campo " + campo + ":" + messaggio);
    }

}
