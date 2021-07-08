package AST.Operations;

import AST.Operation;
import STypes.Numbers.SNumber;

public class Minus implements Operation {
    Operation minus1;
    Operation minus2;

    /**
     * Constructor
     * @param minus1 Logic Operation 
     * @param minus2 Logic Operation
     */
    Minus(SNumber minus1, SNumber minus2){
        this.minus1 =minus1;
        this.minus2= minus2;
    }



    /**
     * to evaluate Operations and Constants
     *
     * @return a AbstractConstant with the value of the Operation or AbstractConstant
     */
    @Override
    public AbstractConstant Eval() {
        return (AbstractConstant) minus1.Eval().minus((SNumber) minus2.Eval());
    }
}
