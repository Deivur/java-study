package com.elementary.io;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public abstract class ConsoleWorker<T, K extends ConsoleWorker> implements AutoCloseable {

    private Scanner scanner = new Scanner(System.in);

    private String errorMessage;
    private T defaultValue;
    private List<T> possibleValues;

    @Override
    public void close() {
        scanner.close();
    }

    public T read(String message) {
        T value;
        do {
            printPrompt(message);
            String input = scanner.nextLine();
            value = parse(input);
            if (value == null) {
                if (errorMessage != null) {
                    print(errorMessage);
                } else {
                    print("Entered value is not valid!" );
                }
                if (defaultValue != null) {
                    print("Take default value: " + defaultValue);
                    value = defaultValue;
                }
            } else {
                boolean isValid = checkConditions(value);
                if (!isValid) {
                    value = null;
                }
            }
        } while (value == null);

        return value;
    }

    protected abstract T parse(String input);

    @SuppressWarnings("unchecked")
    public K setDefaultValue(T value) {
        this.defaultValue = value;
        return (K) this;
    }

    @SuppressWarnings("unchecked")
    public K setPossibleValues(T... possibleValues) {
        this.possibleValues = null;
        if (possibleValues.length > 0) {
            this.possibleValues = Arrays.asList(possibleValues);
        }
        return (K) this;
    }

    @SuppressWarnings("unchecked")
    public K setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return (K) this;
    }

    public boolean checkConditions(T value) {
        boolean isValid = true;
        if (possibleValues != null) {
            isValid = possibleValues.contains(value);
            if (!isValid) {
                print("Restriction check failed: entered value="
                        + value + ", acceptable: " + possibleValues);
            }
        }
        return isValid;
    }

    public boolean continueInput() {
        print("Do you want to continue?");
        String continueAnswer = scanner.nextLine();
        return continueAnswer.equals("yes") || continueAnswer.equals("y");
    }

    public void print(String message) {
        System.out.println(message);
    }

    private void printPrompt(String message) {
        String promptMessage = message;
        if (defaultValue != null) {
            promptMessage = promptMessage + " default(" + defaultValue + ")";
        }
        print(promptMessage);
    }
}
