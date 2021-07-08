package classes;

import STypes.Numbers.ScrabFloat;
import STypes.Numbers.ScrabInt;
import STypes.ScrabString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ScrabFloatTest {
    private ScrabFloat Float;
    private int operator;
    private double FloatValue;

    @BeforeEach
    void setUp(){
        int seed = new Random().nextInt();
        Random rng = new Random(seed);
        FloatValue= rng.nextInt()*1.0;
        operator = rng.nextInt();
        Float = new ScrabFloat(FloatValue);
    }

    @Test
    void testConstructor(){
        var expected = new ScrabFloat(FloatValue);
        assertEquals(expected, Float);
    }

    @Test
    void testtoScrabString(){
        var str = Float.toScrabString();
        var expected = new ScrabString(String.valueOf(FloatValue));
        assertEquals(expected,str);
    }

    @Test
    void TestNeg(){
        var expected = new ScrabFloat(-FloatValue);
        Float.neg();
        assertEquals(expected,Float);

    }

    @Test
    void TestAddBinary(){
        var expected = new ScrabFloat(FloatValue+operator);
        var Soperator= new ScrabInt(operator).toScrabBinary();
        assertEquals(expected,Float.add(Soperator));
    }

    @Test
    void TestaddInt(){
        var expected = new ScrabFloat(FloatValue+operator);
        var Soperator= new ScrabInt(operator);
        assertEquals(expected,Float.add(Soperator));
    }

    @Test
    void TestaddFloat(){
        var noperator = operator*1.0;
        var expected = new ScrabFloat(FloatValue+noperator);
        var Soperator= new ScrabFloat(noperator);
        assertEquals(expected,Float.add(Soperator));
    }

    @Test
    void TestMultBinary(){

        var expected = new ScrabFloat(FloatValue*operator);
        var Soperator= new ScrabInt(operator).toScrabBinary();
        assertEquals(expected,Float.mult(Soperator));

    }

    @Test
    void TestMulInt(){
        var expected = new ScrabFloat(FloatValue*operator);
        var Soperator= new ScrabInt(operator);
        assertEquals(expected,Float.mult(Soperator));
    }

    @Test
    void TestMultFloat(){
        var noperator = operator*1.0;
        var expected = new ScrabFloat(FloatValue*noperator);
        var Soperator= new ScrabFloat(noperator);
        assertEquals(expected,Float.mult(Soperator));
    }

    @Test
    void TestDivBinary(){
        var expected = new ScrabFloat(FloatValue/operator);
        var Soperator= new ScrabInt(operator).toScrabBinary();
        assertEquals(expected,Float.div(Soperator));
    }

    @Test
    void TestDivInt(){
        var expected = new ScrabFloat(FloatValue/operator);
        var Soperator= new ScrabInt(operator);
        assertEquals(expected,Float.div(Soperator));

    }

    @Test
    void TestDivFloat(){
        var noperator = operator*1.0;
        var expected = new ScrabFloat(FloatValue/noperator);
        var Soperator= new ScrabFloat(noperator);
        assertEquals(expected,Float.div(Soperator));
    }

    @Test
    void TestMinusBinary(){
        var expected = new ScrabFloat(FloatValue-operator);
        var Soperator= new ScrabInt(operator).toScrabBinary();
        assertEquals(expected,Float.minus(Soperator));
    }

    @Test
    void TestMinusInt(){
        var expected = new ScrabFloat(FloatValue-operator);
        var Soperator= new ScrabInt(operator);
        assertEquals(expected,Float.minus(Soperator));

    }

    @Test
    void TestMinusFloat(){
        var noperator = operator*1.0;
        var expected = new ScrabFloat(FloatValue-noperator);
        var Soperator= new ScrabFloat(noperator);
        assertEquals(expected,Float.minus(Soperator));
    }

    
    @Test
    void TestHashCode(){
        var expected = new ScrabFloat(FloatValue);
        var unexpected = new ScrabFloat(9.8);
        assertEquals(expected.hashCode(),Float.hashCode());
        assertNotEquals(unexpected.hashCode(),Float.hashCode());
    }
}