package com.sunbe85.apcsfinal.classes;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

/**
 * Used to get information about the two parts of a rectangle
 */
public class BoxWithBorder extends Node {
    private Rectangle borderRect;
    private Rectangle rect;

    /**
     * @param borderRect The rectangle that acts as the border
     * @param rect The primary rectangle
     */
    public BoxWithBorder(Rectangle borderRect, Rectangle rect) {
        this.borderRect = borderRect;
        this.rect = rect;
    }

    /**
     * @return the border rectangle
     */
    public Rectangle getBorderRect() {
        return borderRect;
    }

    /**
     * @return the primary rectangle
     */
    public Rectangle getRect() {
        return rect;
    }
}
