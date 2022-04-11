package sml.instructions;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.Machine;
import sml.Registers;
import sml.Translator;



class SubInstructionTest {
    private Machine m;
    private Translator t;

    @BeforeEach
    void setUp() {
        m = new Machine();
        m.setRegisters(new Registers());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() {
        m.getRegisters().setRegister(11, 7);
        m.getRegisters().setRegister(12, 2);
        SubInstruction a = new SubInstruction("l1", 10, 11, 12);
        a.execute(m);
        Assert.assertEquals(5, m.getRegisters().getRegister(10));
    }

    @Test
    void testToString() {

        m.getRegisters().setRegister(11, 1);
        m.getRegisters().setRegister(12, 2);
        SubInstruction a = new SubInstruction("l1", 10, 11, 12);
        Assert.assertEquals("Label: l1, " +
                "Subtract the contents of registers 11 and 12 and store the result in register 10", a.toString() );

    }
}