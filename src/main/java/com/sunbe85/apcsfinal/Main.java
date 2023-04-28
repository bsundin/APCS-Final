package com.sunbe85.apcsfinal;

import com.sunbe85.apcsfinal.classes.Monopoly;
import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

import static javafx.scene.input.KeyCombination.ALT_DOWN;

/**
 * The main class. Initializes the window and creates the Monopoly object.
 */
public class Main extends Application {

    /**
     * The display width
     */
    private static final int WIDTH = 1920;
    /**
     * The display height
     */
    private static final int HEIGHT = 1080;
    /**
     * The canvas object
     */
    private static Canvas canvas;
    /**
     * The timer object
     */
    RedrawTimer timer = new RedrawTimer();

    /**
     * The game instance variable
     */
    private Monopoly game;

    /**
     * The start method, which initializes the window
     * @param stage the primary stage for this application, onto which
     *              the application scene can be set.
     *              Applications may create other stages, if needed, but they will not be
     *              primary stages.
     * @throws IOException
     * Creates a new StackPane
     * Initializes the canvas object
     * Adds the children to the StackPane
     * Creates the Scene
     * Sets the title
     * Sets the icon
     * Makes scene the active scene
     * Maximizes the window
     * Sets the exit hint
     * Sets the exit key combination
     * Creates a new Monopoly object
     * Shows the Stage
     * Initializes the timer
     */
    @Override
    public void start(Stage stage) throws IOException {
        StackPane root = new StackPane();
        canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setTitle("Monopoly: \"Own It All\"");
        stage.getIcons().add(new Image("com/sunbe85/apcsfinal/images/png/dice-white.png"));
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("Press Alt + F4 to close window at any time");
        KeyCombination k = new KeyCodeCombination(KeyCode.F4, KeyCombination.ALT_DOWN);
        stage.setFullScreenExitKeyCombination(k);
        game = new Monopoly(canvas);
        stage.show();
        timer.start();
    }

    /**
     * The execution entry point
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The Redraw timer class, ultimately handles drawing game elements
     */
    public class RedrawTimer extends AnimationTimer {
        public void handle(long now) {
            game.drawAll();
        }
    }
}