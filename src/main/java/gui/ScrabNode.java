package gui;

import AST.Operations.Operation;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 * Class to save information for GUI purposes
 */
public class ScrabNode{
    public Line line1;
    public Line line2;
    public Line line3;
    public Operation op;
    public boolean[] united ={false,false,false};


    /**
     * Constrctor
     */
    public ScrabNode (){

    }

    /**
     * getter for line 1
     * @return Line 1
     */
    public Line getLine1() {
        return line1;
    }

    /**
     * setter for line 1
     * @param line1 the line
     */
    public void setLine1(Line line1) {
        this.line1 = line1;
    }

    /**
     * getter for line 2
     * @return Line 2
     */
    public Line getLine2() {
        return line2;
    }

    /**
     * setter for line 2
     * @param line2 the line
     */
    public void setLine2(Line line2) {
        this.line2 = line2;
    }

    /**
     * getter for line 3
     * @return Line 3
     */
    public Line getLine3() {
        return line3;
    }

    /**
     * setter for line 3
     * @param line3 the line
     */
    public void setLine3(Line line3) {
        this.line3 = line3;
    }

    /**
     * getter for the operation
     * @return the operation
     */
    public Operation getOp() {
        return op;
    }

    /**
     * setter for the operation
     * @param op the operation
     */
    public void setOp(Operation op) {
        this.op = op;
    }
}
