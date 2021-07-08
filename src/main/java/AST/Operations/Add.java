package AST.Operations;

import AST.Operation;
import STypes.ScrabType;
import operands.Slogic;

public class Add implements Operation {

    Operation add1;
    Operation add2;

    /**
     * Constructor
     * @param add1 Logic Operation 
     * @param add2 Logic Operation
     */
    Add(Slogic add1, Slogic add2){
        this.add1 =add1;
        this.add2= add2;
    }

    /**
     * to evaluate Operations and Constants
     *
     * @return a AbstractConstant with the value of the Operation or AbstractConstant
     */
    @Override
    public AbstractConstant Eval() {
        return (AbstractConstant) add1.Eval().add((ScrabType) add2.Eval());
    }
}
