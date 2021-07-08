package STypes;

import AST.Operations.AbstractConstant;
import AST.Operation;
import operands.Slogic;
import STypes.Numbers.ScrabBinary;

import java.util.Objects;

/**
 * ScrabBoolean Class
 */
public class ScrabBoolean extends AbstractConstant implements Slogic, ScrabType, Operation {
    boolean value;

    /**
     * constructor of class ScrabBoolean
     * @param b the boolean value
     */
    public ScrabBoolean(boolean b){
        value=b;
    }

    /**
     * getter method for ScrabBoolean
     * @return The Boolean value
     */
     public Boolean getBool(){
        return value;
    }

    /**
     * Setter method for ScrabBoolean
     * @param Boolean boolean value to remplace
     */
    public void setBool(boolean Boolean){
         value=Boolean;
     }

    /**
     * to string for printing purposes
     * @return the string version of the boolean
     */
    @Override
    public String toString() {
        return String.valueOf(getBool());
    }

    /**
     * transforms Scrabble Boolean to Scrabble String
     * @return a Scrabble String representing the Scrabble Boolean
     */
    public ScrabString toScrabString() {
        return new ScrabString(toString());
    }

    /**
     * copies the ScrabBoolean
     * @return a new ScrabBoolean
     */
    public ScrabBoolean toScrabBoolean(){return new ScrabBoolean(getBool());}

    /**
     * negates the value of the ScrabBoolean
     */
    public void neg(){
        setBool(!getBool());
    }

    /**
     * {@inheritDoc}
     * @return ScrabBoolean if logic is a ScrabBoolean or
     *         ScrabBinary if logic is a ScrabBinary
     */
    public Slogic and(Slogic logic){
        return logic.andBool(this);
    }

    /**
     * {@inheritDoc}
     * @return ScrabBoolean if logic is a ScrabBoolean or
     *         ScrabBinary if logic is a ScrabBinary
     */
    public Slogic or(Slogic logic){
        return logic.orBool(this);
    }

    /**
     * {@inheritDoc}
     * @return a ScrabBoolean with the result
     */
    public ScrabBoolean andBool(ScrabBoolean bool) {
        if(bool.getBool() && getBool()){
            return new ScrabBoolean(true);
        }
        else{
            return new ScrabBoolean(false);
        }
    }

    /**
     * {@inheritDoc}
     * @return a ScrabBoolean with the result
     */
    public ScrabBinary andBinary(ScrabBinary binary) {
        ScrabBinary sb = new ScrabBinary("01010");
        if(getBool()){
            sb= new ScrabBinary(binary.getBin());
        }
        else if(!getBool()){
            sb= new ScrabBinary("000");
        }
        return sb;
    }

    /**
     * {@inheritDoc}
     * @return a ScrabBoolean with the result
     */
    public ScrabBoolean orBool(ScrabBoolean bool) {
        if (bool.getBool() || getBool()){
            return new ScrabBoolean(true);
        }
        else{
            return new ScrabBoolean(false);
        }
    }

    /**
     * {@inheritDoc}
     * @return a ScrabBoolean with the result
     */
    public ScrabBinary orBinary(ScrabBinary binary) {
        if (getBool()){
            return new ScrabBinary("1111");
        }
        else{
            return new ScrabBinary(binary.getBin());
        }
    }

    /**
     * hashCode for a ScrabBoolean
     * @return the hashCode of the ScrabBoolean
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
        ScrabBoolean that = (ScrabBoolean) o;
        return getBool() == that.getBool();
    }

    /**
     * to evaluate Operations and Constants
     *
     * @return a AbstractConstant with the value of the Operation or AbstractConstant
     */
    @Override
    public AbstractConstant Eval() {
        return this;
    }
}
