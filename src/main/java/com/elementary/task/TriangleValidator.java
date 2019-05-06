package com.elementary.task;

public final class TriangleValidator {

    private TriangleValidator() {}

    public static boolean exist(double sideA, double sideB, double sideC) {
        if (sideA == 0 || sideB == 0 || sideC == 0) {
            return false;
        } else {
            return (sideA < sideB + sideC) && (sideB < sideA + sideC) && (sideC < sideA + sideB);
        }
    }

    public static void validate(double sideA, double sideB, double sideC) {
        if (!TriangleValidator.exist(sideA, sideB, sideC)) {
            String errorMessage = "Triangle with sides: " + sideA + ", " + sideB + ", " + sideC + " cant exist";
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
