package com.elementary.io;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public abstract class ConsoleWorker<T, K extends ConsoleWorker> implements AutoCloseable {

    private Scanner scanner = new Scanner(System.in);

    private String errorMessage;
    private T defaultValue;
    private List<T> possibleValues;
    private List<String> inputErrors;

    public T read(String message) {
        // TODO: 4/22/19 read logic goes here
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("unchecked")
    public K withDefaultValue(T value) {
        this.defaultValue = value;
        return (K) this;
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    @SuppressWarnings("unchecked")
    public K withPossibleValues(T... possibleValues) {
        this.possibleValues = null;
        if(possibleValues.length > 0) {
            this.possibleValues = Arrays.asList(possibleValues);
        }
        return (K) this;
    }

    public List<T> getPossibleValues() {
        return possibleValues;
    }

    @SuppressWarnings("unchecked")
    public K setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return (K) this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public void close() throws Exception {
        scanner.close();
    }
}
