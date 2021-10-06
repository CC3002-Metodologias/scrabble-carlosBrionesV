package Exceptions;

/**
 * Exception for null values
 */
public class NullException extends Exception{

    /**
     * constructor
     * @param s a string with info about the exception
     */
    public NullException(String s){
        super(s);
    }
}
