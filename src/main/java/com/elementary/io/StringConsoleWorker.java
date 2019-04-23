package com.elementary.io;

import java.util.Optional;

public class StringConsoleWorker extends ComparableConsoleWorker<String, StringConsoleWorker> {

    @Override
    protected Optional<String> parse(String input) {
        return Optional.ofNullable(input);
    }
}
