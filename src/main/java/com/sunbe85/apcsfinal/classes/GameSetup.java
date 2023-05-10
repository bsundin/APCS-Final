package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javafx.scene.control.*;

import java.util.ArrayList;

import static java.lang.System.out;


public class GameSetup extends MenuDialog implements Renderable {

    ImageView closeBtn;

    private final ChoiceBox<String> dropdown;

    private final ArrayList<Player> players;

    private final ArrayList<Node> visibleObjects;

    public GameSetup(Pane root, Canvas cs) {
        super(500, 700, 710, 190);
        visibleObjects = new ArrayList<>();
        visibleObjects.add(DrawUtils.drawBoxWithOuterBorder(getX(), getY(), getWidth(), getHeight(), 3, 80, 86, Color.WHITE, Color.BLACK, root));
        closeBtn = DrawUtils.addImage("src/main/resources/com/sunbe85/apcsfinal/images/png/close.png", 1155, 210, 35, true, root);
        visibleObjects.add(closeBtn);
        visibleObjects.add(DrawUtils.drawCenteredText("Game Setup", "Verdana", 25, 232, root));
        visibleObjects.add(DrawUtils.drawCenteredText("Player Count", "Verdana", 20, 300, root));
        this.dropdown = DrawUtils.dropdownCenter(new String[]{"2", "3", "4", "5", "6", "7", "8"}, 350, root);
        visibleObjects.add(dropdown);
        dropdown.setOnAction(e -> getDropdownChoice(dropdown));
        players = new ArrayList<>();
        closeBtn.setOnMouseClicked(e -> remove(visibleObjects, root));
        closeBtn.setCursor(Cursor.HAND);
    }

    private void remove(ArrayList<Node> objects, Pane root) {
        DrawUtils.remove(objects, root);
    }

    private void getDropdownChoice(ChoiceBox<String> dropdown) {
        int playerChoice = Integer.parseInt(dropdown.getValue());
        out.println(playerChoice);
        for (int i = 0; i < playerChoice; i++) {
            players.add(new Player());
        }
    }

    @Override
    public void draw(Canvas cs) {

    }
}
