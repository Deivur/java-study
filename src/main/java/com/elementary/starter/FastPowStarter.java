package com.elementary.starter;

import com.elementary.io.IntegerConsoleWorker;
import com.elementary.task.FastPow;

public class FastPowStarter implements Starter {

    private static final String RUN_INSTRUCTION = "Enter value or specify it as run app argument: <number> <power>";

    private static FastPowStarter FAST_POWER_STARTER = new FastPowStarter();

    private FastPowStarter() {
    }

    @Override
    public void start(String[] args) {
        try (IntegerConsoleWorker consoleWorker = new IntegerConsoleWorker()) {
            int number;
            int power;
            if (args.length < 2) {
                number = consoleWorker.read("Enter a number:");
                power = consoleWorker.read("Enter a power:");
            } else {
                number = Integer.parseInt(args[0]);
                power = Integer.parseInt(args[1]);
            }
            consoleWorker.print(FastPow.pow(number, power));
        }
    }

    public static FastPowStarter getInstance() {
        return FastPowStarter.FAST_POWER_STARTER;
    }
}
