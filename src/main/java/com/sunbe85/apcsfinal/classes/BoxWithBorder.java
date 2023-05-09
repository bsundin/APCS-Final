package com.sunbe85.apcsfinal.classes;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public class BoxWithBorder extends Node {
    private Rectangle borderRect;
    private Rectangle rect;

    public BoxWithBorder(Rectangle borderRect, Rectangle rect) {
        this.borderRect = borderRect;
        this.rect = rect;
    }

    public Rectangle getBorderRect() {
        return borderRect;
    }

    public Rectangle getRect() {
        return rect;
    }
}
