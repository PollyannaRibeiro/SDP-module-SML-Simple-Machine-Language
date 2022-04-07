package sml.instructions;

import sml.AccessLabel;
import sml.Instruction;
import sml.Machine;

public class BnzInstruction extends Instruction {
    private int s1;
    private String l2;

    public BnzInstruction(String label, int s1, String L2) {
        super(label, "bnz");
        this.s1 = s1;
        this.l2 = L2;
    }

    @Override
    public void execute(Machine m) {

        int n = m.getRegisters().getRegister(this.s1);
        if (n != 0){

            AccessLabel access = new AccessLabel(l2);
            int indexLabel = access.getLabelIndexOf(m);
            m.setPc(indexLabel);
        }
    }
}
