package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.collections.*;

import javafx.scene.control.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import static java.lang.System.*;

public class GameSetup extends MenuDialog implements Renderable {
    private Pane root;
    public GameSetup(Pane root) {
        super(500, 700, 710, 190);
        this.root = root;
    }

    @Override
    public void draw(Canvas cs) {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        final int WIDTH = gd.getDisplayMode().getWidth();
        final int HEIGHT = gd.getDisplayMode().getHeight();
        GraphicsContext gc = cs.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRoundRect(getX() - 3, getY() - 3, getWidth() + 6, getHeight() + 6, 86, 86);
        gc.setFill(Color.WHITE);
        gc.fillRoundRect(getX(), getY(), getWidth(), getHeight(), 80, 80);
        try {
            InputStream stream = new FileInputStream("C:\\Users\\sunbe85\\IdeaProjects\\APCS-Final-Monopoly\\src\\main\\resources\\com\\sunbe85\\apcsfinal\\images\\png\\close.png");
            Image image = new Image(stream);
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setX(1155);
            imageView.setY(210);
            imageView.setFitWidth(35);
            imageView.setPreserveRatio(true);
            this.root.getChildren().add(imageView);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Text text = new Text("Game Setup");
        text.setFont(Font.font("Verdana", 25));
        text.setY(232);
        new Scene(new Group(text));
        text.applyCss();
        double width = text.getLayoutBounds().getWidth();
        double calcX = (WIDTH - width) / 2;
        text.setX(calcX);
        root.getChildren().add(text);
        text = new Text("Player Count");
        text.setFont(Font.font("Verdana", 20));
        text.setY(300);
        new Scene(new Group(text));
        text.applyCss();
        width = text.getLayoutBounds().getWidth();
        calcX = (WIDTH - width) / 2;
        text.setX(calcX);
        root.getChildren().add(text);
        int[] playerNums = {2, 3, 4, 5, 6, 7, 8};
        ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(playerNums));
        root.getChildren().add(combo_box);
        final int[] playerSelectionTemp = new int[1];
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                playerSelectionTemp[0] = (int) combo_box.getValue();
                out.println(combo_box.getValue());
            }
        };
        combo_box.setOnAction(event);
        int playerSelection = playerSelectionTemp[0];
        out.println(playerSelection);
    }
}
