package com.elementary.task.figure;

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

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", square=" + square +
                '}';
    }
}
