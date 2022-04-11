package sml.instructions;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.*;

public class BnzInstructionTest {
    private Machine m;
    private Translator t;

    @BeforeEach
    void setUp() {
        m = new Machine();
        m.setRegisters(new Registers());
        m.getRegisters().setRegister(14, 10);
//        I COULDN't FIGURE OUT HOW TO TEST EXECUTE BECAUSE LABEL IS PRIVATE AND LABEL ACCESSOR IS PROTECTED'
    }

    @Test
    void testToString() {
        m.getRegisters().setRegister(11, 1);
        m.getRegisters().setRegister(12, 2);
        LinInstruction a = new LinInstruction("l1", 10, 101);
        Assert.assertEquals("Label: l1, Store integer 101 in register 10", a.toString() );
    }
}
