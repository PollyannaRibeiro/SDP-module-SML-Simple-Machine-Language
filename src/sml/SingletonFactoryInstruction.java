package sml;

public class SingletonFactoryInstruction {

    private static SingletonFactoryInstruction single_instance = null;

    public InstructionFactory factory;
    private SingletonFactoryInstruction(){
        factory = new InstructionFactory();
    }

    public static SingletonFactoryInstruction getInstance(){
        if (single_instance == null){
            single_instance = new SingletonFactoryInstruction();
        }
        return single_instance;
    }
}
