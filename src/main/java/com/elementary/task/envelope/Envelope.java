package com.elementary.task.envelope;

import com.elementary.task.figure.Rectangle;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Envelope extends Rectangle {

    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    private int envelopeNumber;

    public Envelope(float width, float height) {
        super(width, height);
        this.envelopeNumber = COUNTER.incrementAndGet();
    }

    public int getEnvelopeNumber() {
        return envelopeNumber;
    }

    public static void resetCounter() {
        COUNTER.set(0);
    }

    public static void printComparisionResult(Map<Envelope, List<Envelope>> comparisionResult) {
        comparisionResult.forEach((envelope, envelopeList) -> {
            if (envelopeList.isEmpty()) {
                printNotContainAnyEnvelope(envelope);

            } else {
                printContainEnvelopes(envelope, envelopeList);
            }
        });
    }

    private static void printContainEnvelopes(Envelope envelope, List<Envelope> envelopeList) {
        StringBuilder message = new StringBuilder(envelope + " contain:");
        for (Envelope containedEnvelope : envelopeList) {
            message.append(containedEnvelope.getEnvelopeNumber()).append(" ");
        }
        System.out.println(message.toString());
    }

    private static void printNotContainAnyEnvelope(Envelope envelope) {
        System.out.println(envelope + " not cannot contain other envelope.");
    }

    @Override
    public String toString() {
        return "Envelope{" +
                "number=" + envelopeNumber +
                " (width=" + getWidth() + "," +
                " height=" + getHeight() + ")" +
                '}';
    }
}
