package AST.Operations;

import AST.Operation;
import STypes.Numbers.SNumber;
import STypes.ScrabType;
import operands.Slogic;

public abstract class AbstractConstant implements Operation {
    /**
     * logic operation and
     * @param cons Logic AbstractConstant
     * @return AbstractConstant with the result
     */
    Slogic and(Slogic cons){return null;}

    /**
     *logic operation or
     * @param cons Logic AbstractConstant
     * @return AbstractConstant with the result
     */
    Slogic or(Slogic cons){return null;}

    /**
     * addition operation
     * @param cons number constant
     * @return AbstractConstant with the result
     */
    ScrabType add(ScrabType cons){return null;}

    /**
     * subtraction operation
     * @param cons number AbstractConstant
     * @return AbstractConstant with the result
     */
    SNumber minus(SNumber cons){return null;}

    /**
     * division operation
     * @param cons Number AbstractConstant
     * @return AbstractConstant with the result
     */
    SNumber div(SNumber cons){return null;}

    /**
     * miltiplication operation
     * @param cons Number AbstractConstant
     * @return AbstractConstant with the result
     */
    SNumber mult(SNumber cons){return null;}

    /**
     * negation operation
     * @return AbstractConstant with the result
     */
    ScrabType neg(){return null;}

    /**
     * to evaluate Operations and Constants
     *
     * @return a AbstractConstant with the value of the Operation or AbstractConstant
     */
    @Override
    public AbstractConstant Eval() {
        return this;
    }
}
