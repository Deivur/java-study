package com.elementary.task.figure;

import static java.lang.Math.*;

public class Rectangle {

    private float width;
    private float height;
    private float square;

    public Rectangle(float width, float height) {
        this.width = width;
        this.height = height;
        this.square = width * height;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getSquare() {
        return square;
    }

    public double getDiagonal() {
        float exponent = 2;
        return sqrt(pow(width, exponent) + pow(height, exponent));
    }

    public boolean isAvailableToContain(Rectangle rectangle) {
        return isBiggerBySides(rectangle) || isContainInside(rectangle);
    }

    private boolean isContainInside(Rectangle rectangle) {
        if (rectangle.getDiagonal() > this.getDiagonal()) {
            return false;
        }
        return true;
    }

    private boolean isBiggerBySides(Rectangle rectangle) {
        return (this.getHeight() > rectangle.getHeight() && this.getWidth() > rectangle.getWidth()) ||
                this.getHeight() > rectangle.getWidth() && this.width > rectangle.getHeight();
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", square=" + square +
                '}';
    }
}
