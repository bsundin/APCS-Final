package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BoardSquare extends GameElement implements Renderable {

    private Color c;
    public BoardSquare() {
        super();
    }

    public BoardSquare(String name, int d, Color c, int x, int y) {
        super(98, 98, x, y);
        this.c = c;
    }

    @Override
    public void draw(Canvas cs) {
        GraphicsContext gc = cs.getGraphicsContext2D();
        gc.setFill(c);
        gc.fillRect(getX(),getY(),getWidth(),getHeight());
    }
}
