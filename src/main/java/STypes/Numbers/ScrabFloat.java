package STypes.Numbers;


import AST.Operation;
import AST.ScrabFactory;
import STypes.AbstracType;
import STypes.ScrabString;
import STypes.ScrabType;

import java.util.Objects;

import static java.lang.StrictMath.abs;

/**
 * Scrabble Float class
 */
public class ScrabFloat extends AbstracType implements SNumber {
    double value;
    ScrabFactory factory;

    /**
     * constructor of ScrabFloat class
     * @param d the double value
     */
    public ScrabFloat(double d,ScrabFactory factory){
        this.factory=factory;
        value=d;
    }

    /**
     * getter for ScrabFloat
     * @return the double value of the ScrabFloat
     */
    public double getFloat(){
        return value;
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
        return factory.createString(toString());
    }

    /**
     * copies the ScrabFloat
     * @return a new ScrabFloat
     */
    public ScrabFloat toScrabFloat(){return factory.createFloat(getFloat());}

    /**
     * negates the value of the ScrabFloat
     * @return a new ScrabFloat
     */
    public ScrabFloat neg(){
        return factory.createFloat(-getFloat());
    }

    /**
     * {@inheritDoc}
     * @param scrab a ScrabInt, ScrabBinary or ScrabFloat
     * @return a ScrabFloat
     */
    public ScrabFloat add(SNumber scrab) {
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

    /**
     * {@inheritDoc}
     * @param scrab a ScrabInt, ScrabBinary or ScrabFloat
     * @return a ScrabFloat
     */
    public ScrabFloat mult(SNumber scrab) {
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

    /**
     * {@inheritDoc}
     * @param scrabInt the ScrabInt to add
     * @return a new ScrabFloat with the values added
     */
    public ScrabFloat addInt(ScrabInt scrabInt) {
        double f1 = getFloat();
        double f2 =scrabInt.toFloat();
        return factory.createFloat(f1+f2);
    }

    /**
     * {@inheritDoc}
     * @param scrabInt the ScrabInt to multiply
     * @return a new ScrabFloat with the values multiplied
     */
    public ScrabFloat multInt(ScrabInt scrabInt) {
        double f1 = getFloat();
        double f2 =scrabInt.toFloat();
        return factory.createFloat(f1 * f2);
    }

    /**
     * {@inheritDoc}
     * @param scrabInt the ScrabInt to divide
     * @return a new ScrabFloat with the values divided
     */
    public ScrabFloat divInt(ScrabInt scrabInt) {
        double f1 = getFloat();
        double f2 =scrabInt.toFloat();
        return factory.createFloat(f2 / f1);
    }

    /**
     * {@inheritDoc}
     * @param scrabInt the ScrabInt to subtract
     * @return a new ScrabFloat with the values subtracted
     */
    public ScrabFloat minusInt(ScrabInt scrabInt) {
        double f1 = getFloat();
        double f2 =scrabInt.toFloat();
        return factory.createFloat(f2 - f1);
    }

    /**
     * {@inheritDoc}
     * @param scrabFloat the ScrabFloat to add
     * @return a new ScrabFloat with the values added
     */
    public ScrabFloat addFloat(ScrabFloat scrabFloat) {
        double f1 = getFloat();
        double f2 =scrabFloat.getFloat();
        return factory.createFloat(f1 + f2);
    }

    /**
     * {@inheritDoc}
     * @param scrabFloat the ScrabFloat to multiply
     * @return a new ScrabFloat with the values multiplied
     */
    public ScrabFloat multFloat(ScrabFloat scrabFloat) {
        double f1 = getFloat();
        double f2 =scrabFloat.getFloat();
        return factory.createFloat(f1 * f2);
    }

    /**
     * {@inheritDoc}
     * @param scrabFloat the ScrabFloat to divide
     * @return a new ScrabFloat with the values divided
     */
    public ScrabFloat divFloat(ScrabFloat scrabFloat) {
        double f1 = getFloat();
        double f2 =scrabFloat.getFloat();
        return factory.createFloat(f2 / f1);
    }

    /**
     * {@inheritDoc}
     * @param scrabFloat the ScrabFloat to subtract
     * @return a new ScrabFloat with the values added
     */
    public ScrabFloat minusFloat(ScrabFloat scrabFloat) {
        double f1 = getFloat();
        double f2 =scrabFloat.getFloat();
        return factory.createFloat(f2 - f1);
    }

    /**
     * hashCode for a ScrabFloat
     * @return the hashCode of the ScrabFloat
     */
    @Override
    public int hashCode() {
        return Objects.hash(value);
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
        return (abs(that.value - value))<0.001;
    }



    /**
     * addition operation
     *
     * @param cons number constant
     * @return ScrabType with the result
     */
    @Override
    public ScrabType Add(Operation cons) {
        return this.add((SNumber) cons);
    }

    /**
     * subtraction operation
     *
     * @param cons number ScrabType
     * @return ScrabType with the result
     */
    @Override
    public SNumber Minus(Operation cons) {
        return this.minus((SNumber) cons);
    }

    /**
     * division operation
     *
     * @param cons Number ScrabType
     * @return ScrabType with the result
     */
    @Override
    public SNumber Div(Operation cons) {
        return this.div((SNumber)cons);
    }

    /**
     * miltiplication operation
     *
     * @param cons Number ScrabType
     * @return ScrabType with the result
     */
    @Override
    public SNumber Mult(Operation cons) {
        return this.mult((SNumber) cons);
    }

    /**
     * negation operation
     *
     * @return ScrabType with the result
     */
    @Override
    public ScrabType Neg() {
        return this.neg();
    }

}
