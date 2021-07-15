package classes;

import AST.ScrabFactory;
import STypes.Numbers.ScrabFloat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ScrabFloatTest {
    private ScrabFloat Float;
    private int operator;
    private double FloatValue;
    private final ScrabFactory factory = new ScrabFactory();

    @BeforeEach
    void setUp(){
        int seed = new Random().nextInt();
        Random rng = new Random(seed);
        FloatValue= rng.nextInt()*1.0;
        operator = rng.nextInt();
        Float = factory.createFloat(FloatValue);
    }

    @Test
    void testConstructor(){
        var expected = factory.createFloat(FloatValue);
        assertEquals(expected, Float);
    }

    @Test
    void testtoScrabString(){
        var str = Float.toScrabString();
        var expected = factory.createString(String.valueOf(FloatValue));
        assertEquals(expected,str);
    }

    @Test
    void TestNeg(){
        var expected = factory.createFloat(-FloatValue);
        Float=Float.neg();
        assertEquals(expected,Float);

    }

    @Test
    void TestAddBinary(){
        var expected = factory.createFloat(FloatValue+operator);
        var Soperator= factory.createInt(operator).toScrabBinary();
        assertEquals(expected,Float.add(Soperator));
    }

    @Test
    void TestaddInt(){
        var expected = factory.createFloat(FloatValue+operator);
        var Soperator= factory.createInt(operator);
        assertEquals(expected,Float.add(Soperator));
    }

    @Test
    void TestaddFloat(){
        var noperator = operator*1.0;
        var expected = factory.createFloat(FloatValue+noperator);
        var Soperator= factory.createFloat(noperator);
        assertEquals(expected,Float.add(Soperator));
    }

    @Test
    void TestMultBinary(){

        var expected = factory.createFloat(FloatValue*operator);
        var Soperator= factory.createInt(operator).toScrabBinary();
        assertEquals(expected,Float.mult(Soperator));

    }

    @Test
    void TestMulInt(){
        var expected = factory.createFloat(FloatValue*operator);
        var Soperator= factory.createInt(operator);
        assertEquals(expected,Float.mult(Soperator));
    }

    @Test
    void TestMultFloat(){
        var noperator = operator*1.0;
        var expected = factory.createFloat(FloatValue*noperator);
        var Soperator= factory.createFloat(noperator);
        assertEquals(expected,Float.mult(Soperator));
    }

    @Test
    void TestDivBinary(){
        var expected = factory.createFloat(FloatValue/operator);
        var Soperator= factory.createInt(operator).toScrabBinary();
        assertEquals(expected,Float.div(Soperator));
    }

    @Test
    void TestDivInt(){
        var expected = factory.createFloat(FloatValue/operator);
        var Soperator= factory.createInt(operator);
        assertEquals(expected,Float.div(Soperator));

    }

    @Test
    void TestDivFloat(){
        var noperator = operator*1.0;
        var expected = factory.createFloat(FloatValue/noperator);
        var Soperator= factory.createFloat(noperator);
        assertEquals(expected,Float.div(Soperator));
    }

    @Test
    void TestMinusBinary(){
        var expected = factory.createFloat(FloatValue-operator);
        var Soperator= factory.createInt(operator).toScrabBinary();
        assertEquals(expected,Float.minus(Soperator));
    }

    @Test
    void TestMinusInt(){
        var expected = factory.createFloat(FloatValue-operator);
        var Soperator= factory.createInt(operator);
        assertEquals(expected,Float.minus(Soperator));

    }

    @Test
    void TestMinusFloat(){
        var noperator = operator*1.0;
        var expected = factory.createFloat(FloatValue-noperator);
        var Soperator= factory.createFloat(noperator);
        assertEquals(expected,Float.minus(Soperator));
    }

    
    @Test
    void TestHashCode(){
        var expected = factory.createFloat(FloatValue);
        var unexpected = factory.createFloat(9.8);
        assertEquals(expected.hashCode(),Float.hashCode());
        assertNotEquals(unexpected.hashCode(),Float.hashCode());
    }
}