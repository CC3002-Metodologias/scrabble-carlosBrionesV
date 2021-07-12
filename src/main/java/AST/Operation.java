package AST;


import STypes.ScrabType;

/**
 * common interface for AST
 */
public interface Operation {

    /**
     * to evaluate Operations and Constants
     * @return a ScrabType with the value of the Operation or ScrabType
     */
    ScrabType Eval();
}
