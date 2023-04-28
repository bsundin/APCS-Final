package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board extends GameElement implements Renderable {
    private List<BoardSquare> squares = new ArrayList<>();
    private final String[] names = {"Go","Mediterranean Avenue", "Community Chest", "Baltic Avenue", "Income Tax", "Reading Railroad", "Oriental Avenue", "Chance", "Vermont", "Connecticut", "Jail", "St. Charles Place", "Electric Company", "States Avenue", "Virginia Avenue", "Pennsylvania Railroad", "St. James Place", "Community Chest", "Tennessee Avenue", "New York Avenue", "Free Parking", "Kentucky Avenue", "Chance", "Indiana Avenue", "Illinois Avenue", "B. & O. Railroad", "Atlantic Avenue", "Ventnor Avenue", "Water Works", "Marvin Gardens", "Go To Jail", "Pacific Avenue", "North Carolina Avenue", "Community Chest", "Pennsylvania Avenue", "Short Line Railroad", "Chance", "Park Place", "Luxury Tax", "Boardwalk"};
    /**
     * Direction of color on square:
     * 0 = no color
     * 1 = up
     * 2 = right
     * 3 = down
     * 4 = left
     */
    private final int[] direction = {0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 2, 0, 2, 2, 0, 2, 0, 2, 2, 0, 3, 0, 3, 3, 0, 3, 3, 0, 3, 0, 4, 4, 0, 4, 0, 0, 4, 0, 4};

    private final Color[] color = {null, Color.BROWN, null, Color.BROWN, null, null, Color.LIGHTBLUE, null, Color.LIGHTBLUE, Color.LIGHTBLUE, null, Color.MAGENTA, null, Color.MAGENTA, Color.MAGENTA, null, Color.ORANGE, null, Color.ORANGE, Color.ORANGE, null, Color.RED, null, Color.RED, Color.RED, null, Color.YELLOW, Color.YELLOW, null, Color.YELLOW, null, Color.GREEN, Color.GREEN, null, Color.GREEN, null, null, Color.BLUE, null, Color.BLUE};

    private final int[] row = {10,10,10,10,10,10,10,10,10,10,10,9,8,7,6,5,4,3,2,1,0,0,0,0,0,0,0,0,0,0,0,1,2,3,4,5,6,7,8,9};

    private final int[] col = {10,9,8,7,6,5,4,3,2,1,0,0,0,0,0,0,0,0,0,0,0,1,2,3,4,5,6,7,8,9,10,10,10,10,10,10,10,10,10,10};

    public Board(GameState g) {
        for (int i = 0; i < 40; i++) {
            BoardSquare bS = new BoardSquare(names[i], direction[i], color[i], calcPos(row[i]), calcPos(col[i]));
            squares.add(bS);
            g.addRenderable(bS);
        }
    }

    /**
     * @param n the indicated row or column
     * @return the x or y value, which is n * 98
     */
    private int calcPos(int n) {
        return n * 98;
    }
    @Override
    public void draw(Canvas cs) {

    }
}
