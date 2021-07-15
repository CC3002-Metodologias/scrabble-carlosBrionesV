package operands;

import STypes.Numbers.ScrabBinary;
import STypes.ScrabBoolean;
import STypes.ScrabType;

/**
 * interface for logic with ScrabBoolean and ScrabBinary
 */
public interface Slogic extends ScrabType {
    /**
     * Logic operation AND
     * @param logic ScrabBoolean or ScrabBinary value
     * @return ScrabBoolean if logic is a ScrabBoolean or
     *         ScrabBinary if logic is a ScrabBinary
     */
    Slogic and(Slogic logic);

    /**
     * Logic operation OR
     * @param logic ScrabBoolean or ScrabBinary value
     * @return ScrabBoolean if logic is a ScrabBoolean or
     *         ScrabBinary if logic is a ScrabBinary
     */
    Slogic or(Slogic logic);

    /**
     * logic operation of AND with a ScrabBoolean
     * @param bool ScrabBoolean value to compare
     */
    Slogic andBool(ScrabBoolean bool);

    /**
     * logic operation of OR with a ScrabBoolean
     * @param bool ScrabBoolean value to compare
     */
    Slogic orBool(ScrabBoolean bool);

    /**
     * logic operation of AND with a ScrabBinary
     * @param binary ScrabBinary value to compare
     */
    Slogic andBinary(ScrabBinary binary);

    /**
     * logic operation of OR with a ScrabBinary
     * @param binary ScrabBinary value to compare
     */
    Slogic orBinary(ScrabBinary binary);
}
