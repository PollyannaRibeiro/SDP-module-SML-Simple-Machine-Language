package sml.instructions;

import sml.Instruction;
import sml.Machine;

public class LinInstruction extends Instruction {
    private int register;
    private int x;
    public LinInstruction(String label, int register, int x) {
        super(label, "lin");
        this.register = register;
        this.x = x;
    }

    @Override
    public void execute(Machine m) {
        m.getRegisters().setRegister(this.register, x);
    }
}
