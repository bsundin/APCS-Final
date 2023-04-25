package com.sunbe85.apcsfinal.classes;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WindowController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}