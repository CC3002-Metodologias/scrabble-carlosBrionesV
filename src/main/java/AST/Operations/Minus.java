package AST.Operations;

import AST.Operation;
import STypes.ScrabType;


/**
 * Minus class for AST
 */
public class Minus implements Operation {
    Operation minus1;
    Operation minus2;

    /**
     * Constructor
     * @param minus1 Logic Operation 
     * @param minus2 Logic Operation
     */
    public Minus(Operation minus1, Operation minus2){
        this.minus1 =minus1;
        this.minus2= minus2;
    }

    /**
     * to evaluate Operations and Constants
     *
     * @return a ScrabType with the value of the Operation or ScrabType
     */
    @Override
    public ScrabType Eval() {
        return minus1.Eval().Minus(minus2.Eval());
    }
}
