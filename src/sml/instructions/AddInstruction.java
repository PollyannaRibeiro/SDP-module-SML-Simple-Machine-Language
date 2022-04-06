package sml.instructions;

import sml.Instruction;
import sml.Machine;

/**
 * This class represents the Add instruction from the language.
 *
 * @author ...
 */
public class AddInstruction extends Instruction {
    int register;
    int s1;
    int s2;

    public AddInstruction(String label, int register, int s1, int s2){
        super(label, "add");
        this.register = register;
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void execute(Machine m) {

        int n1 = m.getRegisters().getRegister(this.s1);
        int n2 = m.getRegisters().getRegister(this.s2);

        int sum = n1+n2;

        m.getRegisters().setRegister(this.register, sum);

    }
}
