// Indica che l'ora e' fuori dall'intervallo corretto 0-12
public class OraNonValidaException extends FormatoOraNonValidoException{
    
    public OraNonValidaException(String motivo) {
        super(motivo);
    }
    
}


