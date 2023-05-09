package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javafx.scene.control.*;

import java.util.ArrayList;

import static java.lang.System.out;


public class GameSetup extends MenuDialog implements Renderable {
    private Pane root;

    private int playerChoice;

    private ChoiceBox<String> dropdown;

    private ArrayList<Player> players;

    public GameSetup(Pane root, Canvas cs) {
        super(500, 700, 710, 190);
        this.root = root;
        DrawUtils.drawBoxWithBorder(cs, getX(), getY(), getWidth(), getHeight(), 80, 86, Color.WHITE, Color.BLACK);
        DrawUtils.addImage("src/main/resources/com/sunbe85/apcsfinal/images/png/close.png", 1155, 210, 35, true, root);
        DrawUtils.drawCenteredText("Game Setup", "Verdana", 25, 232, root);
        DrawUtils.drawCenteredText("Player Count", "Verdana", 20, 300, root);
        this.dropdown = DrawUtils.dropdownCenter(new String[]{"2", "3", "4", "5", "6", "7", "8"}, 350, root);
        dropdown.setOnAction(e -> getDropdownChoice(dropdown));
        players = new ArrayList<>();
    }

    private void getDropdownChoice(ChoiceBox<String> dropdown) {
        playerChoice = Integer.parseInt(dropdown.getValue());
        out.println(playerChoice);
        for (int i = 0; i < playerChoice; i++) {
            players.add(new Player());
        }
    }

    @Override
    public void draw(Canvas cs) {

    }
}
