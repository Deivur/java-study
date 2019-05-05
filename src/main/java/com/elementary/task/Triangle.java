package com.elementary.task;

public class Triangle {

    private final String name;
    private final double sideA;
    private final double sideB;
    private final double sideC;
    private final double square;


    public Triangle(String name, double sideA, double sideB, double sideC) {
        TriangleValidator.validate(sideA, sideB, sideC);
        this.name = name;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.square = calculateSquare();
    }

    public static Triangle from(String[] params) {
        String name = params[0];
        double sideA = Double.parseDouble(params[1]);
        double sideB = Double.parseDouble(params[2]);
        double sideC = Double.parseDouble(params[3]);

        return new Triangle(name, sideA, sideB, sideC);
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
        double p = (sideA + sideB + sideC) / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public String toString() {
        return "[Triangle " + name + "]: " + square + " square centimeters";
    }
}
