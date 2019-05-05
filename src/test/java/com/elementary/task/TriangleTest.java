package com.elementary.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @ParameterizedTest
    @CsvSource({
            "triangle1, 8, 5, 6",
            "triangle2, 41, 52, 63",
    })
    void whenEverySideLessThanOtherTriangleCanBeCreated(ArgumentsAccessor arguments) {
        Triangle triangle = new Triangle(arguments.getString(0), arguments.getDouble(1),
                arguments.getDouble(2), arguments.getDouble(3));

        assertNotNull(triangle);
    }

    @ParameterizedTest
    @CsvSource({
            "triangle1, 8, 5, 15",
            "triangle2, 180, 52, 63",
            "triangle3, 18, 52, 0",
            "triangle4, 0, 0, 0",
    })
    void whenTwoSidesBiggerThanException(ArgumentsAccessor arguments) {

        assertThrows(IllegalArgumentException.class, () -> new Triangle(
                arguments.getString(0), arguments.getDouble(1),
                arguments.getDouble(2), arguments.getDouble(3))
        );
    }

    @Test
    void toStringOverride() {
        Triangle triangle = new Triangle("triangle1", 3, 4, 5);
        String expected = "[Triangle " + triangle.getName() + "]: " + triangle.getSquare() + " square centimeters";

        assertEquals(expected, triangle.toString());
    }
}