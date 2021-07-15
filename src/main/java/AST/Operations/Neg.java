package AST.Operations;
import AST.Operation;
import STypes.ScrabType;


/**
 * Neg class for AST
 */
public class Neg implements Operation{

    Operation neg1;

    /**
     * Constructor
     * @param neg1 Operation
     */
    public Neg(Operation neg1){
        this.neg1 =neg1;
    }

    /**
     * to evaluate Operations and Constants
     *
     * @return a ScrabType with the value of the Operation or ScrabType
     */
    @Override
    public ScrabType Eval() {
        return  neg1.Eval().Neg();
    }
}
