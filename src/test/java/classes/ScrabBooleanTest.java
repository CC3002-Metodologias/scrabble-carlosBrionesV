package classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ScrabBooleanTest {
    private ScrabBoolean Bool;
    private final boolean boolValue = true;
    private String binValue;
    private ScrabBinary bin;


    @BeforeEach
    void setUp() {
        binValue="";
        Bool=new ScrabBoolean(boolValue);
        int seed = new Random().nextInt();
        Random rng = new Random(seed);
        for (int i = 0; i< 31; i++){
            int n = rng.nextInt(2);
            binValue = binValue.concat(Integer.toString(n));
        }
        bin = new ScrabBinary(binValue);
    }

    @Test
    void testConstructor(){
        var expected = new ScrabBoolean(boolValue);
        assertEquals(expected, Bool);
    }
    @Test
    void testToScrabString(){
        ScrabString s = Bool.toScrabString();
        String value2 = "true";
        var expected = new ScrabString(value2);
        assertEquals(expected, s);
    }

    @Test
    void TestNeg(){
        var expected=new ScrabBoolean(!boolValue);
        Bool.neg();
        assertEquals(expected,Bool);

    }

    @Test
    void TestAndBool(){
        var op = new ScrabBoolean(true);
        var bool2=Bool.and(op);
        var expected= new ScrabBoolean(true);
        assertEquals(expected,bool2);

        Bool.neg();
        expected= new ScrabBoolean(false);
        bool2=Bool.and(op);
        assertEquals(expected,bool2);
    }

    @Test
    void TestAndBinary(){
        //bool true
        var expected= new ScrabBinary(binValue);
        var bin2=Bool.and(bin);
        assertEquals(expected,bin2);

        Bool.neg();
        expected= new ScrabBinary("00");
        bin2=Bool.and(bin);
        assertEquals(expected,bin2);
    }

    @Test
    void TestOrBool(){
        var op = new ScrabBoolean(true);
        var bool2=Bool.or(op);
        var expected= new ScrabBoolean(true);
        assertEquals(expected,bool2);

        System.out.print("aaaaaaaaaaaaan\n");
        Bool.neg();
        op= new ScrabBoolean(false);
        expected= new ScrabBoolean(false);
        bool2=Bool.or(op);
        assertEquals(expected,bool2);
    }

    @Test
    void TestOrBinary(){
        var expected= new ScrabBinary("11");
        var bin2=Bool.or(bin);
        assertEquals(expected,bin2);

        Bool.neg();
        expected= new ScrabBinary(binValue);
        bin2=Bool.or(bin);
        assertEquals(expected,bin2);
    }

    @Test
    void TestHashCode(){
        var expected = new ScrabBoolean(boolValue);
        var unexpected = new ScrabBoolean(false);
        assertEquals(expected.hashCode(),Bool.hashCode());
        assertNotEquals(unexpected.hashCode(),Bool.hashCode());
    }
}