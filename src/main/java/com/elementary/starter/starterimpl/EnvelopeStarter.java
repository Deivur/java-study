package com.elementary.starter.starterimpl;

import com.elementary.io.DoubleConsoleWorker;
import com.elementary.io.StringConsoleWorker;
import com.elementary.starter.Starter;
import com.elementary.task.envelope.Envelope;

public final class EnvelopeStarter implements Starter {

    private static final String RUN_INSTRUCTION = "To run Envelope app you need " +
            " specify number of envelopes for comparision and enter sides float" +
            " values: (a,b) in turn";

    private static EnvelopeStarter STARTER = new EnvelopeStarter();

    private EnvelopeStarter() {
    }

    @Override
    public void start(String[] args) {
        try (StringConsoleWorker stringConsoleWorker = new StringConsoleWorker();
             DoubleConsoleWorker doubleConsoleWorker = new DoubleConsoleWorker()) {
            stringConsoleWorker.print(RUN_INSTRUCTION);
            String continueAnswer;
            do {
                Envelope first = readEnvelope(doubleConsoleWorker);
                Envelope second = readEnvelope(doubleConsoleWorker);
                if (first.isAvailableToContain(second)) {
                    stringConsoleWorker.print("First envelope may contain the second");
                } else {
                    stringConsoleWorker.print("First envelope may not contain the second");
                }
                continueAnswer = stringConsoleWorker.read("Do you want to continue?");
            } while (continueAnswer.equals("yes") || continueAnswer.equals("y"));

        }
    }

    private Envelope readEnvelope(DoubleConsoleWorker doubleConsoleWorker) {
        double width = doubleConsoleWorker.read("Enter envelope width:");
        double height = doubleConsoleWorker.read("Enter envelope height:");
        return new Envelope(width, height);
    }

    public static EnvelopeStarter getInstance() {
        return STARTER;
    }
}
