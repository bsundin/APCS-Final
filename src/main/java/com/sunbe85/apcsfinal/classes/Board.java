package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.List;

public class Board extends GameElement implements Renderable {
    private List<BoardSquare> squares = new ArrayList<>();
    private String[] names;
    public Board() {
        names = new String[] {"Go","Mediterranean Avenue", "Community Chest", "Baltic Avenue", "Income Tax", "Reading Railroad", "Oriental Avenue", "Chance", "Vermont", "Connecticut", "Jail", "St. Charles Place", "Electric Company", "States Avenue", "Virginia Avenue", "Pennsylvania Railroad", "St. James Place", "Community Chest", "Tennessee Avenue", "New York Avenue", "Free Parking", "Kentucky Avenue", "Chance", "Indiana Avenue", "Illinois Avenue", "B. & O. Railroad", "Atlantic Avenue", "Ventnor Avenue", "Water Works", "Marvin Gardens", "Go To Jail"};
    }
    @Override
    public void draw(Canvas cs) {

    }
}
