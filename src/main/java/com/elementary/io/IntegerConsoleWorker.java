package com.elementary.io;

import java.util.Optional;

public class IntegerConsoleWorker extends ComparableConsoleWorker<Integer, IntegerConsoleWorker> {

    @Override
    protected Optional<Integer> parse(String input) {
        Integer value;
        try {
            value = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            value = null;
        }
        return Optional.ofNullable(value);
    }
}