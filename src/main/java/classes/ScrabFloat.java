package classes;

import java.util.Objects;

import static java.lang.StrictMath.abs;

/**
 * Scrabble Float class
 */
public class ScrabFloat implements SFloat {
    double theDouble;

    /**
     * constructor of ScrabFloat class
     * @param d the double value
     */
    public ScrabFloat(double d){
        theDouble=d;
    }

    /**
     * getter for ScrabFloat
     * @return the double value of the ScrabFloat
     */
    public double getFloat(){
        return theDouble;
    }

    /** to String for printing purposes
     *
     * @return the ScrabFloat as a String
     */
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

    /**
     * negates the value of the ScrabFloat
     */
    public void neg(){theDouble=-getFloat();}

    /**
     * {@inheritDoc}
     * @param scrab a ScrabInt, ScrabBinary or ScrabFloat
     * @return a ScrabFloat
     */
    public ScrabFloat add(SNumber scrab) {
        return scrab.addFloat(this);
    }
    public ScrabFloat add(ScrabFloat scrab) {
        return scrab.addFloat(this);
    }

    /**
     * {@inheritDoc}
     * @param scrab a ScrabInt, ScrabBinary or ScrabFloat
     * @return a ScrabFloat
     */
    public ScrabFloat minus(SNumber scrab) {
        return scrab.minusFloat(this);
    }
    public ScrabFloat minus(ScrabFloat scrab) {
        return scrab.minusFloat(this);
    }

    /**
     * {@inheritDoc}
     * @param scrab a ScrabInt, ScrabBinary or ScrabFloat
     * @return a ScrabFloat
     */
    public ScrabFloat mult(SNumber scrab) {
        return scrab.multFloat(this);
    }
    public ScrabFloat mult(ScrabFloat scrab) {
        return scrab.multFloat(this);
    }

    /**
     * {@inheritDoc}
     * @param scrab a ScrabInt, ScrabBinary or ScrabFloat
     * @return a ScrabFloat
     */
    public ScrabFloat div(SNumber scrab) {
        return scrab.divFloat(this);
    }
    public ScrabFloat div(ScrabFloat scrab) {
        return scrab.divFloat(this);
    }

    /**
     * {@inheritDoc}
     * @param scrabInt the ScrabInt to add
     * @return a new ScrabFloat with the values added
     */
    public ScrabFloat addInt(ScrabInt scrabInt) {
        double f1 = getFloat();
        double f2 =scrabInt.toFloat();
        return new ScrabFloat(f1+f2);
    }

    /**
     * {@inheritDoc}
     * @param scrabInt the ScrabInt to multiply
     * @return a new ScrabFloat with the values multiplied
     */
    public ScrabFloat multInt(ScrabInt scrabInt) {
        double f1 = getFloat();
        double f2 =scrabInt.toFloat();
        return new ScrabFloat(f1*f2);
    }

    /**
     * {@inheritDoc}
     * @param scrabInt the ScrabInt to divide
     * @return a new ScrabFloat with the values divided
     */
    public ScrabFloat divInt(ScrabInt scrabInt) {
        double f1 = getFloat();
        double f2 =scrabInt.toFloat();
        return new ScrabFloat(f2/f1);
    }

    /**
     * {@inheritDoc}
     * @param scrabInt the ScrabInt to subtract
     * @return a new ScrabFloat with the values subtracted
     */
    public ScrabFloat minusInt(ScrabInt scrabInt) {
        double f1 = getFloat();
        double f2 =scrabInt.toFloat();
        return new ScrabFloat(f2-f1);
    }

    /**
     * {@inheritDoc}
     * @param scrabFloat the ScrabFloat to add
     * @return a new ScrabFloat with the values added
     */
    public ScrabFloat addFloat(ScrabFloat scrabFloat) {
        double f1 = getFloat();
        double f2 =scrabFloat.getFloat();
        return new ScrabFloat(f1+f2);
    }

    /**
     * {@inheritDoc}
     * @param scrabFloat the ScrabFloat to multiply
     * @return a new ScrabFloat with the values multiplied
     */
    public ScrabFloat multFloat(ScrabFloat scrabFloat) {
        double f1 = getFloat();
        double f2 =scrabFloat.getFloat();
        return new ScrabFloat(f1*f2);
    }

    /**
     * {@inheritDoc}
     * @param scrabFloat the ScrabFloat to divide
     * @return a new ScrabFloat with the values divided
     */
    public ScrabFloat divFloat(ScrabFloat scrabFloat) {
        double f1 = getFloat();
        double f2 =scrabFloat.getFloat();
        return new ScrabFloat(f2/f1);
    }

    /**
     * {@inheritDoc}
     * @param scrabFloat the ScrabFloat to subtract
     * @return a new ScrabFloat with the values added
     */
    public ScrabFloat minusFloat(ScrabFloat scrabFloat) {
        double f1 = getFloat();
        double f2 =scrabFloat.getFloat();
        return new ScrabFloat(f2-f1);
    }

    /**
     * hashCode for a ScrabFloat
     * @return the hashCode of the ScrabFloat
     */
    @Override
    public int hashCode() {
        return Objects.hash(theDouble);
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
        return abs(that.theDouble - theDouble) < 0.01;
    }
}
