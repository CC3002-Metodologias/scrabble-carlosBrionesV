package operands;

import AST.Operation;
import STypes.Numbers.ScrabBinary;
import STypes.ScrabType;

public interface BinaryOperand extends ScrabType {

    /**
     * add a SNumber with a ScrabBinary
     * @param binary the ScrabBinary to add
     * @return a new ScrabBinary with the values added
     */
    ScrabBinary addBinary(ScrabBinary binary);

    /**
     * multiplies a SNumber with a ScrabBinary
     * @param binary the ScrabBinary to multiply
     * @return a new ScrabBinary with the values multiplied
     */
    ScrabBinary multBinary(ScrabBinary binary);

    /**
     * divides a SNumber with a ScrabBinary
     * @param binary the ScrabBinary to divide
     * @return a new ScrabBinary with the values divided
     */
    ScrabBinary divBinary(ScrabBinary binary);

    /**
     * subtracts a SNumber with a ScrabBinary
     * @param binary the ScrabBinary to subtract
     * @return a new ScrabBinary with the values subtracted
     */
    ScrabBinary minusBinary(ScrabBinary binary);
}
