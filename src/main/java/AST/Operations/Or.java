package AST.Operations;

import STypes.ScrabType;

/**
 * Or class for AST
 */
public class Or extends AbstractOperation   implements Operation {
    Operation op1;
    Operation op2;

    /**
     * Constructor
     * @param op1 Logic Operation 
     * @param op2 Logic Operation
     */
    public Or(Operation op1, Operation op2){
        this.op1 =op1;
        this.op2= op2;
    }

    /**
     * Constructor Or empty
     */
    public Or(){}

    /**
     * to evaluate Operations and Constants
     *
     * @return a ScrabType with the value of the Operation or ScrabType
     */
    @Override
    public ScrabType Eval() {
        return  op1.Eval().Or(op2.Eval());
    }
}
