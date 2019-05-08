package com.elementary.task;

import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberSequence {

    public static String getSeriesOfPositiveIntegers(int limitNumber) {
        return IntStream.rangeClosed(1, (int) Math.sqrt(limitNumber))
                .filter(squareIsLessThan(limitNumber))
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "));
    }

    private static IntPredicate squareIsLessThan(int limitNumber) {
        return n -> n * n < limitNumber;
    }
}
