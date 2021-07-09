package AST;

import STypes. *;
import STypes.Numbers. *;


public class ScrabFactory {
    public ScrabFactory(){}

    public ScrabString createString(String value){
        return new ScrabString(value);
    }
    public ScrabFloat createFloat(double value){
        return new ScrabFloat(value);
    }
    public ScrabInt createInt(int value){
        return new ScrabInt(value);
    }
    public ScrabBoolean createBoolean(boolean value){
        return new ScrabBoolean(value);
    }
    public ScrabBinary createBinary(String value){
        return new ScrabBinary(value);
    }
}
