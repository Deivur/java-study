package com.elementary.io;

import com.elementary.exception.ExceptionMessage;
import com.elementary.exception.InputValidationException;
import com.elementary.task.envelope.Envelope;

import java.util.Scanner;

public final class ConsoleReader {

    private ConsoleReader() {
    }

    public static int readIntegerInput(Scanner in) {
        return InputValidator.getInt(in.next());
    }

    public static int readIntegerInput(Scanner in, int numberOfTries) {
        String stringInput = in.next();
        for (int i = 0; i <= numberOfTries; i++) {
            try {
                return InputValidator.getInt(stringInput);

            } catch (InputValidationException ive) {
                if (i < numberOfTries) {
                    System.out.println(
                            String.format("Entered value is not number!" +
                                    " Try again(attempt left: %s):", (numberOfTries - i)));
                }
            }
        }
        throw new InputValidationException(ExceptionMessage.CANT_READ_INTEGER_AS_INPUT);
    }

    public static boolean continueReading(Scanner in) {
        System.out.println("Do you want to continue?");
        String answer = in.next();
        return (answer.equals("yes") || answer.equals("y"));
    }

    public static Envelope readEnvelope(Scanner in) {
        System.out.println("Enter envelop width:");
        float width = in.nextFloat();

        System.out.println("Enter envelop height:");
        float height = in.nextFloat();

        return new Envelope(width, height);
    }
}
