package classes;


import AST.ScrabFactory;
import STypes.Numbers.ScrabBinary;
import STypes.Numbers.ScrabFloat;
import STypes.Numbers.ScrabInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import STypes.ScrabString;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ScrabBinaryTest {

    private ScrabBinary bin;
    private String binValue;
    private String operator;
    private final ScrabFactory factory = new ScrabFactory();

    @BeforeEach
    void setUp(){
        binValue = "";
        operator = "";
        int seed = new Random().nextInt();
        Random rng = new Random(seed);
        for (int i = 0; i< 31; i++){
            int n = rng.nextInt(2);
            int m = rng.nextInt(2);
            operator = operator.concat(Integer.toString(m));
            binValue = binValue.concat(Integer.toString(n));
        }
        bin = factory.createBinary(binValue);
    }

    @Test
    void TestConstructor(){
        var expected = factory.createBinary(binValue);
        assertEquals(expected,bin);
    }

    @RepeatedTest(10)
    void TestToScrabString(){
        ScrabString s = bin.toScrabString();
        ScrabString expected=factory.createString("1"+binValue);
        if (binValue.charAt(0)=='0') {
            expected = factory.createString(String.format("%32s", binValue).replace(' ', '0'));
        }
        assertEquals(expected, s);
    }

    @RepeatedTest(10)
    void TestToScrabInt(){
        ScrabInt expected;
        if (binValue.charAt(0)=='1'){
            expected = factory.createInt(Integer.parseInt("-"+binValue,2));
        }
        else {
            expected = factory.createInt(Integer.parseInt(binValue, 2));
        }
        ScrabInt Int = bin.toScrabInt();
    assertEquals(expected,Int);


    }

    @RepeatedTest(10)
    void TestToScrabFloat(){
        ScrabFloat expected;
        if (binValue.charAt(0)=='1'){
            expected = factory.createInt(Integer.parseInt("-"+binValue,2)).toScrabFloat();

        }
        else {
            expected = factory.createInt(Integer.parseInt(binValue, 2)).toScrabFloat();
        }
        ScrabFloat Float = bin.toScrabFloat();
        assertEquals(expected,Float);
    }

    @Test
    void TestAddInt(){
        int i2;
        int i1;
        if (operator.charAt(0)=='1'){
            i1= Integer.parseInt("-"+operator,2);
        }
        else {
            i1= Integer.parseInt(operator, 2);
        }
        var op = factory.createInt(i1);

        if (binValue.charAt(0)=='1'){
            i2= Integer.parseInt("-"+binValue,2);
        }
        else {
            i2= Integer.parseInt(binValue, 2);
        }
        var expected = factory.createInt(i2+i1).toScrabBinary();

        assertEquals(expected,bin.add(op));

    }

    @Test
    void TestAddBinary(){
        int i2;
        int i1;
        if (operator.charAt(0)=='1'){
            i1= Integer.parseInt("-"+operator,2);
        }
        else {
            i1= Integer.parseInt(operator, 2);
        }

        if (binValue.charAt(0)=='1'){
            i2= Integer.parseInt("-"+binValue,2);
        }
        else {
            i2= Integer.parseInt(binValue, 2);
        }
        var expected= factory.createInt(i1+i2).toScrabBinary();
        var sb=factory.createBinary(operator);
        assertEquals(expected,bin.add(sb));
    }

    @Test
    void TestMultInt(){
        int i2;
        int i1;
        if (operator.charAt(0)=='1'){
            i1= Integer.parseInt("-"+operator,2);
        }
        else {
            i1= Integer.parseInt(operator, 2);
        }
        var op = factory.createInt(i1);

        if (binValue.charAt(0)=='1'){
            i2= Integer.parseInt("-"+binValue,2);
        }
        else {
            i2= Integer.parseInt(binValue, 2);
        }
        var expected = factory.createInt(i2*i1).toScrabBinary();


        assertEquals(expected,bin.mult(op));

    }

    @Test
    void TestMultBinary(){
        int i2;
        int i1;
        if (operator.charAt(0)=='1'){
            i1= Integer.parseInt("-"+operator,2);
        }
        else {
            i1= Integer.parseInt(operator, 2);
        }

        if (binValue.charAt(0)=='1'){
            i2= Integer.parseInt("-"+binValue,2);
        }
        else {
            i2= Integer.parseInt(binValue, 2);
        }
        var expected= factory.createInt(i1*i2).toScrabBinary();
        var sb=factory.createBinary(operator);
        assertEquals(expected,bin.mult(sb));
    }

    @Test
    void TestDivInt(){
        int i2;
        int i1;
        if (operator.charAt(0)=='1'){
            i1= Integer.parseInt("-"+operator,2);
        }
        else {
            i1= Integer.parseInt(operator, 2);
        }
        var op = factory.createInt(i1);

        if (binValue.charAt(0)=='1'){
            i2= Integer.parseInt("-"+binValue,2);
        }
        else {
            i2= Integer.parseInt(binValue, 2);
        }
        var expected = factory.createInt(i1/i2).toScrabBinary();


        assertEquals(expected,bin.div(op));

    }

    @Test
    void TestDivBinary(){
        int i2;
        int i1;
        if (operator.charAt(0)=='1'){
            i1= Integer.parseInt("-"+operator,2);
        }
        else {
            i1= Integer.parseInt(operator, 2);
        }

        if (binValue.charAt(0)=='1'){
            i2= Integer.parseInt("-"+binValue,2);
        }
        else {
            i2= Integer.parseInt(binValue, 2);
        }
        var expected= factory.createInt(i2/i1).toScrabBinary();
        var sb=factory.createBinary(operator);
        assertEquals(expected,bin.div(sb));
    }

    @Test
    void TestMinusInt(){
        int i2;
        int i1;
        if (operator.charAt(0)=='1'){
            i1= Integer.parseInt("-"+operator,2);
        }
        else {
            i1= Integer.parseInt(operator, 2);
        }
        var op = factory.createInt(i1);

        if (binValue.charAt(0)=='1'){
            i2= Integer.parseInt("-"+binValue,2);
        }
        else {
            i2= Integer.parseInt(binValue, 2);
        }
        var expected = factory.createInt(i1-i2).toScrabBinary();

        assertEquals(expected,bin.minus(op));
    }

    @Test
    void TestMinusBinary(){
        int i2;
        int i1;
        if (operator.charAt(0)=='1'){
            i1= Integer.parseInt("-"+operator,2);
        }
        else {
            i1= Integer.parseInt(operator, 2);
        }

        if (binValue.charAt(0)=='1'){
            i2= Integer.parseInt("-"+binValue,2);
        }
        else {
            i2= Integer.parseInt(binValue, 2);
        }
        var expected= factory.createInt(i2-i1).toScrabBinary();
        var sb=factory.createBinary(operator);
        assertEquals(expected,bin.minus(sb));
    }






    @Test
    void TestNeg(){
        binValue=binValue.replace('0','2').replace('1','0').replace('2','1');
        var expected=factory.createBinary(binValue);
        bin=bin.neg();
        assertEquals(expected,bin);
    }

    @Test
    void TestAndBinary(){
        operator=operator.charAt(0)+operator;
        binValue=binValue.charAt(0)+binValue;
        ScrabBinary op = factory.createBinary(operator);
        StringBuilder str=new StringBuilder();
        for (int i = 0;i<32;i++){
            if (operator.charAt(i)=='1' && binValue.charAt(i)=='1'){
                str.append(1);
            }
            else{str.append(0);}
        }
        ScrabBinary expected=factory.createBinary(str.toString());
        bin=bin.and(op);
        assertEquals(expected,bin);
    }

    @Test
    void TestAndBool(){
        var bool = factory.createBoolean(true);
        var expected= factory.createBinary(binValue);
        var bin2=bin.and(bool);
        assertEquals(expected,bin2);

        bool=factory.createBoolean(false);
        expected= factory.createBinary("00");
        bin2=bin.and(bool);
        assertEquals(expected,bin2);
    }

    @Test
    void TestOrBinary(){
        operator=operator.charAt(0)+operator;
        binValue=binValue.charAt(0)+binValue;
        ScrabBinary op = factory.createBinary(operator);
        StringBuilder str=new StringBuilder();
        for (int i = 0;i<32;i++){
            if (operator.charAt(i)=='1' || binValue.charAt(i)=='1'){
                str.append(1);
            }
            else{
                str.append(0);
            }
        }
        ScrabBinary expected=factory.createBinary(str.toString());
        bin=bin.or(op);
        assertEquals(expected,bin);
    }

    @Test
    void TestOrBool(){
        var bool = factory.createBoolean(true);
        var expected= factory.createBinary("111");
        var bin2=bin.or(bool);
        assertEquals(expected,bin2);


    }

    @Test
    void TestHashCode(){
        var expected = factory.createBinary(binValue);
        var unexpected = factory.createBinary(binValue+"1");
        assertEquals(expected.hashCode(),bin.hashCode());
        assertNotEquals(unexpected.hashCode(),bin.hashCode());
    }
}