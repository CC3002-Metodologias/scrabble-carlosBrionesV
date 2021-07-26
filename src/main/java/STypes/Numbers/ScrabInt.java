package STypes.Numbers;


import AST.Operations.Operation;
import AST.ScrabFactory;
import STypes.AbstracType;
import STypes.ScrabType;
import operands.BinaryOperand;
import STypes.ScrabString;
import operands.Slogic;

import java.util.Objects;

import static java.lang.Math.abs;

/**
 * Scrabble Int class
 */
public class ScrabInt extends AbstracType implements SNumber, BinaryOperand{
    int value;
    ScrabFactory factory;

    /**
     * Constructor of ScrabInt
     * @param value the int value
     */
    public ScrabInt(int value,ScrabFactory factory) {
        this.factory=factory;
        this.value = value;
    }

    /**
     * getter of the int value
     * @return the ScrabInt value
     */
    public int getInt() {
        return value;
    }

    /**
     * setter of the int value
     * @param Int the int value to remplace
     */
    public void setInt(int Int){
        value=Int;
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
    public ScrabInt neg(){
       return factory.createInt(-getInt());
    }

    /**
     * {@inheritDoc}
     * @param scrab a ScrabInt or a ScrabBinary
     * @return a ScrabInt
     */
    public SNumber add(SNumber scrab) {
        return scrab.addInt(this);
    }

    /**
     * {@inheritDoc}
     * @param scrab a ScrabInt or a ScrabBinary
     * @return a ScrabInt
     */
    public SNumber mult(SNumber scrab){
        return scrab.multInt(this);
    }

    /**
     * {@inheritDoc}
     * @param scrab a ScrabInt or a ScrabBinary
     * @return a ScrabInt
     */
    public SNumber div(SNumber scrab){
        return scrab.divInt(this);
    }

    /**
     * {@inheritDoc}
     * @param scrab a ScrabInt or a ScrabBinary
     * @return a ScrabInt
     */
    public SNumber minus(SNumber scrab){
        return scrab.minusInt(this);
    }

    /**
     * {@inheritDoc}
     * @param binary the ScrabBinary to add
     * @return a new ScrabBinary with the values added
     */
    public ScrabBinary addBinary(ScrabBinary binary) {
        int i1=binary.toInt(binary.getBin());
        int i2 = getInt();
        ScrabInt si = factory.createInt(i2 + i1);
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
        ScrabInt si = factory.createInt(i2 * i1);
        return si.toScrabBinary();
    }

    /**
     * {@inheritDoc}
     * @param binary the ScrabBinary to divide
     * @return a new ScrabBinary with the values divided
     */
    public ScrabBinary divBinary(ScrabBinary binary) {

        int i1=binary.toScrabInt().getInt();
        int i2 = getInt();
        ScrabInt si = factory.createInt(i1 / i2);
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
        ScrabInt si = factory.createInt(i1 - i2);
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
        return factory.createInt(i1+i2);
    }

    /**
     * {@inheritDoc}
     * @param scrabInt the ScrabInt to multiply
     * @return a new ScrabInt with the values multiplied
     */
    public ScrabInt multInt(ScrabInt scrabInt) {
        int i1= scrabInt.getInt();
        int i2 = getInt();
        return factory.createInt(i2*i1);
    }

    /**
     * {@inheritDoc}
     * @param scrabInt the ScrabInt to divide
     * @return a new ScrabInt with the values divided
     */
    public ScrabInt divInt(ScrabInt scrabInt) {
        int i1= scrabInt.getInt();
        int i2 = getInt();
        return factory.createInt(i1/i2);
    }

    /**
     * {@inheritDoc}
     * @param scrabInt the ScrabInt to subtract
     * @return  a new ScrabInt with the values subtracted
     */
    public ScrabInt minusInt(ScrabInt scrabInt) {
        int i1= scrabInt.getInt();
        int i2 = getInt();
        return factory.createInt(i1-i2);
    }

    /**
     * {@inheritDoc}
     * @param scrabFloat the ScrabFloat to add
     * @return a new ScrabFloat with the values added
     */
    public ScrabFloat addFloat(ScrabFloat scrabFloat) {
        double f1 = toFloat();
        double f2 =scrabFloat.getFloat();
        return factory.createFloat(f1+f2);
    }

    /**
     * {@inheritDoc}
     * @param scrabFloat the ScrabFloat to multiply
     * @return a new ScrabFloat with the values multiplied
     */
    public ScrabFloat multFloat(ScrabFloat scrabFloat) {
        double f1 = toFloat();
        double f2 =scrabFloat.getFloat();
        return factory.createFloat(f1*f2);
    }

    /**
     * {@inheritDoc}
     * @param scrabFloat the ScrabFloat to divide
     * @return a new ScrabFloat with the values divided
     */
    public ScrabFloat divFloat(ScrabFloat scrabFloat) {
        double f1 = toFloat();
        double f2 =scrabFloat.getFloat();
        return factory.createFloat(f2/f1);
    }

    /**
     * {@inheritDoc}
     * @param scrabFloat the ScrabFloat to subtract
     * @return a new ScrabFloat with the values subtracted
     */
    public ScrabFloat minusFloat(ScrabFloat scrabFloat) {
        double f1 = toFloat();
        double f2 =scrabFloat.getFloat();
        return factory.createFloat(f2-f1);
    }






    /**
     * For use in the AST
     * transforms int to Binary
     * and realizes the operation
     * @param logic an Slogic
     * @return an Slogic
     */
    public Slogic and(Slogic logic){
        var Int=this.toScrabBinary();
        return logic.and(Int);
    }

    /**
     * For use in the AST
     * transforms int to Binary
     * and realizes the operation
     * @param logic an Slogic
     * @return an Slogic
     */
    public Slogic or(Slogic logic){
        var Int=this.toScrabBinary();
        return logic.or(Int);
    }






    /** transforms Scrabble int to Scrabble String
     *
     * @return a Scrabble String representing the Scrabble int
     */
    public ScrabString toScrabString(){
        return factory.createString(toString());
    }

    /**
     * copies the ScrabInt
     * @return a new ScrabInt
     */
    public ScrabInt toScrabInt(){return factory.createInt(getInt());}

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
        return factory.createFloat(toFloat());
    }

    /**
     * transforms a ScrabInt to a ScrabBinary
     * @return the ScrabBinary representation of the ScrabInt
     */
    public ScrabBinary toScrabBinary(){
        return factory.createBinary(toBinary(getInt()));
    }

    /**
     * Transforms a ScrabInt to a binary String
     * @return the binary string representation of the ScrabInt
     */
    public String toBinary(int Int){
        int absi = abs(Int);
        var bin = factory.createBinary(positiveIntToBinary(absi));
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
        while (Int>0){
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
        ScrabInt scrabInt = (ScrabInt) o;
        return value == scrabInt.value;
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


