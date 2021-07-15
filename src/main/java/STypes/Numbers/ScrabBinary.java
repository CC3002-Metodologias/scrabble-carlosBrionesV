package STypes.Numbers;


import AST.Operation;
import AST.ScrabFactory;
import STypes.AbstracType;
import STypes.ScrabType;
import operands.BinaryOperand;
import operands.Slogic;
import STypes.ScrabBoolean;
import STypes.ScrabString;

import java.util.Objects;

/**
 * Scrabble Binary class
 */
public class ScrabBinary extends AbstracType implements BinaryOperand, Slogic, SNumber {
    String value;
    ScrabFactory factory;

    /** constructor of class ScrabBinary
     *
     * @param bin String of 0s and 1s if its length is  less than 32 bit
     *            it will be filled with 1s or 0s
     */
    public ScrabBinary(String bin, ScrabFactory factory){
        this.factory=factory;
        var str = new StringBuilder(bin);
            str.reverse();
            if (bin.charAt(0)=='0') {
                while (str.length() < 32) {
                    str.append(0);
                }
            }
            else{
                while (str.length() < 32) {
                    str.append(1);
                }
            }
            str.reverse();
        value=str.toString();
    }

    /**
     * getter of the binary number
     * @return the Binary number as a String
     */
    public String getBin(){
        return value;
    }

    /**
     * setter method of the ScrabBinary
     * @param bin the binary string to remplace
     */
    public void setBin(String bin){
        value=factory.createBinary(bin).getBin();
    }

    /**
     * to String for printing purposes
     * @return the binary number as a String
     */
    @Override
    public String toString(){
        return getBin();
    }

    /**
     * transforms the ScrabBinary to ScrabString
     * @return a Scrabble String representing the ScrabBinary
     */
    public ScrabString toScrabString(){
        return factory.createString(toString());
    }

    /**
     * copies the ScrabBinary
     * @return a new ScrabBinary
     */
    public ScrabBinary toScrabBinary(){return factory.createBinary(toString());}

    /**
     * turns a binary String into a int
     * @param binary a binary string to transform
     * @return the int representation of binary
     */
    public int toInt(String binary) {
        if (getBin().charAt(0) == '0') {
            return positiveBinToInt(binary);
        } else {
            return negativeBinaryToInt(binary);
        }
    }

    /**
     * transforms a negative binary string to int
     * @param binary the binary string to transform
     * @return an int representing the binary string
     */
    private int negativeBinaryToInt(String binary) {
        int n = binary.length() - 1;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for (int i = n, j = 0; i >= 0; i--, j++) {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
        }
        return -w;
    }

    /**
     * transforms a positive binary string to int
     * @param binary the binary string to transform
     * @return an int representing the binary string
     */
    private int positiveBinToInt(String binary) {
        int w = 0;
        for (int i = binary.length() - 1, j = 0; i >= 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }

    /**
     * transforms a char '0' or '1' to int
     * @param bit the bit to transform
     * @return an int representing the bit
     */
    private int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }

    /**
     * turns a ScrabBinary into a ScrabInt
     * @return the ScrabInt representation of the ScrabBinary
     */
    public ScrabInt toScrabInt(){
         return factory.createInt(toInt(getBin()));
    }

    /**
     * turns a ScrabBinary into a double
     * @return the double representation of the ScrabBinary
     */
    public double toFloat(){
        return toInt(getBin());
    }

    /**
     * turns a ScrabBinary into a ScrabFloat
     * @return the ScrabFloat representation of the ScrabBinary
     */
    public ScrabFloat toScrabFloat(){
        return factory.createFloat(toFloat());
    }

    /**
     * calculates the twos complement of the ScrabBinary
     * @return a ScrabBinary representing the twos complement of the current ScrabBinary
     */
    public ScrabBinary twosComplement(){
         String str = this.neg().getBin();
         StringBuilder sum = new StringBuilder();
         int carry=1;
         for(int i = 31; i>=0; i--){
             int m = bitToInt(str.charAt(i));
             int add = m + carry;
             sum.append(add % 2);
             carry = add / 2;
         }

        return factory.createBinary(sum.reverse().toString());
    }

    /**
     * negates each bit of the ScrabBinary
     */
    public ScrabBinary neg(){
        String str = getBin();
        str = str.replace('0','2').replace('1','0').replace('2','1');
        return factory.createBinary(str);
    }

    /**
     * method for addition
     * @param scrab a ScrabBinary or a ScrabInt
     * @return a new ScrabBinary with the values added
     */
    public ScrabType add(BinaryOperand scrab){
        return scrab.addBinary(this);
    }

    /**
     * method for multiplication
     * @param scrab a ScrabBinary or a ScrabInt
     * @return a new ScrabBinary with the values multiplicated
     */
    public ScrabType mult(BinaryOperand scrab){
        return scrab.multBinary(this);
    }

    /**
     * method for division
     * @param scrab a ScrabBinary or a ScrabInt
     * @return a new ScrabBinary with the values divided
     */
    public ScrabType div(BinaryOperand scrab){
        return scrab.divBinary(this);
    }

    /**
     * method for subtraction
     * @param scrab a ScrabBinary or a ScrabInt
     * @return a new ScrabBinary with the values subtracted
     */
    public ScrabType minus(BinaryOperand scrab){
        return scrab.minusBinary(this);
    }

    /**
     * add two ScrabBinarys
     * @param binary the ScrabBinary value to add
     * @return a new ScrabBinary with the values added
     */
    public ScrabBinary addBinary(ScrabBinary binary) {
        int i1=toInt(getBin());
        int i2=toInt(binary.getBin());
        var si=factory.createInt(i1+i2);
        return si.toScrabBinary();
    }

    /**
     * multiplies two ScrabBinarys
     * @param binary the ScrabBinary value to multiplicate
     * @return a new ScrabBinary with the values multiplicated
     */
    public ScrabBinary multBinary(ScrabBinary binary){
        int i1 = toInt(getBin());
        int i2 = toInt(binary.getBin());
        ScrabInt si = factory.createInt(i1*i2);


        return si.toScrabBinary();

    }

    /**
     * division of two ScrabBinarys
     * @param binary the ScrabBinary value to divide
     * @return a new ScrabBinary with the values divided
     */
    public ScrabBinary divBinary(ScrabBinary binary){
        int i1 = toInt(getBin());
        int i2 = toInt(binary.getBin());
        ScrabInt si = factory.createInt(i2/i1);
        return si.toScrabBinary();

    }

    /**
     * subtract two ScrabBinarys
     * @param binary the ScrabBinary value to subtract
     * @return a new ScrabBinary with the values subtracted
     */
    public ScrabBinary minusBinary(ScrabBinary binary){
        int i1 = toInt(getBin());
        int i2 = toInt(binary.getBin());
        ScrabInt si = factory.createInt(i2-i1);
        return si.toScrabBinary();
    }

    /**
     * add a ScrabBinary with a ScrabInt
     * @param Int the ScrabInt to add
     * @return a new ScrabInt with the values added
     */
    public ScrabInt addInt(ScrabInt Int) {
        int i1 = toInt(getBin());
        int i2 = Int.getInt();
        return factory.createInt(i1+i2);
    }

    /**
     * multiplies a ScrabBinary with a ScrabInt
     * @param Int the ScrabInt to multiply
     * @return a new ScrabInt with the values multiplied
     */
    public ScrabInt multInt(ScrabInt Int){
        int i1 = toInt(getBin());
        int i2 = Int.getInt();
        return factory.createInt(i1*i2);
    }

    /**
     * divides a ScrabBinary with a ScrabInt
     * @param Int the ScrabInt to divide
     * @return a new ScrabInt with the values divided
     */
    public ScrabInt divInt(ScrabInt Int){
        int i1 = toInt(getBin());
        int i2 = Int.getInt();

        return factory.createInt(i2/i1);

    }

    /**
     * subtract a ScrabBinary with a ScrabInt
     * @param Int the ScrabInt to subtract
     * @return a new ScrabFloat with the values subtracted
     */
    public ScrabInt minusInt(ScrabInt Int){
        int i1 = toInt(getBin());
        int i2 = Int.getInt();
        return factory.createInt(i2-i1);
    }

    /**
     * {@inheritDoc}
     */
    public ScrabFloat addFloat(ScrabFloat Float) {
        double f1 = toFloat();
        double f2 =Float.getFloat();
        return factory.createFloat(f1+f2);
    }

    /**
     * {@inheritDoc}
     */
    public ScrabFloat multFloat(ScrabFloat Float) {
        double f1 = toFloat();
        double f2 =Float.getFloat();
        return factory.createFloat(f1*f2);
    }

    /**
     * {@inheritDoc}
     */
    public ScrabFloat divFloat(ScrabFloat Float) {
        double f1 = toFloat();
        double f2 =Float.getFloat();
        return factory.createFloat(f2/f1);
    }

    /**
     * subtract a ScrabFloat
     * @param Float the ScrabFloat to subtract
     * @return a new ScrabInt with the values subtracted
     */
    public ScrabFloat minusFloat(ScrabFloat Float) {
        double f1 = toFloat();
        double f2 =Float.getFloat();
        return factory.createFloat(f2-f1);
    }

    /**
     * {@inheritDoc}
     * @return a ScrabBinary
     */
    public ScrabBinary and(Slogic logic) {
        return (ScrabBinary) logic.andBinary(this);
    }

    /**
     * {@inheritDoc}
     * @return a ScrabBinary
     */
    public ScrabBinary or(Slogic logic) {
        return (ScrabBinary) logic.orBinary(this);
    }

    /**
     * {@inheritDoc}
     * @param bool ScrabBoolean value to compare
     * @return a ScrabBinary
     */
    public ScrabBinary andBool(ScrabBoolean bool) {
        if(bool.getBool()){
            return factory.createBinary(getBin());
        }
        else{
            return factory.createBinary("000");
        }
    }

    /**
     * {@inheritDoc}
     * @param binary ScrabBinary value to compare
     * @return a ScrabBinary
     */
    public ScrabBinary andBinary(ScrabBinary binary) {
        StringBuilder str = new StringBuilder();
        int len=32;
        for(int i=0;i<len;i++){
            char i1 = getBin().charAt(len-i-1);
            char i2 = binary.getBin().charAt(len-i-1);
            if(i1=='1' && i2=='1'){
                str.append(1);
            }
            else{
                str.append(0);
            }
        }
        return factory.createBinary(str.reverse().toString());
    }

    /**
     * {@inheritDoc}
     * @param bool ScrabBoolean value to compare
     * @return a ScrabBinary
     */
    public ScrabBinary orBool(ScrabBoolean bool) {
        if (bool.getBool()){
            return factory.createBinary("1111");
        }
        else{
            return factory.createBinary(getBin());
        }
    }

    /**
     * {@inheritDoc}
     * @param binary ScrabBinary value to compare
     * @return a ScrabBinary
     */
    public ScrabBinary orBinary(ScrabBinary binary) {
        StringBuilder str = new StringBuilder();
        int len=32;
        for(int i=0;i<len;i++){
            char i1 = getBin().charAt(i);
            char i2 = binary.getBin().charAt(i);
            if(i1=='1' || i2=='1'){
                str.append(1);
            }
            else{
                str.append(0);
            }
        }
        return factory.createBinary(str.toString());
    }

    /**
     * hashCode for a ScrabBinary
     * @return the hashCode of the ScrabBinary
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
        ScrabBinary that = (ScrabBinary) o;
        return Objects.equals(value, that.value);
    }




    /**
     * logic operation and
     *
     * @param cons Logic ScrabType
     * @return ScrabType with the result
     */
    @Override
    public Slogic And(Operation cons) {
        return this.and((Slogic)cons);
    }

    /**
     * logic operation or
     *
     * @param cons Logic ScrabType
     * @return ScrabType with the result
     */
    @Override
    public Slogic Or(Operation cons) {
        return this.or((Slogic)cons);
    }

    /**
     * addition operation
     *
     * @param cons number constant
     * @return ScrabType with the result
     */
    @Override
    public ScrabType Add(Operation cons) {
        return this.add((BinaryOperand) cons);
    }
    /**
     * subtraction operation
     *
     * @param cons number ScrabType
     * @return ScrabType with the result
     */
    @Override
    public ScrabType Minus(Operation cons) {
        return this.minus((BinaryOperand) cons);
    }

    /**
     * division operation
     *
     * @param cons Number ScrabType
     * @return ScrabType with the result
     */
    @Override
    public ScrabType Div(Operation cons) {
        return this.div((BinaryOperand) cons);
    }

    /**
     * miltiplication operation
     *
     * @param cons Number ScrabType
     * @return ScrabType with the result
     */
    @Override
    public ScrabType Mult(Operation cons) {
        return this.mult((BinaryOperand) cons);
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
