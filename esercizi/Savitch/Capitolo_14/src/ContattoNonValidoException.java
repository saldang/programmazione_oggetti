/*
 * InvalidContactException.java
 *
 * Created on May 22, 2007, 12:22 PM
 *
 * Solution to Exercise 7
 *
 */

/**
 *
 * @author charleshoot
 */
public class ContattoNonValidoException extends Exception{
    
    /**
     * Creates a new instance of InvalidContactException
     */
    public ContattoNonValidoException(String reason) {
        super(reason);
    }
    
}


