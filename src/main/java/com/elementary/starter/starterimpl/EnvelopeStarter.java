package com.elementary.starter.starterimpl;

import com.elementary.io.ConsoleReader;
import com.elementary.starter.Starter;
import com.elementary.task.envelope.Envelope;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class EnvelopeStarter implements Starter {

    private static final String runInstruction = "To run Envelope app you need " +
            " enter two Envelopes with sides, float values: (a,b) and (c,d)";

    public EnvelopeStarter() {
    }

    public void start(String[] args) {
        try (Scanner in = new Scanner(System.in)) {

            Envelope first = ConsoleReader.readEnvelope(in);
            Envelope second = ConsoleReader.readEnvelope(in);

            boolean availableToPutIn = first.availableToPutIn(second);
            if (availableToPutIn) {
                System.out.println("First envelop available to put in second envelope!");

            } else {
                System.out.println("First envelop not available to put in second envelope!");
            }

            boolean continueReading = ConsoleReader.continueReading(in);
            if (continueReading) {
                start(args);
            }

        } catch (InputMismatchException ime) {
            printRunAppInstruction();
        }
    }

    public void printRunAppInstruction() {
        System.out.println(EnvelopeStarter.runInstruction);
    }
}
