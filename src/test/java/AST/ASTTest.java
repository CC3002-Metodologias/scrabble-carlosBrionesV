
package AST;

import AST.Operations.*;
import STypes.ScrabType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ASTTest {
    private final ScrabFactory factory = new ScrabFactory();


    @Test
    void VarTest(){
        factory.createNewVar("a",factory.createInt(5));

        AST ast = new AST(
                new Add(factory.createReference("a"),
                        factory.createReference("a"))
        );
        var expected=factory.createInt(10);
        assertEquals(expected,ast.Eval());

    }

    @Test
    void AddTest(){
        /*
        add between ints
         */
        AST ast = new AST(
                new Add(factory.createInt(9),
                        factory.createInt(12))
        );
        ScrabType expected=factory.createInt(21);
        assertEquals(expected,ast.Eval());

        /*
        add to string
         */
        ast = new AST(new Add(factory.createString("awa"),
                new Add(factory.createInt(9),
                        factory.createInt(12)))
        );
        expected=factory.createString("awa21");
        assertEquals(expected,ast.Eval());
    }

    @Test
    void MinusTest(){
        AST ast = new AST(
                new Minus(factory.createInt(9),
                        factory.createInt(12))
        );
        var expected=factory.createInt(-3);
        assertEquals(expected,ast.Eval());
    }

    @Test
    void MultTest(){
        AST ast = new AST(
                new Mult(factory.createInt(9),
                        factory.createInt(12))
        );
        var expected=factory.createInt(108);
        assertEquals(expected,ast.Eval());
    }

    @Test
    void DivTest(){
        AST ast = new AST(
                new Div(factory.createInt(100),
                        factory.createInt(5))
        );
        var expected=factory.createInt(20);
        assertEquals(expected,ast.Eval());
    }

    @Test
    void OrTest(){
        AST ast = new AST(
                new Or(factory.createBoolean(false),
                        factory.createBinary("010111011"))
        );
        var expected=factory.createBinary("010111011");
        assertEquals(expected,ast.Eval());
    }

    @Test
    void AndTest(){
        AST ast = new AST(
                new And(factory.createBoolean(true),
                        factory.createBoolean(false))
        );
        var expected=factory.createBoolean(false);
        assertEquals(expected,ast.Eval());
    }

    @Test
    void NegTest(){
        AST ast = new AST(
                new Neg(factory.createInt(9))
        );
        var expected=factory.createInt(-9);
        assertEquals(expected,ast.Eval());
    }

    @Test
    void CompoundTest(){
        AST ast = new AST(
                new Add(factory.createFloat(45.3),
                        new Mult(factory.createInt(5),
                                new Neg(factory.createInt(9)))
                )
        );
        var expected=factory.createFloat(0.3);
        assertEquals(expected,ast.Eval());

    }

    @Test
    void nullTest(){
        /* Add null */
        AST ast = new AST(
                new Add(factory.createBoolean(true),factory.createInt(4))
        );
        assertNull(ast.Eval());

        /* Minus null */
        ast = new AST(
                new Minus(factory.createBoolean(true),factory.createInt(4))
        );
        assertNull(ast.Eval());

        /* Mult null */
        ast = new AST(
                new Mult(factory.createBoolean(true),factory.createInt(4))
        );
        assertNull(ast.Eval());

        /* Div null */
        ast = new AST(
                new Div(factory.createBoolean(true),factory.createInt(4))
        );
        assertNull(ast.Eval());

        /* And null */
        ast = new AST(
                new And(factory.createInt(4),factory.createBoolean(true))
        );
        assertNull(ast.Eval());

        /* Or null */
        ast = new AST(
                new Or(factory.createInt(4),factory.createBoolean(true))
        );
        assertNull(ast.Eval());

        /* Neg null */
        ast = new AST(
                new Neg(factory.createString("hola"))
        );
        assertNull(ast.Eval());
    }

}
