package sml.instructions;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.Machine;
import sml.Registers;

class MulInstructionTest {
    private Machine m;

    @BeforeEach
    void setUp() {
        m = new Machine();
        m.setRegisters(new Registers());
        m.getRegisters().setRegister(11, 5);
        m.getRegisters().setRegister(12, 10);
        m.getRegisters().setRegister(20, 15);
        m.getRegisters().setRegister(29, 101);
    }

    @Test
    void execute() {
        MulInstruction a = new MulInstruction("l1", 10, 11, 12);
        a.execute(m);
        Assert.assertEquals(50, m.getRegisters().getRegister(10));
        MulInstruction b = new MulInstruction("l2", 10, 10, 29);
        b.execute(m);
        Assert.assertEquals(5050, m.getRegisters().getRegister(10));
    }

    @Test
    void testToString() {
        m.getRegisters().setRegister(11, 1);
        m.getRegisters().setRegister(12, 2);
        MulInstruction a = new MulInstruction("l1", 10, 11, 12);
        Assert.assertEquals("Label: l1, " +
                "Multiply the contents of registers 11 and 12 and store the result in register 10", a.toString() );
    }
}
