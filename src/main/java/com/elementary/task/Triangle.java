package com.elementary.task;

public class Triangle {

    private final String name;
    private final double sideA;
    private final double sideB;
    private final double sideC;
    private final double square;

    public Triangle(String name, double sideA, double sideB, double sideC) {
        if (exist(sideA, sideB, sideC)) {
            this.name = name;
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
            this.square = calculateSquare();
        } else {
            String errorMessage = "Triangle with sides: " + sideA + ", " + sideB + ", " + sideC + " cant exist";
            throw new IllegalArgumentException(errorMessage);
        }

    }

    public String getName() {
        return name;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public double getSquare() {
        return square;
    }

    private double calculateSquare() {
        // p - semi-perimeter
        double p = (this.sideA + this.sideB + this.sideC) / 2;
        return Math.sqrt(p * (p - this.sideA) * (p - this.sideB) * (p - this.sideC));
    }

    private boolean exist(double sideA, double sideB, double sideC) {
        return sideA < sideB + sideC && sideB < sideA + sideC && sideC < sideA + sideB;
    }

    @Override
    public String toString() {
        return "[Triangle " + name + "]: " + square + " square centimeters";
    }
}
