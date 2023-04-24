package com.sunbe85.apcsfinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class WindowOpener extends Application {
    @Override
    @SuppressWarnings("deprecation")
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src\\main\\resources\\com\\sunbe85\\apcsfinal\\hello-view.fxml").toURL());
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Monopoly: \"Own It All\"");
        stage.getIcons().add(new Image("com/sunbe85/apcsfinal/png/dice-white.png"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}