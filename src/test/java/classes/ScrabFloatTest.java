package classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScrabFloatTest {
    private ScrabFloat f;
    private ScrabString s;
    private final double value1 = 3.345;
    private final String value2 = "3.345";


    @BeforeEach
    void setUp() {
        f=new ScrabFloat(value1);
    }

    @Test
    void testConstructor(){
        var expected = new ScrabFloat(value1);
        assertEquals(expected, f);
    }
    @Test
    void testtoScrabString(){
        s =f.toScrabString();
        var expected = new ScrabString(value2);
        assertEquals(expected,s);
    }
}