package classes;

/**
 * interface for ScrabBinary and ScrabInt
 */
public interface SNumber{

    /**
     * Method for addition
     * @param scrab a ScrabInt or a ScrabBinary
     * @return a SNumber
     */
    SNumber add(SNumber scrab);

    /**
     * Method for subtraction
     * @param scrab a ScrabInt or a ScrabBinary
     * @return a ScrabFloat
     */
    SNumber minus(SNumber scrab);

    /**
     * Method for multiplication
     * @param scrab a ScrabInt or a ScrabBinary
     * @return a ScrabFloat
     */
    SNumber mult(SNumber scrab);

    /**
     * Method for division
     * @param scrab a ScrabInt or a ScrabBinary
     * @return a ScrabFloat
     */
    SNumber div(SNumber scrab);

    /**
     * add a SNumber with a ScrabFloats
     * @param scrabFloat the ScrabFloat to add
     * @return a new ScrabFloat with the values added
     */
    ScrabFloat addFloat(ScrabFloat scrabFloat);

    /**
     * subtracts a SNumber with a ScrabFloats
     * @param scrabFloat the ScrabFloat to subtract
     * @return a new ScrabFloat with the values subtracted
     */
    ScrabFloat minusFloat(ScrabFloat scrabFloat);

    /**
     * multiplies a SNumber with a ScrabFloats
     * @param scrabFloat the ScrabFloat to multiply
     * @return a new ScrabFloat with the values multiplied
     */
    ScrabFloat multFloat(ScrabFloat scrabFloat);

    /**
     * divides a SNumber with a ScrabFloats
     * @param scrabFloat the ScrabFloat to divide
     * @return a new ScrabFloat with the values divided
     */
    ScrabFloat divFloat(ScrabFloat scrabFloat);

    /**
     * add a SNumber with a ScrabInt
     * @param scrabInt the ScrabInt to add
     * @return a new SNumber with the values added
     */
    SNumber addInt(ScrabInt scrabInt);

    /**
     * multiplies a SNumber with a ScrabInt
     * @param scrabInt the ScrabInt to multiply
     * @return a new SNumber with the values multiplied
     */
    SNumber multInt(ScrabInt scrabInt);

    /**
     * divides a SNumber with a ScrabInt
     * @param scrabInt the ScrabInt to divide
     * @return a new SNumber with the values divided
     */
    SNumber divInt(ScrabInt scrabInt);

    /**
     * subtracts a SNumber with a ScrabInt
     * @param scrabInt the ScrabInt to subtract
     * @return a new SNumber with the values subtracted
     */
    SNumber minusInt(ScrabInt scrabInt);

    /**
     * add a SNumber with a ScrabBinary
     * @param binary the ScrabBinary to add
     * @return a new ScrabBinary with the values added
     */
    ScrabBinary addBinary(ScrabBinary binary);

    /**
     * multiplies a SNumber with a ScrabBinary
     * @param binary the ScrabBinary to multiply
     * @return a new ScrabBinary with the values multiplied
     */
    ScrabBinary multBinary(ScrabBinary binary);

    /**
     * divides a SNumber with a ScrabBinary
     * @param binary the ScrabBinary to divide
     * @return a new ScrabBinary with the values divided
     */
    ScrabBinary divBinary(ScrabBinary binary);

    /**
     * subtracts a SNumber with a ScrabBinary
     * @param binary the ScrabBinary to subtract
     * @return a new ScrabBinary with the values subtracted
     */
    ScrabBinary minusBinary(ScrabBinary binary);
}
