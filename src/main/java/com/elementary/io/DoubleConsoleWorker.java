package com.elementary.io;

public class DoubleConsoleWorker extends ComparableConsoleWorker<Double, DoubleConsoleWorker> {

    @Override
    protected Double parse(String input) {
        Double value;
        try {
            value = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            value = null;
        }
        return value;
    }
}
