package com.elementary.starter.starterimpl;

import com.elementary.io.ConsoleReader;
import com.elementary.starter.Starter;
import com.elementary.task.envelope.Envelope;

import java.util.*;

public final class EnvelopeStarter implements Starter {

    private static final String RUN_INSTRUCTION = "To run Envelope app you need " +
            " specify number of envelopes for comparision and enter sides float" +
            " values: (a,b) in turn";

    private static EnvelopeStarter STARTER = new EnvelopeStarter();

    private EnvelopeStarter() {
    }

    @Override
    public void start(String[] args) {
        try (Scanner in = new Scanner(System.in)) {

            enterEnvelopesAndPrintCompariosionResult(in);

            boolean continueReading = ConsoleReader.continueReading(in);
            if (continueReading) {
                enterEnvelopesAndPrintCompariosionResult(in);
            }

        }
    }

    private void enterEnvelopesAndPrintCompariosionResult(Scanner in) {
        int envelopeCount = ConsoleReader.getEnvelopeCount(in);

        List<Envelope> envelopes = ConsoleReader.readEnvelopes(in, envelopeCount);

        Map<Envelope, List<Envelope>> comparisionResult = new HashMap<>();
        for (Envelope envelope : envelopes) {
            List<Envelope> envelopesInside = new ArrayList<>();
            for (Envelope envelopeInside : envelopes) {
                // remove itself from comparision
                if (envelope.getEnvelopeNumber() != envelopeInside.getEnvelopeNumber()) {

                    if (envelope.isAvailableToContain(envelopeInside)) {
                        envelopesInside.add(envelopeInside);
                    }
                }
            }
            comparisionResult.put(envelope, envelopesInside);
        }

        Envelope.printComparisionResult(comparisionResult);
        Envelope.resetCounter();
    }

    public static EnvelopeStarter getInstance() {
        return STARTER;
    }
}
