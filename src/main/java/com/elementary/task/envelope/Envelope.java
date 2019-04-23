package com.elementary.task.envelope;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Envelope {

    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    private final int envelopeNumber;
    private final double width;
    private final double height;

    public Envelope(float width, float height) {
        this.width = width;
        this.height = height;
        this.envelopeNumber = COUNTER.incrementAndGet();
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDiagonal() {
        float exponent = 2;
        return sqrt(pow(width, exponent) + pow(height, exponent));
    }

    public boolean isAvailableToContain(Envelope envelope) {
        return isBiggerBySides(envelope) || isContainInside(envelope);
    }

    private boolean isContainInside(Envelope envelope) {
        if (envelope.getDiagonal() > this.getDiagonal()) {
            return false;
        }
        return true;
    }

    private boolean isBiggerBySides(Envelope envelope) {
        return (this.height > envelope.getHeight() && this.width > envelope.getWidth()) ||
                this.height > envelope.getWidth() && this.width > envelope.getHeight();
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
