package sml.instructions;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.Machine;
import sml.Registers;
import sml.Translator;

import static org.junit.jupiter.api.Assertions.*;

class AddInstructionTest {
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
    m.getRegisters().setRegister(11, 1);
    m.getRegisters().setRegister(12, 2);
    AddInstruction a = new AddInstruction("l1", 10, 11, 12);
    a.execute(m);
    Assert.assertEquals(4, m.getRegisters().getRegister(10));
  }

  @Test
  void testToString() {
  }
}