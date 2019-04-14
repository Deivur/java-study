package com.elementary;

import com.elementary.io.ConsoleReader;

import java.util.Scanner;

public class Application {

    public static final String instruction = generateInstruction();

    public static void main(String[] args) {
        System.out.println(instruction);
        try (Scanner in = new Scanner(System.in)) {
            int appNumber = ConsoleReader.readSingleNumberInput(in);
            SubApplication subApplication = SubApplication.get(appNumber);
            subApplication.getStarter().start(args);
        }
    }

    private static String generateInstruction() {
        StringBuilder instruction =
                new StringBuilder("Elementary task application has several sub application," +
                        " chose one:" + System.lineSeparator());
        for (SubApplication subApplication : SubApplication.values()) {
            instruction.append(subApplication.ordinal())
                    .append(" - ")
                    .append(subApplication.name())
                    .append(System.lineSeparator());
        }
        instruction.append("enter a number(or run default 0):");
        return instruction.toString();
    }
}
