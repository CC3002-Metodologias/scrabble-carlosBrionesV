package classes;

import java.util.Objects;

/**
 * ScrabBoolean Class
 */
public class ScrabBoolean implements Slogic{
    boolean theBool;

    /**
     * constructor of class ScrabBoolean
     * @param b the boolean value
     */
    public ScrabBoolean(boolean b){
        theBool=b;
    }

    /**
     * getter method for ScrabBoolean
     * @return The Boolean value
     */
     public Boolean getBool(){
        return theBool;
    }

    /**
     * Setter method for ScrabBoolean
     * @param Boolean boolean value to remplace
     */
    public void setBool(boolean Boolean){
         theBool=Boolean;
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
        return Objects.hash(theBool);
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
}
