package com.sunbe85.apcsfinal.classes;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;

import static java.lang.System.out;


public class DrawUtils {
    public static void drawText(String t, String family, int size, int x, int y, Pane pane) {
        Text text = new Text(t);
        text.setFont(Font.font(family, size));
        text.setX(x);
        text.setY(y);
        pane.getChildren().add(text);
    }

    public static Text drawCenteredText(String drawableText, String family, int size, int y, Pane pane) {
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
        return text;
    }

    public static ImageView addImage(String fileAddress, int x, int y, int fitWidth, boolean preserveRation, Pane root) {
        ImageView imageView;
        try {
            InputStream stream = new FileInputStream(fileAddress);
            Image image = new Image(stream);
            imageView = new ImageView();
            imageView.setImage(image);
            imageView.setX(x);
            imageView.setY(y);
            imageView.setFitWidth(fitWidth);
            imageView.setPreserveRatio(preserveRation);
            root.getChildren().add(imageView);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return imageView;
    }

    public static GraphicsContext drawBoxWithBorder(Canvas cs, double x, double y, double width, double height, int arcDimension, int borderArcDimension, Color boxColor, Color borderColor) {
        GraphicsContext gc = cs.getGraphicsContext2D();
        gc.setFill(borderColor);
        gc.fillRoundRect(x - 3, y - 3, width + 6, height + 6, borderArcDimension, borderArcDimension);
        gc.setFill(boxColor);
        gc.fillRoundRect(x, y, width, height, arcDimension, arcDimension);
        return gc;
    }

    public static ChoiceBox<String> dropdownCenter(String[] options, int y, Pane root) {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        final int WIDTH = gd.getDisplayMode().getWidth();
        ChoiceBox<String> dropdown = new ChoiceBox<>();
        dropdown.getItems().addAll(options);
        dropdown.setValue(options[0]);
        dropdown.setLayoutY(y);
        new Scene(new Group(dropdown));
        dropdown.applyCss();
        double width = dropdown.getLayoutBounds().getWidth();
        double calcX = (WIDTH - width) / 2;
        dropdown.setLayoutX(calcX);
        root.getChildren().add(dropdown);
        return dropdown;
    }

    public static void clearScreen(Pane root) {
        root.getChildren().clear();
    }

    public static ArrayList remove(ArrayList<Node> nodes, Pane root) {
        for (Node n : nodes) {
            n.toBack();
            root.getChildren().remove(n);
        }
        out.println("still working");
        return nodes;
    }
}
