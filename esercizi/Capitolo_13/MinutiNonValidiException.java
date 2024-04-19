// Indica che i minuti sono fuori dall'intervallo corretto 0-59
public class MinutiNonValidiException extends FormatoOraNonValidoException{
    
    public MinutiNonValidiException(String reason) {
        super(reason);
    }
    
}



