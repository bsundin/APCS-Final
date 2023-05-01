package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameSetup extends MenuDialog implements Renderable {

    public GameSetup() {
        super(500, 700, 710, 190);
    }

    @Override
    public void draw(Canvas cs) {
        GraphicsContext gc = cs.getGraphicsContext2D();
        gc.setFill(Color.GREEN);
//        gc.fillRect(getX(),getY(),getWidth(),getHeight());
        gc.fillRoundRect(getX(), getY(), getWidth(), getHeight(), 80, 80);
    }
}
