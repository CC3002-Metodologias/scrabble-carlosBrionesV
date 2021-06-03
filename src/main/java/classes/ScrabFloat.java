package classes;

/**
 * Scrabble Float Class
 */
public class ScrabFloat  extends AbstractScrab {
    double theDouble;

    /**
     * constructor of class ScrabFloat
     * @param d the double value
     */
    public ScrabFloat(double d){
        theDouble=d;
    }

    /**
     * getter method for ScrabFloat
     * @return te double value
     */
    public double getFloat(){
        return theDouble;
    }

    /**
     * change the value of the ScrabFloat
     * @param theDouble the new double value
     */
    public void setFloat(double theDouble) {
        this.theDouble = theDouble;
    }

    /**
     * to string for printing purposes
     * @return the string version of the Scrabble Float
     */
    @Override
    public String toString(){
        return String.valueOf(this.getFloat());
    }


    /**
     * transforms Scrabble Float to Scrabble String
     * @return a Scrabble String representing the Scrabble Float
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
