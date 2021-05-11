package classes;

import java.util.Objects;

public class ScrabBoolean extends AbstractScrab{
    boolean theBool;

    /** constructor of class ScrabBoolean
     *
     * @param b the boolean value
     */
    public ScrabBoolean(boolean b){
        theBool=b;
    }

    /** getter method for ScrabBoolean
     *
     * @return The Boolean value
     */

     private Boolean getBool(){
        return theBool;
    }
    /** to string for printing purposes
     *
     * @return the string version of the boolean
     */
    @Override
    public String toString() {
        return String.valueOf(getBool());
    }
    /** transforms Scrabble Boolean to Scrabble String
     *
     * @return a Scrabble String representing the Scrabble Boolean
     */
    public ScrabString toScrabString(){
        return new ScrabString(toString());
    }

    /** check if the object is equal
     *
     * @param o object to compare to
     * @return a boolean stating if o and this are equals
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrabBoolean that = (ScrabBoolean) o;
        return getBool() == that.getBool();
    }
}
