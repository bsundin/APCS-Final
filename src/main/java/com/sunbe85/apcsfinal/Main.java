package com.sunbe85.apcsfinal;

import com.sunbe85.apcsfinal.classes.Monopoly;
import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    private static final int WIDTH = 1920;
    private static final int HEIGHT = 1080;
    private static Canvas canvas;
    RedrawTimer timer = new RedrawTimer();
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
        stage.show();
        timer.start();
    }

    public static void main(String[] args) {
        launch(args);
        Monopoly game = new Monopoly();
    }

    public class RedrawTimer extends AnimationTimer {
        public void handle(long now) {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.setFill(Color.RED);
            gc.fillRect(0,0,100,100);
        }
    }
}