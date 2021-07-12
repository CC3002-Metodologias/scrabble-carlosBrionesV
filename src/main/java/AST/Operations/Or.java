package AST.Operations;

import AST.Operation;
import STypes.ScrabType;
import operands.Slogic;

/**
 * Or class for AST
 */
public class Or implements Operation {
    Operation or1;
    Operation or2;

    /**
     * Constructor
     * @param or1 Logic Operation 
     * @param or2 Logic Operation
     */
    public Or(Operation or1, Operation or2){
        this.or1 =or1;
        this.or2= or2;
    }

    /**
     * to evaluate Operations and Constants
     *
     * @return a ScrabType with the value of the Operation or ScrabType
     */
    @Override
    public ScrabType Eval() {
        return  or1.Eval().Or(or2.Eval());
    }
}
