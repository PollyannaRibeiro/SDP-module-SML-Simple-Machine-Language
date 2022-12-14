package sml.instructions;

import sml.Instruction;
import sml.Machine;

public class MulInstruction extends Instruction {
    private int register;
    private int s1;
    private int s2;
    public MulInstruction(String label, int register, int s1, int s2) {
        super(label, "mul");
        this.register = register;
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void execute(Machine m) {

        int n1 = m.getRegisters().getRegister(this.s1);
        int n2 = m.getRegisters().getRegister(this.s2);
        int mul = n1*n2;

        m.getRegisters().setRegister(this.register, mul);
    }

    @Override
    public String toString() {
        return "Label: " + this.getLabel() + ", Multiply the contents of registers " + this.s1 + " and " + this.s2 + " and store the result in register " + this.register ;
    }
}
