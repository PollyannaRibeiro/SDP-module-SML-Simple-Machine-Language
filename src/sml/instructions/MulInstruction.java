package sml.instructions;

import sml.Instruction;
import sml.Machine;

public class MulInstruction extends Instruction {
    public MulInstruction(String label, int register, int s1, int s2) {
        super(label, "mul");
    }

    @Override
    public void execute(Machine m) {

        // TODO: Implement

    }
}
