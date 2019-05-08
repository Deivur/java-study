package com.elementary.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LuckyTicketsCounterTest {

    @ParameterizedTest
    @ValueSource(ints = {100001, 999999, 452254})
    void isLuckyMoscowTickets(int ticketNumber) {
        assertTrue(LuckyTicketsCounter.MOSCOW.isLucky(ticketNumber));
    }

    @ParameterizedTest
    @ValueSource(ints = {110001, 979999, 453254, 11, 132, 4554, 5555})
    void isNotLuckyMoscowTickets(int ticketNumber) {
       assertFalse(LuckyTicketsCounter.MOSCOW.isLucky(ticketNumber));
    }

    @ParameterizedTest
    @ValueSource(ints = {231000, 999999, 452254, 231011})
    void isLuckyPetersburgTickets(int ticketNumber) {
        assertTrue(LuckyTicketsCounter.PETERSBURG.isLucky(ticketNumber));
    }

    @ParameterizedTest
    @ValueSource(ints = {110001, 979999, 453254, 12, 232, 4552})
    void isNotLuckyPetersburgTickets(int ticketNumber) {
        System.out.println(LuckyTicketsCounter.MOSCOW.isLucky(ticketNumber));
        assertFalse(LuckyTicketsCounter.PETERSBURG.isLucky(ticketNumber));
    }


    @Test
    void calculateOneMoscowLuckyTickets() {
        IntStream intStream = IntStream.rangeClosed(100001, 100999);
        int expected = 3;

        int actual = LuckyTicketsCounter.MOSCOW.calculateLuckyTickets(intStream);

        assertEquals(expected, actual);
    }

    @Test
    void calculateOnePetersburgLuckyTickets() {
        IntStream intStream = IntStream.rangeClosed(100001, 100009);
        int expected = 1;

        int actual = LuckyTicketsCounter.PETERSBURG.calculateLuckyTickets(intStream);

        assertEquals(expected, actual);
    }
}