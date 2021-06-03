package classes;

import java.util.Objects;

/**
 * Scrabble Binary Class
 */
public class ScrabBinary extends AbstractScrab {
    String theBin;

    /**
     * constructor of class ScrabBinary
     * @param bin String of 0s and 1s
     */
    public ScrabBinary(String bin){
        theBin=bin;
    }

    /**
     * getter of the binary number
     * @return the Binary number as a String
     */
    public String getBin(){
        return theBin;
    }

    /**
     * change the value of the ScrabBinary
     * @param theBin the new binary value
     */
    public void setBin(String theBin) {
        this.theBin = theBin;
    }


    /**
     * to String for printing purposes
     * @return the binary number as a String
     */
    @Override
    public String toString(){
        return getBin();
    }

    /**
     * constructor of class ScrabBinary
     * @return a Scrabble String of the Binary number
     */
     public ScrabString toScrabString(){
        return new ScrabString(toString());
    }

    /**
     * check if the object is equal
     * @param o object to compare to
     * @return a boolean stating if o and this are equals
     */
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrabBinary that = (ScrabBinary) o;
        return Objects.equals(theBin, that.theBin);
    }
}
