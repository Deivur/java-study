package com.elementary.task;

import java.util.List;

public class Triangle {

    public static final int REQUIRED_ATTRIBUTE_NUMBER = 4;

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

    public static Triangle from(String[] params) {
        if (params.length < REQUIRED_ATTRIBUTE_NUMBER) {
            for (String param : params) {
                System.out.println("'" + param + "'");
            }
            String errorMessage = "Required " + REQUIRED_ATTRIBUTE_NUMBER + " attributes, passed " + params.length;
            throw new IllegalArgumentException(errorMessage);
        } else {
            String name = params[0];
            double sideA = Double.parseDouble(params[1]);
            double sideB = Double.parseDouble(params[2]);
            double sideC = Double.parseDouble(params[3]);

            return new Triangle(name, sideA, sideB, sideC);
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
