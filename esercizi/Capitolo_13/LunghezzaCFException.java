
/**
 File name: SSNLengthException.java

 Exception class that prints either a message passed by the caller,
 a message that says the SSN entered is not the correct length and
 includes the data entered, or the default message that the SSN is
 not the correct length.

 Author: Lew Rakocy
 email address: LRakocy@devrycols.edu
 Date: 9/11/2000
 Changes: 03/23/2003 Made comments like text examples.
*/
public class LunghezzaCFException extends Exception
{
    public LunghezzaCFException()
    {
        super("Invalid SSN length: it must be exactly 9 characters.");
    }

    public LunghezzaCFException(String wrongInput, int wrongLength)
    {
        super(wrongInput + "'s length of " + wrongLength
            + " is invalid: it must be 9 characters. ");
    }

    public LunghezzaCFException(String message)
    {
        super(message);
    }
}