package sml.instructions;

import sml.Instruction;
import sml.Machine;

public class LinInstruction extends Instruction {
    public LinInstruction(String label, int register, int s1, int s2) {
        super(label, "out");
    }

    @Override
    public void execute(Machine m) {

        // TODO: Implement

    }
}
