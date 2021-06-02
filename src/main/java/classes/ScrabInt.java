package classes;

import java.util.Objects;

import static java.lang.Math.abs;

/**
 * Scrabble Int class
 */
public class ScrabInt implements SNumber,SFloat {
    int theInt;

    /**
     * Constructor of ScrabInt
     * @param theInt the int value
     */
    public ScrabInt(int theInt) {
        this.theInt = theInt;
    }

    /**
     * getter of the int value
     * @return the ScrabInt value
     */
    public int getInt() {
        return theInt;
    }

    /**
     * setter of the int value
     * @param Int the int value to remplace
     */
    public void setInt(int Int){
        theInt=Int;
    }

    /**
     * to String for printing purposes
     * @return the int value as a String
     */
    @Override
    public String toString() {
        return String.valueOf(getInt());
    }

    /**
     * negates the value of the ScrabInt
     */
    public void neg(){setInt(-getInt());}

    /**
     * {@inheritDoc}
     * @param scrab a ScrabInt or a ScrabBinary
     * @return a ScrabInt
     */
    public ScrabInt add(SNumber scrab) {
        return (ScrabInt) scrab.addInt(this);
    }

    /**
     * {@inheritDoc}
     *
     * @param scrabFloat the ScrabFloat to add
     * @return a new ScrabFloat with the values added
     */
    public ScrabFloat add(ScrabFloat scrabFloat) {
        return scrabFloat.addInt(this);
    }

    /**
     * {@inheritDoc}
     * @param scrab a ScrabInt or a ScrabBinary
     * @return a ScrabInt
     */
    public ScrabInt mult(SNumber scrab){
        return (ScrabInt) scrab.multInt(this);
    }

    /**
     * {@inheritDoc}
     *
     * @param scrabFloat the ScrabFloat to multiply
     * @return a new ScrabFloat with the values multiplied
     */
    public ScrabFloat mult(ScrabFloat scrabFloat) {
        return scrabFloat.multInt(this);
    }

    /**
     * {@inheritDoc}
     * @param scrab a ScrabInt or a ScrabBinary
     * @return a ScrabInt
     */
    public ScrabInt div(SNumber scrab){
        return (ScrabInt) scrab.divInt(this);
    }

    /**
     * {@inheritDoc}
     *
     * @param scrabFloat the ScrabFloat to divide
     * @return a new ScrabFloat with the values divided
     */
    public ScrabFloat div(ScrabFloat scrabFloat) {
        return scrabFloat.divInt(this);    }

    /**
     * {@inheritDoc}
     * @param scrab a ScrabInt or a ScrabBinary
     * @return a ScrabInt
     */
    public ScrabInt minus(SNumber scrab){
        return (ScrabInt) scrab.minusInt(this);
    }

    /**
     * {@inheritDoc}
     *
     * @param scrabFloat the ScrabFloat to subtract
     * @return a new ScrabFloat with the values subtracted
     */
    public ScrabFloat minus(ScrabFloat scrabFloat) {
        return scrabFloat.minusInt(this);
    }

    /**
     * {@inheritDoc}
     * @param binary the ScrabBinary to add
     * @return a new ScrabBinary with the values added
     */
    public ScrabBinary addBinary(ScrabBinary binary) {
        int i1=binary.toInt(binary.getBin());
        int i2 = getInt();
        ScrabInt si = new ScrabInt(i2+i1);
        return si.toScrabBinary();
    }

    /**
     * {@inheritDoc}
     * @param binary the ScrabBinary to multiply
     * @return a new ScrabBinary with the values multiplied
     */
    public ScrabBinary multBinary(ScrabBinary binary) {
        int i1=binary.toInt(binary.getBin());
        int i2 = getInt();
        ScrabInt si = new ScrabInt(i2*i1);
        return si.toScrabBinary();
    }

    /**
     * {@inheritDoc}
     * @param binary the ScrabBinary to divide
     * @return a new ScrabBinary with the values divided
     */
    public ScrabBinary divBinary(ScrabBinary binary) {

        int i1=binary.toInt(binary.getBin());
        int i2 = getInt();
        ScrabInt si = new ScrabInt(i1/i2);
        if(i1*i2<0){
            si.multInt(new ScrabInt(-1));
        }
        return si.toScrabBinary();
    }

    /**
     * {@inheritDoc}
     * @param binary the ScrabBinary to subtract
     * @return a new ScrabBinary with the values subtracted
     */
    public ScrabBinary minusBinary(ScrabBinary binary) {
        int i1=binary.toInt(binary.getBin());
        int i2 = getInt();
        ScrabInt si = new ScrabInt(i1-i2);
        return si.toScrabBinary();
    }

    /**
     * {@inheritDoc}
     * @param scrabInt the ScrabInt to add
     * @return a new ScrabInt with the values added
     */
    public ScrabInt addInt(ScrabInt scrabInt) {
        int i1= scrabInt.getInt();
        int i2 = getInt();
        return new ScrabInt(i1+i2);
    }

    /**
     * {@inheritDoc}
     * @param scrabInt the ScrabInt to multiply
     * @return a new ScrabInt with the values multiplied
     */
    public ScrabInt multInt(ScrabInt scrabInt) {
        int i1= scrabInt.getInt();
        int i2 = getInt();
        return new ScrabInt(i2*i1);
    }

    /**
     * {@inheritDoc}
     * @param scrabInt the ScrabInt to divide
     * @return a new ScrabInt with the values divided
     */
    public ScrabInt divInt(ScrabInt scrabInt) {
        int i1= scrabInt.getInt();
        int i2 = getInt();
        return new ScrabInt(i1/i2);
    }

    /**
     * {@inheritDoc}
     * @param scrabInt the ScrabInt to subtract
     * @return  a new ScrabInt with the values subtracted
     */
    public ScrabInt minusInt(ScrabInt scrabInt) {
        int i1= scrabInt.getInt();
        int i2 = getInt();
        return new ScrabInt(i1-i2);
    }

    /**
     * {@inheritDoc}
     * @param scrabFloat the ScrabFloat to add
     * @return a new ScrabFloat with the values added
     */
    public ScrabFloat addFloat(ScrabFloat scrabFloat) {
        double f1 = toFloat();
        double f2 =scrabFloat.getFloat();
        return new ScrabFloat(f1+f2);
    }

    /**
     * {@inheritDoc}
     * @param scrabFloat the ScrabFloat to multiply
     * @return a new ScrabFloat with the values multiplied
     */
    public ScrabFloat multFloat(ScrabFloat scrabFloat) {
        double f1 = toFloat();
        double f2 =scrabFloat.getFloat();
        return new ScrabFloat(f1*f2);
    }

    /**
     * {@inheritDoc}
     * @param scrabFloat the ScrabFloat to divide
     * @return a new ScrabFloat with the values divided
     */
    public ScrabFloat divFloat(ScrabFloat scrabFloat) {
        double f1 = toFloat();
        double f2 =scrabFloat.getFloat();
        return new ScrabFloat(f2/f1);
    }

    /**
     * {@inheritDoc}
     * @param scrabFloat the ScrabFloat to subtract
     * @return a new ScrabFloat with the values subtracted
     */
    public ScrabFloat minusFloat(ScrabFloat scrabFloat) {
        double f1 = toFloat();
        double f2 =scrabFloat.getFloat();
        return new ScrabFloat(f2-f1);
    }

    /** transforms Scrabble int to Scrabble String
     *
     * @return a Scrabble String representing the Scrabble int
     */
    public ScrabString toScrabString(){
        return new ScrabString(toString());
    }

    /**
     * transforms a ScrabInt to a Float
     * @return the Float representation of the ScrabInt
     */
    public double toFloat(){
        return getInt();
    }

    /**
     * transforms a ScrabInt to a ScrabFloat
     * @return the ScrabFloat representation of the ScrabInt
     */
    public ScrabFloat toScrabFloat(){
        return new ScrabFloat(toFloat());
    }

    /**
     * transforms a ScrabInt to a ScrabBinary
     * @return the ScrabBinary representation of the ScrabInt
     */
    public ScrabBinary toScrabBinary(){
        return new ScrabBinary(toBinary(getInt()));
    }

    /**
     * Transforms a ScrabInt to a binary String
     * @return the binary string representation of the ScrabInt
     */
    public String toBinary(int Int){
        int absi = abs(Int);
        var bin = new ScrabBinary(positiveIntToBinary(absi));
        if (Int<0){
            bin=bin.twosComplement();

        }
        return bin.toString();
    }

    /**
     * Transforms a positive int to a binary string
     * @param Int the int to transform
     * @return a Binary String representing the int
     */
    public String positiveIntToBinary(int Int){
        var str = new StringBuilder();
        while (str.length()<31){
            int remainder=Int%2;
            Int=Int/2;
            str.append(remainder);
        }
        str.append(0);
        return str.reverse().toString();
    }

    /**
     * hashCode for a ScrabInt
     * @return the hashCode of the ScrabInt
     */
    @Override
    public int hashCode() {
        return Objects.hash(theInt);
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


