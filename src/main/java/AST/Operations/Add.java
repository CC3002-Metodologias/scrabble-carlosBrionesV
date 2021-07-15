package AST.Operations;

import AST.Operation;
import STypes.ScrabType;

/**
 * Add class for AST
 */
public class Add implements Operation {
    Operation add1;
    Operation add2;

    /**
     * Constructor
     * @param add1 Logic Operation 
     * @param add2 Logic Operation
     */
    public Add(Operation add1, Operation add2){
        this.add1 =add1;
        this.add2= add2;
    }

    /**
     * to evaluate Operations and Constants
     *
     * @return a ScrabType with the value of the Operation or ScrabType
     */
    @Override
    public ScrabType Eval() {
        return (add1.Eval().Add(add2.Eval()));
    }
}
