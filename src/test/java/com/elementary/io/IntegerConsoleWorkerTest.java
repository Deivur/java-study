package com.elementary.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerConsoleWorkerTest {

    private IntegerConsoleWorker consoleWorker;

    @BeforeEach
    void init() {
        consoleWorker = new IntegerConsoleWorker();
    }

    @Test
    void whenInputBiggerMinValueThanTrue() {
        consoleWorker.setMinValue(2);
        int inputValue = 3;

        assertTrue(consoleWorker.checkConditions(inputValue));
    }

    @Test
    void whenInputLessMinValueThanFalse() {
        consoleWorker.setMinValue(2);
        int inputValue = 1;

        assertFalse(consoleWorker.checkConditions(inputValue));
    }

    @Test
    void whenPossibleValueThanTrue() {
        consoleWorker.setPossibleValues(2, 3, 4);
        int inputValue = 3;

        assertTrue(consoleWorker.checkConditions(inputValue));
    }

    @Test
    void whenNotPossibleValueThanFalse() {
        consoleWorker.setPossibleValues(2, 3, 4);
        int inputValue = 5;

        assertFalse(consoleWorker.checkConditions(inputValue));
    }
}