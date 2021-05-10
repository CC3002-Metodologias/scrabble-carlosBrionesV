package classes;

import java.util.Objects;

public class ScrabBoolean extends AbstractScrab{
    boolean theBool;
    public ScrabBoolean(boolean b){
        theBool=b;
    }
    private Boolean getBool(){
        return theBool;
    }

    @Override
    public String toString() {
        return String.valueOf(getBool());
    }

    public ScrabString toScrabString(){
        return new ScrabString(toString());
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrabBoolean that = (ScrabBoolean) o;
        return getBool() == that.getBool();
    }
}
