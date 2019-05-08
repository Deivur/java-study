package com.elementary.starter;

import com.elementary.io.IntegerConsoleWorker;
import com.elementary.task.NumberSequence;

public class NumberSequenceStarter implements Starter {

    private static final String RUN_INSTRUCTION = "Enter integer value or specify it as run app argument.";

    private static NumberSequenceStarter NUMBER_SEQUENCE_STARTER = new NumberSequenceStarter();

    private NumberSequenceStarter() {
    }

    @Override
    public void start(String[] args) {
        try (IntegerConsoleWorker consoleWorker =
                     new IntegerConsoleWorker().setMinValue(2)) {
            int number;
            if (args.length <= 0) {
                number = consoleWorker.read(RUN_INSTRUCTION);
            } else {
                number = Integer.parseInt(args[0]);
            }
            consoleWorker.print(NumberSequence.getSeriesOfPositiveIntegers(number));
        }
    }

    public static NumberSequenceStarter getInstance() {
        return NumberSequenceStarter.NUMBER_SEQUENCE_STARTER;
    }
}
