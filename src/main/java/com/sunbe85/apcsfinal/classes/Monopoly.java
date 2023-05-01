package com.sunbe85.apcsfinal.classes;

import javafx.scene.canvas.Canvas;

/**
 * The Monopoly Class. Runs the game.
 */
public class Monopoly {
    /**
     * The GameState object
     */
    GameState g;

    /**
     * The Board object
     */
    Board b;

    /**
     * The initial setup menu
     */
    MenuDialog initial;

    /**
     * The constructor for the monopoly class, sets instance variables g, the GameState object, and b, the Board, which is passed the GameState
     * @param cs The Canvas, passed in via Main
     */
    public Monopoly(Canvas cs) {
        g = new GameState(cs);
        b = new Board(g);
        initial = new MenuDialog(500, 700, 710, 190, "SETUP");
        g.addRenderable(initial);
    }

    /**
     * Simply acts as a relay between the main timer method and the drawAll method in the GameState class
     */
    public void drawAll() {
        g.drawAll();
    }
}
