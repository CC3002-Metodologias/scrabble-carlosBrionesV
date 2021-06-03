package classes;

import java.util.Objects;

/**
 * Scrabble String Class
 */
public class ScrabString extends AbstractScrab {
    String theStr;

    /**
     * the ScrabString constructor
     * @param str the String value
     */
    public ScrabString(String str){
        theStr=str;
    }

    /**
     * getter method for ScrabString
     * @return the String value
     */
    public String getStr() {
        return theStr;
    }

    /**
     * change the value of the ScrabString
     * @param theStr the new String value
     */
    public void setStr(String theStr) {
        this.theStr = theStr;
    }

    /**
     * to string for printing purposes
     * @return the string version of the Scrabble String
     */
    @Override
    public String toString() {
        return theStr;
    }


    /** check if the object is equal
     *
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


