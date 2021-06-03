package classes;

public interface SFloat {

    /**
     * adds a SFloat with a ScrabFloat
     * @param scrabFloat the ScrabFloat to add
     * @return a new ScrabFloat with the values added
     */
    ScrabFloat add(ScrabFloat scrabFloat) ;

    /**
     * multiplies a SFloat with a ScrabFloat
     * @param scrabFloat the ScrabFloat to multiply
     * @return a new ScrabFloat with the values multiplied
     */
    ScrabFloat mult(ScrabFloat scrabFloat) ;

    /**
     * divides a SFloat with a ScrabFloat
     * @param scrabFloat the ScrabFloat to divide
     * @return a new ScrabFloat with the values divided
     */
    ScrabFloat div(ScrabFloat scrabFloat) ;

    /**
     * subtracts a SFloat with a ScrabFloat
     * @param scrabFloat the ScrabFloat to subtract
     * @return a new ScrabFloat with the values subtracted
     */
    ScrabFloat minus(ScrabFloat scrabFloat) ;
}
