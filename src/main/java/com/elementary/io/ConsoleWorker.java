package com.elementary.io;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public abstract class ConsoleWorker<T, K extends ConsoleWorker> implements AutoCloseable {

    private Scanner scanner = new Scanner(System.in);

    private String errorMessage;
    private T defaultValue;
    private List<T> possibleValues;
    private List<String> inputErrors;

    public T read(String message) {
        printPrompt(message);
        T value;
        do {
            String input = scanner.next();
            if (input.equals("exit")) {
                throw new IllegalStateException("Exit was entered, app closed!");
            }
            value = parse(input).orElse(null);
            boolean validValue = checkRestrictions(value);
            if (!validValue) {
                value = null;
            }
            if (defaultValue != null) {
                value = defaultValue;
            }
        } while (value == null);

        return value;
    }

    protected abstract Optional<T> parse(String input);

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
        if (possibleValues.length > 0) {
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

    private void printPrompt(String message) {
        String promptMessage = message;
        if (defaultValue != null) {
            promptMessage = promptMessage + "[" + defaultValue + "]";
        }
        System.out.println(promptMessage);
    }

    public boolean checkRestrictions(T value) {
        return possibleValues.contains(value);
    }
}
