package com.sunbe85.apcsfinal;

import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 450;
    private static Canvas canvas;
    RedrawTimer timer = new RedrawTimer();
    @Override
    @SuppressWarnings("deprecation")
    public void start(Stage stage) throws IOException {
        StackPane root = new StackPane();
        canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setTitle("Monopoly: \"Own It All\"");
        stage.getIcons().add(new Image("com/sunbe85/apcsfinal/images/png/dice-white.png"));
        stage.setScene(scene);
        stage.show();
        timer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public class RedrawTimer extends AnimationTimer {

        public void handle(long now) {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            //update, draw and collide all of the Game Elements in the GameState object
        }
    }
}