package classes;

import java.util.Objects;
/** Constructor of ScrabInt class
 *
 *
 */
public class ScrabInt extends AbstractScrab {
    int theInt;

    public ScrabInt(int theInt) {
        this.theInt = theInt;
    }

    private int getInt() {
        return theInt;
    }

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

    public double toFloat(){
        return (double) Float.valueOf(toString());
    }

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


