package AST;


import STypes.ScrabType;

/**
 * class to create a AST
 */
public class AST{
    Operation AST;

    /**
     * Constructor
     * @param op the operation tree
     */
    public AST(Operation op){
        AST=op;
    }

    /**
     * to Evaluate the AST
     * @return A ScrabType Value
     */
    public ScrabType Eval(){
        return AST.Eval();
    }
}
