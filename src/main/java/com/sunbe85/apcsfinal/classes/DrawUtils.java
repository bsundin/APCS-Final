package com.sunbe85.apcsfinal.classes;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.*;

public class DrawUtils {
    public static void drawText(String t, String family, int size, int x, int y, Pane pane) {
        Text text = new Text(t);
        text.setFont(Font.font(family, size));
        text.setX((double) x);
        text.setY((double) y);
        pane.getChildren().add(text);
    }

    public static void drawCenteredText(String drawableText, String family, int size, int y, Pane pane) {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        final int WIDTH = gd.getDisplayMode().getWidth();
        Text text = new Text(drawableText);
        text.setFont(Font.font(family, size));
        text.setY(y);
        new Scene(new Group(text));
        text.applyCss();
        double width = text.getLayoutBounds().getWidth();
        double calcX = (WIDTH - width) / 2;
        text.setX(calcX);
        pane.getChildren().add(text);
    }
}
