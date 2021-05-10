package classes;

import java.util.Objects;

public class ScrabBinary extends AbstractScrab {
    String theBin;
    public ScrabBinary(String bin){
        theBin=bin;
    }
    public String getBin(){
        return theBin;
    }
    @Override
    public String toString(){
        return getBin();
    }
    public ScrabString toScrabString(){
        return new ScrabString(toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrabBinary that = (ScrabBinary) o;
        return Objects.equals(theBin, that.theBin);
    }
}
