package com.elementary;

import com.elementary.exception.InputValidationException;
import com.elementary.io.ConsoleReader;
import com.elementary.starter.Starter;

import java.util.Scanner;

public class Application {

    private static final String instruction = generateInstruction();

    public static void main(String[] args) {
        System.out.println(instruction);
        try (Scanner in = new Scanner(System.in)) {
            int appNumber = 0;
            // try read users app choice, if failed - run default sub app number "0"
            try {
                int numberOfUserTriesChoseSubApp = 3;
                appNumber = ConsoleReader.readIntegerInput(in, numberOfUserTriesChoseSubApp);

            } catch (InputValidationException ive) {
                printWrongUserInputForAppChoice(ive.getMessage());
            }

            SubApplication subApplication = SubApplication.get(appNumber);
            Starter starter = subApplication.getStarter();
            try {
                starter.start(args);

            } catch (InputValidationException ive) {
                starter.printSubAppRunInstruction();
            }
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

    private static void printWrongUserInputForAppChoice(String message) {
        System.out.println(String.format("Cant read sub app number: %s. Start default...", message));
    }
}
