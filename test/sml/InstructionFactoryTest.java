package sml;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.instructions.*;

public class InstructionFactoryTest {

    private Machine m;
    private InstructionFactory factory;

    @BeforeEach
    void setUp() {
        m = new Machine();
        m.setRegisters(new Registers());
        m.getRegisters().setRegister(11, 1);
        m.getRegisters().setRegister(12, 2);

        factory = SingletonFactoryInstruction.getInstance().factory;
    }

    @Test
    void factoryCreateInstructionTest() {
        ScanAccessor scan = new ScanAccessor(
                () ->{ return 1; },
                () ->{ return "Hi"; }
        );

        Instruction iAdd = factory.createInstruction("f1", "add", scan);
        Assert.assertEquals("add", iAdd.getOpcode());
        Assert.assertTrue(iAdd instanceof AddInstruction);

        Instruction iSub = factory.createInstruction("f1", "sub", scan);
        Assert.assertEquals("sub", iSub.getOpcode());
        Assert.assertTrue(iSub instanceof SubInstruction);

        Instruction iMul = factory.createInstruction("f1", "mul", scan);
        Assert.assertEquals("mul", iMul.getOpcode());
        Assert.assertTrue(iMul instanceof MulInstruction);

        Instruction iDiv = factory.createInstruction("f1", "div", scan);
        Assert.assertEquals("div", iDiv.getOpcode());
        Assert.assertTrue(iDiv instanceof DivInstruction);

        Instruction iOut = factory.createInstruction("f1", "out", scan);
        Assert.assertEquals("out", iOut.getOpcode());
        Assert.assertTrue(iOut instanceof OutInstruction);

        Instruction iLin = factory.createInstruction("f1", "lin", scan);
        Assert.assertEquals("lin", iLin.getOpcode());
        Assert.assertTrue(iLin instanceof LinInstruction);

        Instruction iBnz = factory.createInstruction("f1", "bnz", scan);
        Assert.assertEquals("bnz", iBnz.getOpcode());
        Assert.assertTrue(iBnz instanceof BnzInstruction);

    }
}