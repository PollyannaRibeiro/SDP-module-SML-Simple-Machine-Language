package sml.instructions;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.Machine;
import sml.Registers;


class AddInstructionTest {
  private Machine m;

  @BeforeEach
  void setUp() {
    m = new Machine();
    m.setRegisters(new Registers());
    m.getRegisters().setRegister(11, 1);
    m.getRegisters().setRegister(12, 2);
  }

  @Test
  void execute() {

    AddInstruction a = new AddInstruction("l1", 10, 11, 12);
    a.execute(m);
    Assert.assertEquals(3, m.getRegisters().getRegister(10));
  }


  @Test
  void testToString() {
    AddInstruction a = new AddInstruction("l1", 10, 11, 12);
    Assert.assertEquals("Label: l1, Add the contents of registers 11 and 12 and store the result in register 10", a.toString() );

  }
}