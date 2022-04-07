package sml.instructions;

import sml.Instruction;
import sml.Machine;

public class DivInstruction extends Instruction {
    private int register;
    private int s1;
    private int s2;
    public DivInstruction(String label, int register, int s1, int s2) {
        super(label, "div");
        this.register = register;
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void execute(Machine m) {

        int n1 = m.getRegisters().getRegister(this.s1);
        int n2 = m.getRegisters().getRegister(this.s2);
        int div = n1/n2;

        m.getRegisters().setRegister(this.register, div);
    }
}
