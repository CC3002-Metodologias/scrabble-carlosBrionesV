package AST.Operations;

import STypes.ScrabType;

/**
 * And class for AST
 */
public class And extends AbstractOperation  implements Operation {
    Operation op1;
    Operation op2;

    /**
     * Constructor
     * @param op1 Logic Operation
     * @param op2 Logic Operation
     */
    public And(Operation op1, Operation op2){
        this.op1 =op1;
        this.op2= op2;
    }
    
    /**
     * Constructor And empty
     */
    public And(){}

    /**
     * to evaluate Operations and Constants
     *
     * @return a ScrabType with the value of the Operation or ScrabType
     */
    @Override
    public ScrabType Eval() {
        return  op1.Eval().And( op2.Eval());
    }

}
