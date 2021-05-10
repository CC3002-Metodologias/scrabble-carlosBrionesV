package classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabBooleanTest {
    private ScrabBoolean b;
    private ScrabString s;
    private final boolean value1 = true;
    private final String value2 = "true";


    @BeforeEach
    void setUp() {
        b=new ScrabBoolean(value1);
    }

    @Test
    void testConstructor(){
        var expected = new ScrabBoolean(value1);
        assertEquals(expected, b);
    }
    @Test
    void testToScrabString(){
        s=b.toScrabString();
        var expected = new ScrabString(value2);
        assertEquals(expected,s);
    }
}