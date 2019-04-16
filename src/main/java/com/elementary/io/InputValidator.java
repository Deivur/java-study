package com.elementary.io;

import com.elementary.exception.InputValidationException;

public final class InputValidator {

    private InputValidator() {
    }

    public static boolean hasRequiredNumberOfArgs(String[] args, int requiredNumberOfArguments) {
        return args.length >= requiredNumberOfArguments;
    }

    public static int getInt(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
            if (number < 0) {
                number = Math.abs(number);
            }
        } catch (NumberFormatException nfe) {
            throw new InputValidationException(nfe.getMessage());
        }
        return number;
    }
}
