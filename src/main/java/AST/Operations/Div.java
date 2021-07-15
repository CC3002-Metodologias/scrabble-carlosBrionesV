package AST.Operations;

import AST.Operation;
import STypes.Numbers.SNumber;
import STypes.ScrabType;

/**
 * Div class for AST
 */
public class Div implements Operation {
    Operation div1;
    Operation div2;

    /**
     * Constructor
     * @param div1 Logic Operation 
     * @param div2 Logic Operation
     */
    public Div(Operation div1, Operation div2){
        this.div1 =div1;
        this.div2= div2;
    }

    /**
     * to evaluate Operations and Constants
     *
     * @return a ScrabType with the value of the Operation or ScrabType
     */
    @Override
    public ScrabType Eval() {
        return  div1.Eval().Div( div2.Eval());
    }
}
