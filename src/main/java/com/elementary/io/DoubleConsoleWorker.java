package com.elementary.io;

import java.util.Optional;

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
