package com.elementary.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TriangleValidatorTest {

    @ParameterizedTest
    @CsvSource({
            "8, 5, 6",
            " 41, 52, 63",
    })
    void whenEverySideLessThanOthersShouldTrue(ArgumentsAccessor arguments) {
        boolean actual = TriangleValidator.exist(
                arguments.getDouble(0),
                arguments.getDouble(1),
                arguments.getDouble(2)
        );

        assertTrue(actual);
    }

    @ParameterizedTest
    @CsvSource({
            "8, 5, 15",
            "180, 52, 63",
            "18, 52, 0",
            "0, 0, 0",
            "1234, 0, 2",
    })
    void whenTwoSidesBiggerThanException(ArgumentsAccessor arguments) {
        assertThrows(IllegalArgumentException.class, () -> TriangleValidator.validate(
                arguments.getDouble(0),
                arguments.getDouble(1),
                arguments.getDouble(2))
        );
    }
}