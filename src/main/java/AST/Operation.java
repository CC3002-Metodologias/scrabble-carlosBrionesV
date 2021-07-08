package AST;

import AST.Operations.AbstractConstant;

public interface Operation {

    /**
     * to evaluate Operations and Constants
     * @return a AbstractConstant with the value of the Operation or AbstractConstant
     */
    AbstractConstant Eval();
}
