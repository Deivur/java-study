package com.elementary.task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Fibonacci {

    public static String getFibonacciNumbersForRange(int start, int end) {
        List<Integer> fibonacciNumbers = new ArrayList<>();
        int num = 0;
        for (int i = 0; num <= end; i++) {
            num = fibonacci(i);
            if (num <= end) {
                fibonacciNumbers.add(num);
            }
        }
        return fibonacciNumbers.stream()
                .filter(n -> n >= start)
                .map(n -> Integer.toString(n))
                .collect(Collectors.joining(", "));
    }

    public static int fibonacci(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        } else{
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
