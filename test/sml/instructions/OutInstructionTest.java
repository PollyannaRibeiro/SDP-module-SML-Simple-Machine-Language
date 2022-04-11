package sml.instructions;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.Machine;
import sml.Registers;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OutInstructionTest {
    private Machine m;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        m = new Machine();
        m.setRegisters(new Registers());
        m.getRegisters().setRegister(11, 5);
        m.getRegisters().setRegister(12, 10);
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void execute() {
        OutInstruction a = new OutInstruction("l1", 11);
        a.execute(m);
        Assert.assertEquals("5\n", outContent.toString());
    }

    @Test
    void testToString() {
        m.getRegisters().setRegister(11, 1);
        m.getRegisters().setRegister(12, 2);
        OutInstruction a = new OutInstruction("l1", 11);
        Assert.assertEquals("Label: l1, Print the contents of register 11 on the console", a.toString() );
    }
}
