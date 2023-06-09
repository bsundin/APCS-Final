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


/**
 * Establishes the initial game setup dialog box
 */
public class GameSetup extends MenuDialog implements Renderable {

    ImageView closeBtn;

    private final ChoiceBox<String> dropdown;

    private final ArrayList<Player> players;

    private final ArrayList<Node> visibleObjects;

    private final ArrayList<Piece> piecesInUse;

    private final Pane root;

    /**
     * The constructor for the game setup, renders everything
     * @param root The Pane
     * @param piecesInUse Not yet implemented, will be an ArrayList for containing all the pieces currently in use
     * @param cs The canvas, unused
     */
    public GameSetup(Pane root, ArrayList<Piece> piecesInUse, Canvas cs) {
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
        for (int i = 1; i <= 2; i++) {
            players.add(new Player(new Piece(i - 1), i - 1, 1080 / 2, root));
        }
        closeBtn.setOnMouseClicked(e -> remove(visibleObjects, root));
        closeBtn.setCursor(Cursor.HAND);
        this.piecesInUse = piecesInUse;
        this.root = root;
    }

    /**
     * @param objects The objects to remove
     * @param root The Pane to remove those objects from
     */
    private void remove(ArrayList<Node> objects, Pane root) {
        DrawUtils.remove(objects, root);
    }

    /**
     * Gets the choice made in the dropdown and updates the player boxes accordingly
     * @param dropdown The ChoiceBox
     */
    private void getDropdownChoice(ChoiceBox<String> dropdown) {
        int playerChoice = Integer.parseInt(dropdown.getValue());
        int i = 1;
        while (i <= playerChoice) {
            players.add(new Player(new Piece(i - 1), i - 1, 1080 / playerChoice, root));
            i++;
        }
    }

    @Override
    public void draw(Canvas cs) {

    }
}
