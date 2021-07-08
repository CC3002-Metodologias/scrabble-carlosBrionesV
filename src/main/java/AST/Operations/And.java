package AST.Operations;

import AST.Operation;
import operands.Slogic;

public class And implements Operation {
    Operation and1;
    Operation and2;

    /**
     * Constructor
     * @param and1 Logic Operation
     * @param and2 Logic Operation
     */
    And(Slogic and1, Slogic and2){
        this.and1 =and1;
        this.and2= and2;
    }

    /**
     * to evaluate Operations and Constants
     *
     * @return a AbstractConstant with the value of the Operation or AbstractConstant
     */
    @Override
    public AbstractConstant Eval() {
        return (AbstractConstant) and1.Eval().and((Slogic) and2.Eval());
    }
}
