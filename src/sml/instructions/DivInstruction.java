package sml.instructions;

import sml.Instruction;
import sml.Machine;

public class DivInstruction extends Instruction {
    public DivInstruction(String label, int register, int s1, int s2) {
        super(label, "div");
    }

    @Override
    public void execute(Machine m) {

        // TODO: Implement

    }
}
