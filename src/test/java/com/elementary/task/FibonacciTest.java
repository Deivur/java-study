package com.elementary.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void getFibonacciNumbersForRange() {
        int start = 0;
        int end = 21;
        String expected = "0, 1, 1, 2, 3, 5, 8, 13, 21";

        String actual = Fibonacci.getFibonacciNumbersForRange(start, end);

        assertEquals(expected, actual);
    }
}