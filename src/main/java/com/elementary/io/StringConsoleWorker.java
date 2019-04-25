package com.elementary.io;

import java.util.Optional;

public class StringConsoleWorker extends ComparableConsoleWorker<String, StringConsoleWorker> {

    @Override
    protected String parse(String input) {
        return input;
    }
}
