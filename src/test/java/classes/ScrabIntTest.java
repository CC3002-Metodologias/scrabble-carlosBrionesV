package classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



class ScrabIntTest {
    private ScrabInt i;
    private ScrabFloat f;
    private ScrabString s;
    private final int value1 = 3;

    @BeforeEach
    void setUp() {
        i =new ScrabInt(value1);
    }
    @Test
    void testConstructor(){
        var expected = new ScrabInt(value1);
        assertEquals(expected, i);
        assertEquals(expected,expected);
    }

    @Test
    void testToScrabString(){
        s = i.toScrabString();
        var expected = new ScrabString(String.valueOf(value1));
        assertEquals(expected,s);
    }

    @Test
    void testtoScrabFloat(){
        double value2 = 3.0;
        f = i.toScrabFloat();
        var expected= new ScrabFloat(value2);
        assertEquals(expected, f);
        assertEquals(expected,expected);
    }
}