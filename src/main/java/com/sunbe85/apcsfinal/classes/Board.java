package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

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

    public Board() {
        for (int i = 0; i < 40; i++) {

        }
    }
    @Override
    public void draw(Canvas cs) {

    }
}
