package classes;

import java.util.Objects;

public class ScrabInt extends AbstractScrab {
    int theInt;

    public ScrabInt(int theInt) {
        this.theInt = theInt;
    }

    private int getInt() {
        return theInt;
    }

    public int toInt(){
        return getInt();
    }
    @Override
    public String toString() {
        return String.valueOf(toInt());
    }

    public ScrabString toScrabString(){
        return new ScrabString(toString());
    }

    public double toFloat(){
        return (double) Float.valueOf(toString());
    }

    public ScrabFloat toScrabFloat(){
        return new ScrabFloat(toFloat());
    }









    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrabInt scrabInt = (ScrabInt) o;
        return theInt == scrabInt.theInt;
    }
}


