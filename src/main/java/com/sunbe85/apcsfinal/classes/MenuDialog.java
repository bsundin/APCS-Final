package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MenuDialog extends GameElement implements Renderable {

    public MenuDialog(int width, int height, int x, int y, String type) {
        super(width, height, x, y);
    }

    @Override
    public void draw(Canvas cs) {
        GraphicsContext gc = cs.getGraphicsContext2D();
        gc.setFill(Color.GREEN);
        gc.fillRect(getX(),getY(),getWidth(),getHeight());
    }
}
