package AST.Operations;

import AST.Operation;
import STypes.Numbers.SNumber;

public class Div implements Operation {
    Operation div1;
    Operation div2;

    /**
     * Constructor
     * @param div1 Logic Operation 
     * @param div2 Logic Operation
     */
    Div(SNumber div1, SNumber div2){
        this.div1 =div1;
        this.div2= div2;
    }

    /**
     * to evaluate Operations and Constants
     *
     * @return a AbstractConstant with the value of the Operation or AbstractConstant
     */
    @Override
    public AbstractConstant Eval() {
        return (AbstractConstant) div1.Eval().div((SNumber) div2.Eval());
    }
}
