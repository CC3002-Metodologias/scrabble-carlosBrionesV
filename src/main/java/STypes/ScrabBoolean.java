package STypes;

import AST.Operation;
import AST.ScrabFactory;
import operands.Slogic;
import STypes.Numbers.ScrabBinary;

import java.util.Objects;

/**
 * ScrabBoolean Class
 */
public class ScrabBoolean extends AbstracType implements Slogic, ScrabType {
    boolean value;
    ScrabFactory factory;

    /**
     * constructor of class ScrabBoolean
     * @param b the boolean value
     */
    public ScrabBoolean(boolean b,ScrabFactory factory){
        this.factory=factory;
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
        return factory.createString(toString());
    }

    /**
     * copies the ScrabBoolean
     * @return a new ScrabBoolean
     */
    public ScrabBoolean toScrabBoolean(){return factory.createBoolean(getBool());}

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
            return factory.createBoolean(true);
        }
        else{
            return factory.createBoolean(false);
        }
    }

    /**
     * {@inheritDoc}
     * @return a ScrabBoolean with the result
     */
    public ScrabBinary andBinary(ScrabBinary binary) {
        ScrabBinary sb = factory.createBinary("01010");
        if(getBool()){
            sb= factory.createBinary(binary.getBin());
        }
        else if(!getBool()){
            sb= factory.createBinary("000");
        }
        return sb;
    }

    /**
     * {@inheritDoc}
     * @return a ScrabBoolean with the result
     */
    public ScrabBoolean orBool(ScrabBoolean bool) {
        if (bool.getBool() || getBool()){
            return factory.createBoolean(true);
        }
        else{
            return factory.createBoolean(false);
        }
    }

    /**
     * {@inheritDoc}
     * @return a ScrabBoolean with the result
     */
    public ScrabBinary orBinary(ScrabBinary binary) {
        if (getBool()){
            return factory.createBinary("1111");
        }
        else{
            return factory.createBinary(binary.getBin());
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
     * logic operation and for AST
     *
     * @param cons Logic ScrabType
     * @return ScrabType with the result
     */
    @Override
    public Slogic And(Operation cons) {
        return this.and((Slogic)cons);
    }

    /**
     * logic operation or for AST
     *
     * @param cons Logic ScrabType
     * @return ScrabType with the result
     */
    @Override
    public Slogic Or(Operation cons) {
        return this.or((Slogic)cons);
    }







}
