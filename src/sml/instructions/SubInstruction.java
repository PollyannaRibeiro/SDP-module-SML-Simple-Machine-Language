package sml.instructions;

import sml.Instruction;
import sml.Machine;

public class SubInstruction extends Instruction {

    public SubInstruction(String label, int register, int s1, int s2) {
        super(label, "sub");
    }

    @Override
    public void execute(Machine m) {

        // TODO: Implement

    }
}

