package com.elementary.task;

import static java.lang.Math.sqrt;

public class Envelope {

    private final double width;
    private final double height;

    public Envelope(double width, double height) {
        this.width = Math.abs(width);
        this.height = Math.abs(height);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }


    public boolean isAvailableToContain(Envelope envelope) {
        return isBiggerBySides(envelope) || isContainInside(envelope);
    }

    private boolean isContainInside(Envelope envelope) {
        // width > height if not - rotate
        // a,b (width,height) - this envelope, p,q (width,height) - argument envelope
        double a = this.getLongerSide();
        double b = this.getShorterSide();

        double p = envelope.getLongerSide();
        double q = envelope.getShorterSide();

        return b >= (2 * p * q * a + (p * p - q * q) * sqrt(p * p + q * q - a * a)) / (p * p + q * q);
    }

    private double getLongerSide() {
        return this.width > this.height ? this.width : this.height;
    }

    private double getShorterSide() {
        return this.width < this.height ? this.width : this.height;
    }

    private boolean isBiggerBySides(Envelope envelope) {
        return (this.height > envelope.getHeight() && this.width > envelope.getWidth()) ||
                this.height > envelope.getWidth() && this.width > envelope.getHeight();
    }

    @Override
    public String toString() {
        return "Envelope{" +
                " (width=" + getWidth() + "," +
                " height=" + getHeight() + ")" +
                '}';
    }
}
