package com.sunbe85.apcsfinal.classes;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

/**
 * The Monopoly class. Runs the game.
 */
public class Monopoly {
    /**
     * The GameState object
     */
    private final GameState g;

    /**
     * The Board object
     */
    private final Board b;

    /**
     * The initial setup menu
     */
    private final GameSetup initial;

    public ArrayList<Piece> piecesInUse;

    /**
     * The constructor for the monopoly class, sets instance variables g, the GameState object, b, the Board, which is passed the GameState, initial, which is the game setup dialog
     * @param cs The Canvas, passed in via Main
     */
    public Monopoly(Canvas cs, Pane root) {
        g = new GameState(cs);
        b = new Board(g, root);
        initial = new GameSetup(root, piecesInUse, cs);
        g.addRenderable(initial);
    }

    /**
     * Simply acts as a relay between the main timer method and the drawAll method in the GameState class
     */
    public void drawAll() {
        g.drawAll();
    }
}
