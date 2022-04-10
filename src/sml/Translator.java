package sml;

import sml.instructions.*;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * This class ....
 * <p>
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 *
 * @author ...
 */
public final class Translator {

    private static final String PATH = "";

    // word + line is the part of the current line that's not yet processed
    // word has no whitespace
    // If word and line are not empty, line begins with whitespace
    private final String fileName; // source file of SML code
    private String line = "";

    public Translator(String file) {
        fileName = PATH + file;
    }

    // translate the small program in the file into lab (the labels) and
    // prog (the program)
    // return "no errors were detected"

    public boolean readAndTranslate(Labels lab, List<Instruction> prog) {
        try (var sc = new Scanner(new File(fileName), "UTF-8")) {
            // Scanner attached to the file chosen by the user
            // The labels of the program being translated
            lab.reset();
            // The program to be created
            prog.clear();

            try {
                line = sc.nextLine();
            } catch (NoSuchElementException ioE) {
                return false;
            }

            // Each iteration processes line and reads the next input line into "line"
            while (line != null) {
                // Store the label in label
                var label = scan();

                if (label.length() > 0) {
                    var ins = getInstruction(label);
                    if (ins != null) {
                        lab.addLabel(label);
                        prog.add(ins);
                    }
                }

                try {
                    line = sc.nextLine();
                } catch (NoSuchElementException ioE) {
                    return false;
                }
            }
        } catch (IOException ioE) {
            System.err.println("File: IO error " + ioE);
            return false;
        }
        return true;
    }

    private Instruction createReflectionWithCaseSwitch(String label) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> klass = Class.forName("sml.instructions.BnzInstruction");
//        System.out.println("😅");
        Constructor<?> cons = klass.getDeclaredConstructors()[0];
        System.out.println(Arrays.toString(cons.getParameterTypes()));
        System.out.println(Arrays.toString(cons.getAnnotatedParameterTypes()));

        Class<?>[] parameters = cons.getParameterTypes();
        Object[] dependencies = new Object[parameters.length];
//start from 1 because we already have the label
        for (int i = 1; i < parameters.length; i++) {
            Class<?> parameter =  parameters[i];
            if (parameter.getTypeName() == "java.lang.String") {
                dependencies[i] = scan();
            } else if (parameter.getTypeName() == "int") {
                dependencies[i] = scanInt();
            } else if (parameter.getTypeName() == "sml.LabelAccessor") {
                dependencies[i] = new LabelAccessor(scan());
            }
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
    }

    // The input line should consist of an SML instruction, with its label already removed.
    // Translate line into an instruction with label "label" and return the instruction
    public Instruction getInstruction(String label) {
        int s1; // Possible operands of the instruction
        int s2;
        int r;
        int x;
        String L2;
        String lbl;

        if (line.equals("")) {
            return null;
        }
        var opCode = scan();



        switch (opCode) {
            case "add" -> {
                r = scanInt();
                s1 = scanInt();
                s2 = scanInt();
                return new AddInstruction(label, r, s1, s2);
            }
            case "sub" -> {
                r = scanInt();
                s1 = scanInt();
                s2 = scanInt();
                return new SubInstruction(label, r, s1, s2);
            }
            case "mul" -> {
//                r = scanInt();
//                s1 = scanInt();
//                s2 = scanInt();
                try {
                    return createReflectionWithCaseSwitch(label);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
//                return new MulInstruction(label, r, s1, s2);
            }
            case "div" -> {
                r = scanInt();
                s1 = scanInt();
                s2 = scanInt();
                return new DivInstruction(label, r, s1, s2);
            }
            case "out" -> {
                s1 = scanInt();
                return new OutInstruction(label, s1);
            }
            case "lin" -> {
                r = scanInt();
                x = scanInt();
                return new LinInstruction(label, r, x);
            }
            case "bnz" -> {
//                s1 = scanInt();
//                L2 = scan();
//                LabelAccessor l2 = new LabelAccessor(L2);

                try {
                    return createReflectionWithCaseSwitch(label);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
//                return new BnzInstruction(label, s1, l2);
            }

            default -> {
                System.out.println("Unknown instruction: " + opCode);
            }
        }
        return null; // FIX THIS
    }

    /*
     * Return the first word of line and remove it from line. If there is no word, return ""
     */
    private String scan() {
        line = line.trim();
        if (line.length() == 0) {
            return "";
        }

        int i = 0;
        while (i < line.length() && line.charAt(i) != ' ' && line.charAt(i) != '\t') {
            i = i + 1;
        }
        String word = line.substring(0, i);
        line = line.substring(i);
        return word;
    }

    // Return the first word of line as an integer. If there is any error, return the maximum int
    private int scanInt() {
        String word = scan();
        if (word.length() == 0) {
            return Integer.MAX_VALUE;
        }

        try {
            return Integer.parseInt(word);
        } catch (NumberFormatException e) {
            return Integer.MAX_VALUE;
        }
    }
}