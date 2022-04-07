package sml.instructions;

import sml.LabelAccessor;
import sml.Instruction;
import sml.Machine;

public class BnzInstruction extends Instruction {
    private int s1;
    private LabelAccessor l2;

    public BnzInstruction(String label, int s1, LabelAccessor label2) {
        super(label, "bnz");
        this.s1 = s1;
        this.l2 = label2;
    }

    @Override
    public void execute(Machine m) {

        int n = m.getRegisters().getRegister(this.s1);
        if (n != 0){

            int indexLabel = this.l2.getLabelIndexOf(m);
            m.setPc(indexLabel);
        }
    }

    @Override
    public String toString() {
        return "Label: " + this.getLabel() + ", If the contents of register " + this.s1 +
                " is not zero, then make the statement labeled " + this.l2.getLabel() + "the next statement to execute";
    }
}
