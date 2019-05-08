package com.elementary.io;

public class IntegerConsoleWorker extends ComparableConsoleWorker<Integer, IntegerConsoleWorker> {

    @Override
    protected Integer parse(String input) {
        Integer value;
        try {
            value = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            value = null;
        }
        return value;
    }
}
