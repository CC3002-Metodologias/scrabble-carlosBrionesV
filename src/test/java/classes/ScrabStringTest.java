package classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabStringTest {
    private ScrabString s;
    private String ss;
    private final String value1 = "AAAAAAAAAAAAAAAAAAAAAAA";

    @BeforeEach
    void setUp() {
        s =new ScrabString(value1);

    }

    @Test
    void testConstructor() {
        var expected = new ScrabString(value1);
        assertEquals(expected, s);
    }

    @Test
    void testToString(){
        ss=s.toString();
        assertEquals(value1,ss);
    }
}