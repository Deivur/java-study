package com.elementary.io;

import com.elementary.task.envelope.Envelope;

import java.util.Scanner;

public final class ConsoleReader {

    private ConsoleReader() {
    }

    public static int readSingleNumberInput(Scanner in) {
        return infiniteWhileNotIntEntered(in);
    }

    private static int infiniteWhileNotIntEntered(Scanner in) {
        int intInput = -1;
        boolean stopReading = in.hasNextInt();
        boolean exit = in.hasNext("exit");
        stopReading = stopReading || exit;
        while (!stopReading) {
            System.out.println("Enter integer value or \"exit\":");
            in.next();
            exit = in.hasNext("exit");
            stopReading = in.hasNextInt() || exit;
        }
        if (!exit) {
            intInput = in.nextInt();
        }
        return intInput;
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
