package AST.Operations;

import AST.Operation;
import STypes.Numbers.SNumber;
import STypes.ScrabType;

/**
 * Mult class for AST
 */
public class Mult implements Operation {
    Operation mult1;
    Operation mult2;

    /**
     * Constructor
     * @param mult1 Logic Operation 
     * @param mult2 Logic Operation
     */
    public Mult(Operation mult1, Operation mult2){
        this.mult1 =mult1;
        this.mult2= mult2;
    }

    /**
     * to evaluate Operations and Constants
     *
     * @return a ScrabType with the value of the Operation or ScrabType
     */
    @Override
    public ScrabType Eval() {
        return mult1.Eval().Mult( mult2.Eval());
    }
}
