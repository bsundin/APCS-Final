package com.sunbe85.apcsfinal.classes;

import javafx.scene.canvas.Canvas;

public class Monopoly {
    GameState g;

    Board b;
    public Monopoly(Canvas cs) {
        g = new GameState(cs);
        b = new Board();
    }

    public void drawAll() {
        g.drawAll();
    }
}
