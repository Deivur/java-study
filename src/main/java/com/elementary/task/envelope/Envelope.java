package com.elementary.task.envelope;

import com.elementary.task.figure.Rectangle;

public class Envelope extends Rectangle {


    public Envelope(float width, float height) {
        super(width, height);
    }

    public boolean availableToPutIn(Envelope envelope) {

        float currentEnvelopSquare = this.getSquare();
        float compareWithEnvelopSquare = envelope.getSquare();

        return compareWithEnvelopSquare > currentEnvelopSquare;
    }
}
