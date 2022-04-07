package sml.instructions;

import sml.Instruction;
import sml.Machine;

public class OutInstruction extends Instruction {
    private int s1;
    public OutInstruction(String label, int s1) {
        super(label, "out");
        this.s1 = s1;
    }

    @Override
    public void execute(Machine m) {

        System.out.println("OUT: "+ m.getRegisters().getRegister(this.s1));

    }
}
