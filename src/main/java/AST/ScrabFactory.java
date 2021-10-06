package AST;

import Exceptions.NullException;
import Exceptions.TypeException;
import STypes. *;
import STypes.Numbers. *;

import java.util.HashMap;

/**
 * fabric for ScrabTypes
 */
public class ScrabFactory {
    private final HashMap<String,ScrabString> strings=new HashMap<>();
    private final HashMap<Integer,ScrabInt> ints=new HashMap<>();
    private final HashMap<Double,ScrabFloat> floats=new HashMap<>();
    private final HashMap<Boolean,ScrabBoolean> booleans=new HashMap<>();
    private final HashMap<String,ScrabBinary> binarys=new HashMap<>();
    private final HashMap<String,ScrabType> vars=new HashMap<>();


    /**
     * Constructor
     */
    public ScrabFactory(){}

    /**
     * using a HashMap with the Id as key.
     *      * If Id is not in the HashMap
     *      * it is put in it
     * @param key String with Id
     * @param value ScrapType value
     */
    public void createNewVar(String key, ScrabType value){
        if(!vars.containsKey(key)){
            vars.put(key, value);
        }
    }

    /**
     * create a Var type with the name of the var and this factory as reference
     * @param key the name of the var
     * @return a new Var
     */
    public Var createReference(String key){
        return new Var(key,this);
    }

    /**
     * to get the value of a Var in the factory
     * @param key the name of the Var
     * @return the value of the Var
     */
    public ScrabType getVar(String key){
        return vars.get(key);
    }

    /**
     * using a HashMap with the value as key.
     * If value is not in the HashMap
     * it is put in it
     * @param value a string with the value
     * @return a ScrabString with the value
     */
    public ScrabString createString(String value) {
        if (!strings.containsKey(value)) {
            strings.put(value, new ScrabString(value, this));
        }
        return strings.get(value);
    }

    /**
     * using a HashMap with the value as key.
     * If value is not in the HashMap
     * it is put in it
     * @param value a double with the value
     * @return a ScrabFloat with the value
     */
    public ScrabFloat createFloat(double value){
        if(!floats.containsKey(value)){
            floats.put(value, new ScrabFloat(value,this));
        }
        return floats.get(value);
    }

    /**
     * using a HashMap with the value as key.
     * If value is not in the HashMap
     * it is put in it
     * @param value a int with the value
     * @return a ScrabInt with the value
     */
    public ScrabInt createInt(int value){
        if(!ints.containsKey(value)){
                ints.put(value, new ScrabInt(value,this));
        }
        return ints.get(value);
    }

    /**
     * using a HashMap with the value as key.
     * If value is not in the HashMap
     * it is put in it
     * @param value a boolean with the value
     * @return a ScrabBoolean with the value
     */
    public ScrabBoolean createBoolean(boolean value)  {
        if(!booleans.containsKey(value)){
            booleans.put(value, new ScrabBoolean(value,this));
        }
        return booleans.get(value);
    }

    /**
     * using a HashMap with the value as key.
     * If value is not in the HashMap
     * it is put in it
     * @param value a string with the value
     */
    public ScrabBinary createBinary(String value) {
        if (!binarys.containsKey(value)) {

                binarys.put(value, new ScrabBinary(value, this));

        }
        return binarys.get(value);
    }

}
