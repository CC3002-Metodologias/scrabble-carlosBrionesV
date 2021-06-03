package classes;

import java.util.Objects;
/** Constructor of ScrabInt class
 *
 *
 */
public class ScrabInt extends AbstractScrab {
    int theInt;

    /** Scrabble int constructor
     *
     * @param theInt an int
     */
    public ScrabInt(int theInt) {
        this.theInt = theInt;
    }

    /** getter for Scrabint
     *
     * @return the Scrabble int value
     */
    private int getInt() {
        return theInt;
    }

    /**
     * change the value of the ScrabInt
     * @param theInt the new int value
     */
    public void setInt(int theInt) {
        this.theInt = theInt;
    }

    /** to string method for printing purposes
     *
     * @return a String representing the Scrabble int
     */
    @Override
    public String toString() {
        return String.valueOf(getInt());
    }

    /** transforms Scrabble int to Scrabble String
     *
     * @return a Scrabble String representing the Scrabble int
     */
    public ScrabString toScrabString(){
        return new ScrabString(toString());
    }

    /** transforms Scrabble int to double type
     *
     * @return a double representing the Scrabble int
     */
    public double toFloat(){
        return Float.parseFloat(toString());
    }

    /** transforms Scrabble int to Scrabble Float
     *
     * @return a Scrabble Float representing the Scrabble int
     */
    public ScrabFloat toScrabFloat(){
        return new ScrabFloat(toFloat());
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
        ScrabInt scrabInt = (ScrabInt) o;
        return theInt == scrabInt.theInt;
    }
}


