package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import com.sunbe85.apcsfinal.interfaces.Updateable;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Player extends GameElement implements Renderable {
    public Player(Piece p, double whichOne, int height, Pane root) {
        DrawUtils.drawBoxWithInnerBorder(1520, height * whichOne, 400, height, 2, 0, 0, Color.WHITE, Color.BLACK, root);
    }

    public Player() {

    }
    @Override
    public void draw(Canvas cs) {

    }
}
