package com.elementary;

import com.elementary.io.IntegerConsoleWorker;
import com.elementary.starter.Starter;

public class Application {

    private static final String INSTRUCTION = generateInstruction();

    public static void main(String[] args) {
        try (IntegerConsoleWorker consoleWorker = new IntegerConsoleWorker()) {
            int appNumber = consoleWorker
                    .setDefaultValue(0)
                    .setMinValue(0)
                    .setMaxValue(SubApplication.values().length)
                    .read(INSTRUCTION);

            SubApplication subApplication = SubApplication.getSubAppStarter(appNumber);
            Starter starter = subApplication.getStarter();
            starter.start(args);
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
