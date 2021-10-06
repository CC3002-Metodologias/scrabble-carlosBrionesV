package AST.Operations;

import STypes.ScrabType;

/**
 * Div class for AST
 */
public class Div extends AbstractOperation   implements Operation {
    Operation op1;
    Operation op2;

    /**
     * Constructor
     * @param op1 Logic Operation 
     * @param op2 Logic Operation
     */
    public Div(Operation op1, Operation op2){
        this.op1 =op1;
        this.op2= op2;
    }

    /**
     * Constructor Div empty
     */
    public Div(){}

    /**
     * to evaluate Operations and Constants
     *
     * @return a ScrabType with the value of the Operation or ScrabType
     */
    @Override
    public ScrabType Eval() {
        return  op1.Eval().Div( op2.Eval());
    }

}
