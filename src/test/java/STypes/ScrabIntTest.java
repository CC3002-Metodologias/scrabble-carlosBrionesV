package STypes;

import AST.ScrabFactory;
import STypes.Numbers.ScrabBinary;
import STypes.Numbers.ScrabFloat;
import STypes.Numbers.ScrabInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class ScrabIntTest {
    private ScrabInt Int;
    private int operator;
    private int IntValue;
    private final ScrabFactory factory = new ScrabFactory();


    @BeforeEach
    void setUp(){
        int seed = new Random().nextInt();
        Random rng = new Random(seed);
        IntValue= rng.nextInt();
        operator = rng.nextInt();
        Int = factory.createInt(IntValue);
        
    }

    @Test
    void testConstructor(){
        var expected = factory.createInt(IntValue);
        assertEquals(expected, Int);
        assertEquals(expected,expected);
    }

    @Test
    void testToScrabString(){
        ScrabString s = Int.toScrabString();
        var expected = factory.createString(String.valueOf(IntValue));
        assertEquals(expected, s);
    }

    @Test
    void testToScrabFloat(){
        double FloatValue = Float.parseFloat(String.valueOf(IntValue));
        ScrabFloat f = Int.toScrabFloat();
        var expected= factory.createFloat(FloatValue);
        assertEquals(expected, f);
        assertEquals(expected,expected);
    }

    @RepeatedTest(20)
    void TestToScrabBinary(){

        ScrabBinary expected;
        String str = Integer.toBinaryString(IntValue);
        if (IntValue >= 0) {
            str = String.format("%32s", str).replace(' ', '0');
        }
        expected=factory.createBinary(str);
        var bin = Int.toScrabBinary();
        assertEquals(expected,bin);
    }

    @Test
    void TestNeg(){
        var expected = factory.createInt(-IntValue);
        Int=Int.neg();
        assertEquals(expected,Int);

    }

    @Test
    void TestAddBinary(){
        var expected = factory.createInt(IntValue+operator);
        var Soperator= factory.createInt(operator).toScrabBinary();

        assertEquals(expected,Int.add(Soperator));
    }

    @Test
    void TestaddInt(){
        var expected = factory.createInt(IntValue+operator);
        var Soperator= factory.createInt(operator);
        assertEquals(expected,Int.add(Soperator));
    }

    @Test
    void TestaddFloat(){
        var noperator = operator*1.0;
        var expected = factory.createFloat(IntValue+noperator);
        var Soperator= factory.createFloat(noperator);
        assertEquals(expected,Int.add(Soperator));
    }

    @Test
    void TestMultBinary(){
        var expected = factory.createInt(IntValue*operator);
        var Soperator= factory.createInt(operator).toScrabBinary();
        assertEquals(expected,Int.mult(Soperator));

    }

    @Test
    void TestMulInt(){
        var expected = factory.createInt(IntValue*operator);
        var Soperator= factory.createInt(operator);
        assertEquals(expected,Int.mult(Soperator));
    }

    @Test
    void TestMultFloat(){
        var noperator = operator*1.0;
        var expected = factory.createFloat(IntValue*noperator);
        var Soperator= factory.createFloat(noperator);
        assertEquals(expected,Int.mult(Soperator));
    }

    @Test
    void TestDivBinary(){
        var expected = factory.createInt(IntValue/operator);
        var Soperator= factory.createInt(operator).toScrabBinary();
        assertEquals(expected,Int.div(Soperator));
    }

    @Test
    void TestDivInt(){
        var expected = factory.createInt(IntValue/operator);
        var Soperator= factory.createInt(operator);
        assertEquals(expected,Int.div(Soperator));

    }

    @Test
    void TestDivFloat(){
        var noperator = operator*1.0;
        var expected = factory.createFloat(IntValue/noperator);
        var Soperator= factory.createFloat(noperator);
        assertEquals(expected,Int.div(Soperator));
    }

    @Test
    void TestMinusBinary(){
        var expected = factory.createInt(IntValue-operator);
        var Soperator= factory.createInt(operator).toScrabBinary();
        assertEquals(expected,Int.minus(Soperator));
    }

    @Test
    void TestMinusInt(){
        var expected = factory.createInt(IntValue-operator);
        var Soperator= factory.createInt(operator);
        assertEquals(expected,Int.minus(Soperator));

    }

    @Test
    void TestMinusFloat(){
        var noperator = operator*1.0;
        var expected = factory.createFloat(IntValue-noperator);
        var Soperator= factory.createFloat(noperator);
        assertEquals(expected,Int.minus(Soperator));
    }

    @Test
    void TestHashCode(){
        var expected = factory.createInt(IntValue);
        var unexpected = factory.createInt(76);
        assertEquals(expected.hashCode(),Int.hashCode());
        assertNotEquals(unexpected.hashCode(),Int.hashCode());
    }
}