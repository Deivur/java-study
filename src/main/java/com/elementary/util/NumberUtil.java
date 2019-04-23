package com.elementary.util;

public final class NumberUtil {

    private NumberUtil() {
    }

    public static boolean isEven(int number) {
        return (number & 1) == 0;
    }

    public static boolean isOdd(int number) {
        return (number & 1) != 0;
    }
}
