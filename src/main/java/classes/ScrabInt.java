package classes;

import java.util.Objects;

public class ScrabInt {
    int theInt;

    public ScrabInt(int theInt) {
        this.theInt = theInt;
    }

    private int getInt() {
        return theInt;
    }

    @Override
    public String toString() {
        return Integer.toString(this.getInt());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrabInt scrabInt = (ScrabInt) o;
        return theInt == scrabInt.theInt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(theInt);
    }
}


