package sml.instructions;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.Machine;
import sml.Registers;

public class DivInstructionTest {
    private Machine m;

    @BeforeEach
    void setUp() {
        m = new Machine();
        m.setRegisters(new Registers());
        m.getRegisters().setRegister(11, 5);
        m.getRegisters().setRegister(12, 10);
    }

    @Test
    void execute() {
        DivInstruction a = new DivInstruction("l1", 10, 12, 11);
        a.execute(m);
        Assert.assertEquals(2, m.getRegisters().getRegister(10));
    }

    @Test
    void testToString() {
        DivInstruction a = new DivInstruction("l1", 10, 12, 11);
        Assert.assertEquals("Label: l1, " +
                "Divide the contents of registers 12 and 11 and store the result in register 10", a.toString() );
    }

}
