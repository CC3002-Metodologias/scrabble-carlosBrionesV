package AST.Operations;

import AST.Operation;
import STypes.ScrabType;
import operands.Slogic;

/**
 * And class for AST
 */
public class And implements Operation {
    Operation and1;
    Operation and2;

    /**
     * Constructor
     * @param and1 Logic Operation
     * @param and2 Logic Operation
     */
    public And(Operation and1, Operation and2){
        this.and1 =and1;
        this.and2= and2;
    }

    /**
     * to evaluate Operations and Constants
     *
     * @return a ScrabType with the value of the Operation or ScrabType
     */
    @Override
    public ScrabType Eval() {
        return  and1.Eval().And( and2.Eval());
    }
}
