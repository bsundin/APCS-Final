package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javafx.scene.control.*;


public class GameSetup extends MenuDialog implements Renderable {
    private Pane root;

    public GameSetup(Pane root, Canvas cs) {
        super(500, 700, 710, 190);
        this.root = root;
        DrawUtils.drawBoxWithBorder(cs, getX(), getY(), getWidth(), getHeight(), 80, 86, Color.WHITE, Color.BLACK);
        DrawUtils.addImage("src/main/resources/com/sunbe85/apcsfinal/images/png/close.png", 1155, 210, 35, true, root);
        DrawUtils.drawCenteredText("Game Setup", "Verdana", 25, 232, root);
        DrawUtils.drawCenteredText("Player Count", "Verdana", 20, 300, root);
        ChoiceBox<String> dropdown = new ChoiceBox<>();
        for (int i = 2; i <= 8; i++) {
            dropdown.getItems().add(i + "");
        }
        dropdown.setValue("2");
        root.getChildren().add(dropdown);
    }

    @Override
    public void draw(Canvas cs) {

    }

}
