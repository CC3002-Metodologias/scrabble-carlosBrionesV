package AST.Operations;
import STypes.ScrabType;


/**
 * Neg class for AST
 */
public class Neg extends AbstractOperation   implements Operation{

    Operation op1;

    /**
     * Constructor
     * @param op1 Operation
     */
    public Neg(Operation op1){
        this.op1 =op1;
    }

    /**
     * Constructor Neg empty
     */
    public Neg(){}

    /**
     * to evaluate Operations and Constants
     *
     * @return a ScrabType with the value of the Operation or ScrabType
     */
    @Override
    public ScrabType Eval() {
        return  op1.Eval().Neg();
    }

    @Override
    public void setop2(Operation op){}
}
