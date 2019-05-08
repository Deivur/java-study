package com.elementary.io;

public class StringConsoleWorker extends ComparableConsoleWorker<String, StringConsoleWorker> {

    @Override
    protected String parse(String input) {
        return input;
    }
}
