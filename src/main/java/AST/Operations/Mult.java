package AST.Operations;

import AST.Operation;
import STypes.Numbers.SNumber;

public class Mult implements Operation {
    Operation mult1;
    Operation mult2;

    /**
     * Constructor
     * @param mult1 Logic Operation 
     * @param mult2 Logic Operation
     */
    Mult(SNumber mult1, SNumber mult2){
        this.mult1 =mult1;
        this.mult2= mult2;
    }

    /**
     * to evaluate Operations and Constants
     *
     * @return a AbstractConstant with the value of the Operation or AbstractConstant
     */
    @Override
    public AbstractConstant Eval() {
        return (AbstractConstant) mult1.Eval().mult((SNumber) mult2.Eval());
    }
}
