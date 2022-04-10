package sml;

import sml.instructions.*;
import sml.Translator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InstructionFactory implements AbstractInstructionFactory {

    @Override
    public Instruction createInstruction(String label, String opcode, ScanAccessor scan) {

        try {
//        REFLECTION
//        find the path
            char firstLetterOpcode = opcode.charAt(0);
            String op = Character.toString(firstLetterOpcode).toUpperCase()+opcode.substring(1);

            Class<?> klass = null;

                klass = Class.forName("sml.instructions."+op+"Instruction");

            Constructor<?> cons = klass.getDeclaredConstructors()[0];

            Class<?>[] parameters = cons.getParameterTypes();
            Object[] dependencies = new Object[parameters.length];

//          start from 1 because we already have the label
            for (int i = 1; i < parameters.length; i++) {
                Class<?> parameter =  parameters[i];
                dependencies[i] = scan.resolve(parameter);
            }

            if (dependencies.length == 2) {
                return (Instruction) cons.newInstance(label, dependencies[1]);
            } else if (dependencies.length == 3) {
                return (Instruction) cons.newInstance(label, dependencies[1], dependencies[2]);
            } else if (dependencies.length == 4) {
                return (Instruction) cons.newInstance(label, dependencies[2], dependencies[2], dependencies[3]);
            } else {
                throw new ClassNotFoundException();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
