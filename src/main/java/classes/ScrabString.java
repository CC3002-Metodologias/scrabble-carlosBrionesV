package classes;

import java.util.Objects;

public class ScrabString extends AbstractScrab {
    String theStr;
    public ScrabString(String str){
        theStr=str;
    }

    @Override
    public String toString() {
        return theStr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrabString that = (ScrabString) o;
        return Objects.equals(toString(), that.toString());
    }
}


