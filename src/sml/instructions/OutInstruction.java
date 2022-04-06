package sml.instructions;

import sml.Instruction;
import sml.Machine;

public class OutInstruction extends Instruction {
    public OutInstruction(String label, int register, int s1, int s2) {
        super(label, "out");
    }

    @Override
    public void execute(Machine m) {

        // TODO: Implement

    }
}
