package com.elementary.task;

public class FastPow {

    public static long pow(long number, long power) {
        long base = 1;
        while (power > 0) {
            if (power % 2 == 1) {
                base *= number;
                power--;
            }
            power /= 2;
            number *= number;
        }
        return base;
    }
}
