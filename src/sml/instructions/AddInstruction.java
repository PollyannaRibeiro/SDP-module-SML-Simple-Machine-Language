package sml.instructions;

import sml.Instruction;
import sml.Machine;

/**
 * This class represents the Add instruction from the language.
 *
 * @author ...
 */
public class AddInstruction extends Instruction {
    private int register;
    private int s1;
    private int s2;

    private int n1;
    private int n2;

    public AddInstruction(String label, int register, int s1, int s2){
        super(label, "add");
        this.register = register;
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void execute(Machine m) {

        n1 = m.getRegisters().getRegister(this.s1);
        n2 = m.getRegisters().getRegister(this.s2);
        int sum = n1+n2;

        m.getRegisters().setRegister(this.register, sum);
    }

    @Override
    public String toString() {
        return "Label: " + this.getLabel() + ", Add the contents of registers " + this.s1 + " and " + this.s2 + " and store the result in register " + this.register ;
    }
}
