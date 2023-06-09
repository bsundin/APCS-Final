package com.sunbe85.apcsfinal.classes;

public abstract class GameElement {
    private double width, height, x, y;

    /**
     * Default Constructor
     */
    public GameElement() {
        width = 0;
        height = 0;
        x = 0;
        y = 0;
    }

    /**
     * Constructor, sets instance variables
     * @param w The width
     * @param h The height
     * @param xPos The x position
     * @param yPos The y position
     */
    public GameElement(int w, int h, int xPos, int yPos) {
        width = w;
        height = h;
        x = xPos;
        y = yPos;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
