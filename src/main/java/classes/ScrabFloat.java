package classes;

import java.util.Objects;

public class ScrabFloat  extends AbstractScrab {
    double theDouble;
    public ScrabFloat(double d){
        theDouble=d;
    }

    public double getFloat(){
        return theDouble;
    }

    @Override
    public String toString(){
        return String.valueOf(this.getFloat());
    }

    public ScrabString toScrabString(){
        return new ScrabString(toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrabFloat that = (ScrabFloat) o;
        return Double.compare(that.theDouble, theDouble) == 0;
    }
}
