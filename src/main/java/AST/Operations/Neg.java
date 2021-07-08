package AST.Operations;
import AST.Operation;
import STypes.ScrabType;


public class Neg implements Operation{

    Operation neg1;

    /**
     * Constructor
     * @param neg1 Logic Operation 
     * @param neg2 Logic Operation
     */
    Neg(ScrabType neg1, ScrabType neg2){
        this.neg1 =neg1;
    }
    /**
     * to evaluate Operations and Constants
     *
     * @return a AbstractConstant with the value of the Operation or AbstractConstant
     */
    @Override
    public AbstractConstant Eval() {
        return (AbstractConstant) neg1.Eval().neg();
    }
}
