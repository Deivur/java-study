package com.elementary.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class EnvelopeTest {

    private Envelope templateEnvelope;

    @BeforeEach
    void init() {
        templateEnvelope = new Envelope(20, 30);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "19.1, 29.9",
            "-25, 5",
            "31, 1",
            "0, 0"
    })
    void isAvailableToContain(@AggregateWith(EnvelopeAggregator.class) Envelope envelope) {
        assertTrue(templateEnvelope.isAvailableToContain(envelope));
    }

    @ParameterizedTest
    @CsvSource({
            "21, 31",
            "31, 21",
            "35, 20"
    })
    void isNotAvailableToContain(@AggregateWith(EnvelopeAggregator.class) Envelope envelope) {
        assertFalse(templateEnvelope.isAvailableToContain(envelope));
    }
}