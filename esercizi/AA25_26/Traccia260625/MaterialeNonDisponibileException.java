public class MaterialeNonDisponibileException extends Exception {

    public MaterialeNonDisponibileException(String msg, String materiale) {
        super(msg);
        System.out.printf("%s non disponibile!", materiale);
    }

}
