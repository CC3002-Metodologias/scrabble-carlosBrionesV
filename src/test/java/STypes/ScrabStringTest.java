package STypes;


import AST.ScrabFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabStringTest {
    private ScrabString s;
    private final String value1 = "AAAAAAAAAAAAAAAAAAAAAAA";
    private final ScrabFactory factory = new ScrabFactory();


    @BeforeEach
    void setUp() {
        s =factory.createString(value1);
    }

    @Test
    void testConstructor() {
        var expected = factory.createString(value1);
        assertEquals(expected, s);
    }

    @Test
    void TestAddInt(){
        var Int = 34576;
        var sInt = factory.createInt(Int);
        var expected=factory.createString(value1 + Int);
        s=s.add(sInt);
        assertEquals(expected,s);
    }

    @Test
    void TestAddString(){
        var str = " OwO";
        var sstr = factory.createString(str);
        var expected=factory.createString(value1 + str);
        s=s.add(sstr);
        assertEquals(expected,s);

    }

    @Test
    void TestAddBinary(){
        var binary ="010101011100";
        var str = String.format("%32s", binary).replace(' ', '0');
        var sbin = factory.createBinary(binary);
        var expected=factory.createString(value1 +str);
        s=s.add(sbin);
        assertEquals(expected,s);
    }

    @Test
    void TestAddFloat(){
        var Float = 1.234;
        var sFloat = factory.createFloat(Float);
        var expected=factory.createString(value1 + Float);
        s=s.add(sFloat);
        assertEquals(expected,s);
    }

    @Test
    void TestAddBool(){
        var bool = factory.createBoolean(true);
        var expected=factory.createString(value1 + "true");
        s=s.add(bool);
        assertEquals(expected,s);
    }

    @Test
    void testToString(){
        String ss = s.toString();
        assertEquals(value1, ss);
    }

    @Test
    void TestHashCode(){
        var expected = factory.createString(value1);
        var unexpected = factory.createString("100001");
        assertEquals(expected.hashCode(),s.hashCode());
        assertNotEquals(unexpected.hashCode(),s.hashCode());
    }
}