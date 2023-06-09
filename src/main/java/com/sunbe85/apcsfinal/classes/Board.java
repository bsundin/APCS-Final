package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * The Board class, sets up the board
 */
public class Board extends GameElement implements Renderable {
    private final List<BoardSquare> squares = new ArrayList<>();
    private final String[] names = {"Go","Mediterranean\nAvenue", "Community\nChest", "Baltic\nAvenue", "Income\nTax", "Reading\nRailroad", "Oriental\nAvenue", "Chance", "Vermont", "Connecticut", "Jail", "St. Charles\nPlace", "Electric\nCompany", "States\nAvenue", "Virginia\nAvenue", "Pennsylvania\nRailroad", "St. James\nPlace", "Community\nChest", "Tennessee\nAvenue", "New York\nAvenue", "Free\nParking", "Kentucky\nAvenue", "Chance", "Indiana\nAvenue", "Illinois\nAvenue", "B. & O.\nRailroad", "Atlantic\nAvenue", "Ventnor\nAvenue", "Water\nWorks", "Marvin\nGardens", "Go To Jail", "Pacific\nAvenue", "North Carolina\nAvenue", "Community\nChest", "Pennsylvania\nAvenue", "Short Line\nRailroad", "Chance", "Park\nPlace", "Luxury\nTax", "Boardwalk"};
    /**
     * Direction of color on square:
     * 0 = no color
     * 1 = up
     * 2 = right
     * 3 = down
     * 4 = left
     */
    private final int[] direction = {0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 2, 0, 2, 2, 0, 2, 0, 2, 2, 0, 3, 0, 3, 3, 0, 3, 3, 0, 3, 0, 4, 4, 0, 4, 0, 0, 4, 0, 4};

    private final Color[] color = {Color.WHITE, Color.BROWN, Color.WHITE, Color.BROWN, Color.WHITE, Color.WHITE, Color.LIGHTBLUE, Color.WHITE, Color.LIGHTBLUE, Color.LIGHTBLUE, Color.WHITE, Color.MAGENTA, Color.WHITE, Color.MAGENTA, Color.MAGENTA, Color.WHITE, Color.ORANGE, Color.WHITE, Color.ORANGE, Color.ORANGE, Color.WHITE, Color.RED, Color.WHITE, Color.RED, Color.RED, Color.WHITE, Color.YELLOW, Color.YELLOW, Color.WHITE, Color.YELLOW, Color.WHITE, Color.GREEN, Color.GREEN, Color.WHITE, Color.GREEN, Color.WHITE, Color.WHITE, Color.BLUE, Color.WHITE, Color.BLUE};

    private final int[] col = {10,10,10,10,10,10,10,10,10,10,10,9,8,7,6,5,4,3,2,1,0,0,0,0,0,0,0,0,0,0,0,1,2,3,4,5,6,7,8,9};

    private final int[] row = {10,9,8,7,6,5,4,3,2,1,0,0,0,0,0,0,0,0,0,0,0,1,2,3,4,5,6,7,8,9,10,10,10,10,10,10,10,10,10,10};

    private final boolean[] canOwn = {false, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true};

    /**
     * Constructor for the board class, for each of 40 squares, creates a new BoardSquare object by iterating through each array above for pertinent information about that square
     * @param g A GameState object
     * @param root The Pane object
     */
    public Board(GameState g, Pane root) {
        for (int i = 0; i < 40; i++) {
            BoardSquare bS;
            if (canOwn[i] && color[i].equals(Color.WHITE)) {
                bS = new BoardSquare(names[i], direction[i], color[i], calcPos(row[i]), calcPos(col[i]), true, false, root);
            } else if (canOwn[i] && !(color[i].equals(Color.WHITE))) {
                bS = new BoardSquare(names[i], direction[i], color[i], calcPos(row[i]), calcPos(col[i]), true, true, root);
            } else {
                bS = new BoardSquare(names[i], direction[i], color[i], calcPos(row[i]), calcPos(col[i]), false, false, root);
            }
            squares.add(bS);
            g.addRenderable(bS);
        }
    }

    /**
     * Calculates the position that the box should be, can be used in both X and Y direction
     * @param n the indicated row or column
     * @return the x or y value, which is n * 98
     */
    private int calcPos(int n) {
        return n * 98;
    }

    /**
     * @param cs The canvas
     */
    @Override
    public void draw(Canvas cs) {

    }
}
