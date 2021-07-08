package STypes;

import AST.Operations.AbstractConstant;

import java.util.Objects;

/**
 * Scrabble String class
 */
public class ScrabString extends AbstractConstant implements ScrabType{
    String value;

    /**
     * constructor of ScrabString
     * @param str the String Value
     */
    public ScrabString(String str){
        value=str;
    }

    /**
     * to string method for printing purposes
     * @return the String value of ScrabString
     */
    @Override
    public String toString() {
        return value;
    }

    /**
     * copies the ScrabString
     * @return a new ScrabString
     */
    public ScrabString toScrabString(){
      return new ScrabString(value);
    }

    /**
     * concatenates the given Scrabble
     * @param scrab the Scrabble object
     * @return a new ScrabString concatenating ScrabString+scrab
     */
    public ScrabString add(ScrabType scrab){
        return new ScrabString(toString()+scrab.toString());
    }

    /**
     * hashCode for a ScrabString
     * @return the hashCode of the ScrabString
     */
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    /**
     * check if the object is equal
     * @param o object to compare to
     * @return a boolean stating if o and this are equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrabString that = (ScrabString) o;
        return Objects.equals(toString(), that.toString());
    }
}


