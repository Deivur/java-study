package com.elementary.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberSequenceTest {

    @Test
    void getSeriesOfPositiveIntegers() {
        String expected = "1, 2, 3, 4, 5, 6, 7";

        String actual = NumberSequence.getSeriesOfPositiveIntegers(64);

        assertEquals(expected, actual);
    }
}