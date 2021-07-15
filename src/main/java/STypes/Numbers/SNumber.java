package STypes.Numbers;

import STypes.ScrabType;

/**
 * interface for ScrabBinary and ScrabInt
 */
public interface SNumber extends ScrabType {

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
}
