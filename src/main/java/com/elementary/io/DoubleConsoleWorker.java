package com.elementary.io;

import java.util.Optional;

public class DoubleConsoleWorker extends ComparableConsoleWorker<Float, DoubleConsoleWorker> {

    @Override
    protected Optional<Float> parse(String input) {
        Float value;
        try {
            value = Float.parseFloat(input);
        } catch (NumberFormatException e) {
            value = null;
        }
        return Optional.ofNullable(value);
    }
}
