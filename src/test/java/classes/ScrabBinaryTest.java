package classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabBinaryTest {
    private ScrabString s;
    private ScrabBinary bi;
    private final String value1="10101110";

    @BeforeEach
    void setUp() {
        bi= new ScrabBinary(value1);
    }

    @Test
    void TestConstructor(){
        var expected = new ScrabBinary(value1);
        assertEquals(expected,bi);
    }
    @Test
    void TestToScrabString(){
        s=bi.toScrabString();
        var expected=new ScrabString(value1);
        assertEquals(expected, s);
    }

}