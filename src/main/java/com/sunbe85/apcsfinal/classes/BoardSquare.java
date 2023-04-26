package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BoardSquare extends GameElement implements Renderable {
    public BoardSquare() {
        super();
    }

    @Override
    public void draw(Canvas cs) {
        GraphicsContext gc = cs.getGraphicsContext2D();
        gc.setFill(Color.RED);
        gc.fillRect(0,0,100,100);
    }
}
