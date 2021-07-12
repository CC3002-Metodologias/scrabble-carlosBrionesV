package classes;

import AST.ScrabFactory;
import STypes.Numbers.ScrabBinary;
import STypes.ScrabBoolean;
import STypes.ScrabString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ScrabBooleanTest {
    private ScrabBoolean Bool;
    private final boolean boolValue = true;
    private String binValue;
    private ScrabBinary bin;
    private final ScrabFactory factory = new ScrabFactory();


    @BeforeEach
    void setUp() {
        binValue="";
        Bool=factory.createBoolean(boolValue);
        int seed = new Random().nextInt();
        Random rng = new Random(seed);
        for (int i = 0; i< 31; i++){
            int n = rng.nextInt(2);
            binValue = binValue.concat(Integer.toString(n));
        }
        bin = factory.createBinary(binValue);
    }

    @Test
    void testConstructor(){
        var expected = factory.createBoolean(boolValue);
        assertEquals(expected, Bool);
    }
    @Test
    void testToScrabString(){
        ScrabString s = Bool.toScrabString();
        String value2 = "true";
        var expected = factory.createString(value2);
        assertEquals(expected, s);
    }

    @Test
    void TestNeg(){
        var expected=factory.createBoolean(!boolValue);
        Bool.neg();
        assertEquals(expected,Bool);

    }

    @Test
    void TestAndBool(){
        var op = factory.createBoolean(true);
        var bool2=Bool.and(op);
        var expected= factory.createBoolean(true);
        assertEquals(expected,bool2);

        Bool.neg();
        expected= factory.createBoolean(false);
        bool2=Bool.and(op);
        assertEquals(expected,bool2);
    }

    @Test
    void TestAndBinary(){
        //bool true
        var expected= factory.createBinary(binValue);
        var bin2=Bool.and(bin);
        assertEquals(expected,bin2);

        Bool.neg();
        expected= factory.createBinary("00");
        bin2=Bool.and(bin);
        assertEquals(expected,bin2);
    }

    @Test
    void TestOrBool(){
        var op = factory.createBoolean(true);
        var bool2=Bool.or(op);
        var expected= factory.createBoolean(true);
        assertEquals(expected,bool2);

        System.out.print("aaaaaaaaaaaaan\n");
        Bool.neg();
        op= factory.createBoolean(false);
        expected= factory.createBoolean(false);
        bool2=Bool.or(op);
        assertEquals(expected,bool2);
    }

    @Test
    void TestOrBinary(){
        var expected= factory.createBinary("11");
        var bin2=Bool.or(bin);
        assertEquals(expected,bin2);

        Bool.neg();
        expected= factory.createBinary(binValue);
        bin2=Bool.or(bin);
        assertEquals(expected,bin2);
    }

    @Test
    void TestHashCode(){
        var expected = factory.createBoolean(boolValue);
        var unexpected = factory.createBoolean(false);
        assertEquals(expected.hashCode(),Bool.hashCode());
        assertNotEquals(unexpected.hashCode(),Bool.hashCode());
    }
}