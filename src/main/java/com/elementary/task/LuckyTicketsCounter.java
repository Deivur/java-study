package com.elementary.task;

import java.util.stream.IntStream;

public enum LuckyTicketsCounter {
    MOSCOW {
        @Override
        public boolean isLucky(int ticketNumber) {
            int[] ticket = LuckyTicketsCounter.expandNumber(ticketNumber);
            return (ticket[0] + ticket[1] + ticket[2]) == (ticket[3] + ticket[4] + ticket[5]);
        }
    },
    PETERSBURG {
        @Override
        public boolean isLucky(int ticketNumber) {
            int[] ticket = LuckyTicketsCounter.expandNumber(ticketNumber);
            return (ticket[0] + ticket[2] + ticket[4]) == (ticket[1] + ticket[3] + ticket[5]);
        }
    };

    private static int[] expandNumber(int number) {
        int[] numberParts = new int[6];
        numberParts[0] = number / 100000;
        numberParts[1] = (number / 10000) % 10;
        numberParts[2] = (number / 1000) % 10;
        numberParts[3] = (number / 100) % 10;
        numberParts[4] = (number / 10) % 10;
        numberParts[5] = number % 10;
        return numberParts;
    }

    public int calculateLuckyTickets(IntStream intStream) {
        return (int) intStream
                .filter(this::isLucky)
                .count();
    }

    public abstract boolean isLucky(int ticketNumber);
}
