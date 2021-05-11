package classes;

import java.util.Objects;

public class ScrabFloat  extends AbstractScrab {
    double theDouble;
    public ScrabFloat(double d){
        theDouble=d;
    }

    public double getFloat(){
        return theDouble;
    }

    @Override
    public String toString(){
        return String.valueOf(this.getFloat());
    }


    /** transforms Scrabble Double to Scrabble String
     *
     * @return a Scrabble String representing the Scrabble Double
     */
    public ScrabString toScrabString(){
        return new ScrabString(toString());
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
        ScrabFloat that = (ScrabFloat) o;
        return Double.compare(that.theDouble, theDouble) == 0;
    }
}
