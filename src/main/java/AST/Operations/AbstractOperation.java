package AST.Operations;

public class AbstractOperation {
    Operation op1;
    Operation op2;

    public AbstractOperation(){}

    /**
     * change Operation 1 from Operations
     * @param op the new Operation
     */
    public void setop1(Operation op){
        op1=op;
    }

    /**
     * change Operation 2 from Operations
     * @param op the new Operation
     */
    public void setop2(Operation op){
        op2=op;
    }
}
