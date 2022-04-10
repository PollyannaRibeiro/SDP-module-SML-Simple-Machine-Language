package sml;

public interface AbstractInstructionFactory {


    public Instruction createInstruction(String l, String op, ScanAccessor scan);
}
