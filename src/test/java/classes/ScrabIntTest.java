package classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



class ScrabIntTest {
    private ScrabInt i1;
    private final int value1 = 3;

    @BeforeEach
    void setUp() {
        i1=new ScrabInt(value1);
    }
    @Test
    void testConstructor(){
        var expected = new ScrabInt(value1);
        assertEquals(expected, i1);
        assertEquals(expected,expected);

    }
    //@Test
    //void testToString() {
    //}
}