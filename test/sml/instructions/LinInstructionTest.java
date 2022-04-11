package sml.instructions;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.Machine;
import sml.Registers;

public class LinInstructionTest {

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
        LinInstruction a = new LinInstruction("l1", 10, 101);
        a.execute(m);
        Assert.assertEquals(101, m.getRegisters().getRegister(10));
    }

    @Test
    void testToString() {
        m.getRegisters().setRegister(11, 1);
        m.getRegisters().setRegister(12, 2);
        LinInstruction a = new LinInstruction("l1", 10, 101);
        Assert.assertEquals("Label: l1, Store integer 101 in register 10", a.toString() );
    }
}
