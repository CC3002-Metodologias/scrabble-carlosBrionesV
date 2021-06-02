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
    void TestAddInt(){
        var Int = 34576;
        var sInt = new ScrabInt(Int);
        var expected=new ScrabString(value1 + Int);
        s=s.add(sInt);
        assertEquals(expected,s);
    }

    @Test
    void TestAddString(){
        var str = " OwO";
        var sstr = new ScrabString(str);
        var expected=new ScrabString(value1 + str);
        s=s.add(sstr);
        assertEquals(expected,s);

    }

    @Test
    void TestAddBinary(){
        var binary ="010101011100";
        var str = String.format("%32s", binary).replace(' ', '0');
        var sbin = new ScrabBinary(binary);
        var expected=new ScrabString(value1 +str);
        s=s.add(sbin);
        assertEquals(expected,s);
    }

    @Test
    void TestAddFloat(){
        var Float = 1.234;
        var sFloat = new ScrabFloat(Float);
        var expected=new ScrabString(value1 + Float);
        s=s.add(sFloat);
        assertEquals(expected,s);
    }

    @Test
    void TestAddBool(){
        var bool = new ScrabBoolean(true);
        var expected=new ScrabString(value1 + "true");
        s=s.add(bool);
        assertEquals(expected,s);
    }

    @Test
    void testToString(){
        ss=s.toString();
        assertEquals(value1,ss);
    }

    @Test
    void TestHashCode(){
        var expected = new ScrabString(value1);
        var unexpected = new ScrabString("100001");
        assertEquals(expected.hashCode(),s.hashCode());
        assertNotEquals(unexpected.hashCode(),s.hashCode());
    }
}