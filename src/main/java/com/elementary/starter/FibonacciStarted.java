package com.elementary.starter;

import com.elementary.io.IntegerConsoleWorker;
import com.elementary.task.Fibonacci;

public class FibonacciStarted implements Starter {

    private static final String RUN_INSTRUCTION = "Specify range by two integer numbers as app arguments.";

    private static FibonacciStarted FIBONACCI = new FibonacciStarted();

    private FibonacciStarted() {
    }

    @Override
    public void start(String[] args) {
        try (IntegerConsoleWorker consoleWorker = new IntegerConsoleWorker()) {
            int start;
            int end;
            if (args.length < 2) {
                start = consoleWorker.read("Enter a start of range:");
                end = consoleWorker.read("Enter an end of range:");
            } else {
                start = Integer.parseInt(args[0]);
                end = Integer.parseInt(args[1]);
            }
            consoleWorker.print(Fibonacci.getFibonacciNumbersForRange(start, end));
        }

    }

    public static FibonacciStarted getInstance() {
        return FibonacciStarted.FIBONACCI;
    }
}
