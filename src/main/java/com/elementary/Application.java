package com.elementary;

import com.elementary.starter.Starter;

import java.util.Scanner;

public class Application {

    private static final String INSTRUCTION = generateInstruction();

    public static void main(String[] args) {
        System.out.println(INSTRUCTION);
        try (Scanner in = new Scanner(System.in)) {
            int appNumber = 0;
            // try read users app choice, if failed - run default sub app number "0"
            int numberOfUserTriesChoseSubApp = 3;
//            appNumber = ConsoleReader.readIntegerInput(in, numberOfUserTriesChoseSubApp);
//
//            SubApplication subApplication = SubApplication.getSubAppStarter(appNumber);
//            Starter starter = subApplication.getStarter();
//            starter.start(args);
//            System.out.println(String.format("Cant read sub app number: %s. Start default...", message));

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
        instruction.append("enter a number");
        return instruction.toString();
    }

}
