package STypes;

import AST.Operation;
import STypes.Numbers.SNumber;
import operands.Slogic;

/**
 * Generic Scrabble Type
 */
public interface ScrabType extends Operation {
    ScrabString toScrabString();

    /**
     * logic operation and for AST
     *
     * @param cons Logic ScrabType
     * @return ScrabType with the result
     */
    Slogic And(Operation cons);

    /**
     * logic operation or for AST
     *
     * @param cons Logic ScrabType
     * @return ScrabType with the result
     */
    Slogic Or(Operation cons);

    /**
     * addition operation for AST
     *
     * @param cons number constant
     * @return ScrabType with the result
     */
    ScrabType Add (Operation cons);

    /**
     * subtraction operation for AST
     *
     * @param cons number ScrabType
     * @return ScrabType with the result
     */
    ScrabType Minus(Operation cons);

    /**
     * division operation for AST
     *
     * @param cons Number ScrabType
     * @return ScrabType with the result
     */
    ScrabType Div(Operation cons);

    /**
     * miltiplication operation for AST
     *
     * @param cons Number ScrabType
     * @return ScrabType with the result
     */
    ScrabType Mult(Operation cons);

    /**
     * negation operation for AST
     *
     * @return ScrabType with the result
     */
    ScrabType Neg();
}
