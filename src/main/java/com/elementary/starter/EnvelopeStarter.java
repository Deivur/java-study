package com.elementary.starter;

import com.elementary.io.DoubleConsoleWorker;
import com.elementary.task.Envelope;

public final class EnvelopeStarter implements Starter {

    private static final String RUN_INSTRUCTION = "To run Envelope app you need " +
            " specify number of envelopes for comparision and enter sides float" +
            " values: (a,b) in turn";

    private static EnvelopeStarter ENVELOPE_STARTER = new EnvelopeStarter();

    private EnvelopeStarter() {
    }

    @Override
    public void start(String[] args) {
        try (DoubleConsoleWorker consoleWorker = new DoubleConsoleWorker().setMinValue(0.0)) {
            consoleWorker.print(RUN_INSTRUCTION);
            do {
                Envelope first = readEnvelope(consoleWorker);
                Envelope second = readEnvelope(consoleWorker);
                if (first.isAvailableToContain(second)) {
                    consoleWorker.print("First envelope may contain the second");
                } else {
                    consoleWorker.print("First envelope may not contain the second");
                }
            } while (consoleWorker.continueInput());

        }
    }

    private Envelope readEnvelope(DoubleConsoleWorker consoleWorker) {
        double width = consoleWorker.read("Enter envelope width:");
        double height = consoleWorker.read("Enter envelope height:");
        return new Envelope(width, height);
    }

    public static EnvelopeStarter getInstance() {
        return ENVELOPE_STARTER;
    }
}
