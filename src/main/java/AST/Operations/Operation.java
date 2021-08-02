package AST.Operations;


import AST.AST;
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

    /**
     * change Operation 1 from Operations
     * @param op the new Operation
     */
    public void setop1(Operation op);

    /**
     * change Operation 2 from Operations
     * @param op the new Operation
     */
    public void setop2(Operation op);
}
