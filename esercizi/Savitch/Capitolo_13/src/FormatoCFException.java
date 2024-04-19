
/**
 File name: SSNCharacterException.java

 Exception class that prints either a message passed by the caller,
 a message that says the SSN entered has an invalid character and
 includes the erroneous data, or the default message that the SSN
 has an invalid character.

 Author: Lew Rakocy
 email address: LRakocy@devrycols.edu
 Date: 9/11/2000
 Changes: 03/23/2003 Made comments like text examples.
*/
public class FormatoCFException extends Exception
{
    public FormatoCFException()
    {
        super("Invalid SSN: enter only decimal digits.");
    }

    public FormatoCFException(String wrongInput, char wrongChar)
    {
        super(wrongInput 
            + " is an invalid SSN: it contains an illegal character: "
                   + wrongChar);
    }

    public FormatoCFException(String message)
    {
        super(message);
    }
}