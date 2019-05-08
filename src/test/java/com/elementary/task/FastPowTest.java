package com.elementary.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FastPowTest {

    @ParameterizedTest
    @CsvSource({
            "2, 2, 4",
            "2, 3, 8",
            "2, 4, 16",
            "2, 5, 32",
            "2, 6, 64",
            "2, 7, 128"
    })
    void pow(ArgumentsAccessor arguments) {
        int number = arguments.getInteger(0);
        int power = arguments.getInteger(1);
        int expected = arguments.getInteger(2);

        long actual = FastPow.pow(number, power);

        assertEquals(expected, actual);
    }

    @Test
    void notFasterThanStandardPow() {
        long[] arr1 = new long[10000000];
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr1.length; i ++) {
            arr1[0] = FastPow.pow(2, 64);
        }
        long time1 = System.currentTimeMillis() - startTime;
        System.out.println(time1);

        double[] arr2 = new double[10000000];
        startTime = System.currentTimeMillis();
        for (int i = 0; i < arr2.length; i ++) {
            arr2[0] = Math.pow(2, 64);
        }
        long time2 = System.currentTimeMillis() - startTime;
        System.out.println(time2);

        assertTrue(time2 < time1);
    }
}