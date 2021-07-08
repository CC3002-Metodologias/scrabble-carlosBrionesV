package classes;

import STypes.Numbers.ScrabBinary;
import STypes.Numbers.ScrabFloat;
import STypes.Numbers.ScrabInt;
import STypes.ScrabString;
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

    @BeforeEach
    void setUp(){
        int seed = new Random().nextInt();
        Random rng = new Random(seed);
        IntValue= rng.nextInt();
        operator = rng.nextInt();
        Int = new ScrabInt(IntValue);
    }

    @Test
    void testConstructor(){
        var expected = new ScrabInt(IntValue);
        assertEquals(expected, Int);
        assertEquals(expected,expected);
    }

    @Test
    void testToScrabString(){
        ScrabString s = Int.toScrabString();
        var expected = new ScrabString(String.valueOf(IntValue));
        assertEquals(expected, s);
    }

    @Test
    void testToScrabFloat(){
        double FloatValue = Float.parseFloat(String.valueOf(IntValue));
        ScrabFloat f = Int.toScrabFloat();
        var expected= new ScrabFloat(FloatValue);
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
        expected=new ScrabBinary(str);
        var bin = Int.toScrabBinary();
        assertEquals(expected,bin);
    }

    @Test
    void TestNeg(){
        var expected = new ScrabInt(-IntValue);
        Int.neg();
        assertEquals(expected,Int);

    }

    @Test
    void TestAddBinary(){
        var expected = new ScrabInt(IntValue+operator);
        var Soperator= new ScrabInt(operator).toScrabBinary();

        assertEquals(expected,Int.add(Soperator));
    }

    @Test
    void TestaddInt(){
        var expected = new ScrabInt(IntValue+operator);
        var Soperator= new ScrabInt(operator);
        assertEquals(expected,Int.add(Soperator));
    }

    @Test
    void TestaddFloat(){
        var noperator = operator*1.0;
        var expected = new ScrabFloat(IntValue+noperator);
        var Soperator= new ScrabFloat(noperator);
        assertEquals(expected,Int.add(Soperator));
    }

    @Test
    void TestMultBinary(){
        System.out.print("lo que se opera: "+operator+'\n');
        System.out.print("a lo que se opera: "+Int+'\n');
        var expected = new ScrabInt(IntValue*operator);
        var Soperator= new ScrabInt(operator).toScrabBinary();
        assertEquals(expected,Int.mult(Soperator));

    }

    @Test
    void TestMulInt(){
        var expected = new ScrabInt(IntValue*operator);
        var Soperator= new ScrabInt(operator);
        assertEquals(expected,Int.mult(Soperator));
    }

    @Test
    void TestMultFloat(){
        var noperator = operator*1.0;
        var expected = new ScrabFloat(IntValue*noperator);
        var Soperator= new ScrabFloat(noperator);
        assertEquals(expected,Int.mult(Soperator));
    }

    @Test
    void TestDivBinary(){
        var expected = new ScrabInt(IntValue/operator);
        var Soperator= new ScrabInt(operator).toScrabBinary();
        assertEquals(expected,Int.div(Soperator));
    }

    @Test
    void TestDivInt(){
        var expected = new ScrabInt(IntValue/operator);
        var Soperator= new ScrabInt(operator);
        assertEquals(expected,Int.div(Soperator));

    }

    @Test
    void TestDivFloat(){
        var noperator = operator*1.0;
        var expected = new ScrabFloat(IntValue/noperator);
        var Soperator= new ScrabFloat(noperator);
        assertEquals(expected,Int.div(Soperator));
    }

    @Test
    void TestMinusBinary(){

        System.out.print("lo que se opera: "+operator+'\n');
        System.out.print("a lo que se opera: "+Int+'\n');
        var expected = new ScrabInt(IntValue-operator);
        var Soperator= new ScrabInt(operator).toScrabBinary();
        assertEquals(expected,Int.minus(Soperator));
    }

    @Test
    void TestMinusInt(){
        var expected = new ScrabInt(IntValue-operator);
        var Soperator= new ScrabInt(operator);
        assertEquals(expected,Int.minus(Soperator));

    }

    @Test
    void TestMinusFloat(){
        var noperator = operator*1.0;
        var expected = new ScrabFloat(IntValue-noperator);
        var Soperator= new ScrabFloat(noperator);
        assertEquals(expected,Int.minus(Soperator));
    }

    @Test
    void TestHashCode(){
        var expected = new ScrabInt(IntValue);
        var unexpected = new ScrabInt(76);
        assertEquals(expected.hashCode(),Int.hashCode());
        assertNotEquals(unexpected.hashCode(),Int.hashCode());
    }
}