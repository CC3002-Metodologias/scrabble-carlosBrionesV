package AST.Operations;

import AST.Operation;
import operands.Slogic;

public class Or implements Operation {
    Operation or1;
    Operation or2;

    /**
     * Constructor
     * @param or1 Logic Operation 
     * @param or2 Logic Operation
     */
    Or(Slogic or1, Slogic or2){
        this.or1 =or1;
        this.or2= or2;
    }

    /**
     * to evaluate Operations and Constants
     *
     * @return a AbstractConstant with the value of the Operation or AbstractConstant
     */
    @Override
    public AbstractConstant Eval() {
        return (AbstractConstant) or1.Eval().or((Slogic) or2.Eval());
    }
}
