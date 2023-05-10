package com.sunbe85.apcsfinal.classes;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.text.TextAlignment;

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
        text.setTextAlignment(TextAlignment.CENTER);
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
        text.setCursor(Cursor.TEXT);
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

    public static BoxWithBorder drawBoxWithOuterBorder(double x, double y, double width, double height, double borderWidth, int arcDimension, int borderArcDimension, Color boxColor, Color borderColor, Pane root) {
        Rectangle r1 = new Rectangle();
        r1.setFill(borderColor);
        r1.setX(x - borderWidth);
        r1.setY(y - borderWidth);
        r1.setWidth(width + (borderWidth * 2));
        r1.setHeight(height + (borderWidth * 2));
        r1.setArcHeight(borderArcDimension);
        r1.setArcWidth(borderArcDimension);
        root.getChildren().add(r1);
        Rectangle r2 = new Rectangle();
        r2.setFill(boxColor);
        r2.setX(x);
        r2.setY(y);
        r2.setWidth(width);
        r2.setHeight(height);
        r2.setArcHeight(arcDimension);
        r2.setArcWidth(arcDimension);
        root.getChildren().add(r2);
        return new BoxWithBorder(r1, r2);
    }

    public static BoxWithBorder drawBoxWithInnerBorder(double x, double y, double width, double height, double borderWidth, int arcDimension, int borderArcDimension, Color boxColor, Color borderColor, Pane root) {
        Rectangle r1 = new Rectangle();
        r1.setFill(borderColor);
        r1.setX(x);
        r1.setY(y);
        r1.setWidth(width);
        r1.setHeight(height);
        r1.setArcHeight(borderArcDimension);
        r1.setArcWidth(borderArcDimension);
        root.getChildren().add(r1);
        Rectangle r2 = new Rectangle();
        r2.setFill(boxColor);
        r2.setX(x + borderWidth);
        r2.setY(y + borderWidth);
        r2.setWidth(width - (borderWidth * 2));
        r2.setHeight(height - (borderWidth * 2));
        r2.setArcHeight(arcDimension);
        r2.setArcWidth(arcDimension);
        root.getChildren().add(r2);
        return new BoxWithBorder(r1, r2);
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
            if (n instanceof BoxWithBorder) {
                ((BoxWithBorder) n).getRect().toBack();
                ((BoxWithBorder) n).getBorderRect().toBack();
                root.getChildren().remove(((BoxWithBorder) n).getRect());
                root.getChildren().remove(((BoxWithBorder) n).getBorderRect());
            }
            n.toBack();
            root.getChildren().remove(n);
        }
        return nodes;
    }

    public static double getCenteredX(String drawableText, String family, int size, int containerWidth) {
        Text text = new Text(drawableText);
        text.setFont(Font.font(family, size));
        new Scene(new Group(text));
        text.applyCss();
        double width = text.getLayoutBounds().getWidth();
        return (containerWidth - width) / 2;
    }

    public static double getCenteredY(String drawableText, String family, int size, int containerHeight) {
        Text text = new Text(drawableText);
        text.setFont(Font.font(family, size));
        new Scene(new Group(text));
        text.applyCss();
        double height = text.getLayoutBounds().getHeight();
        return (containerHeight - height) / 2;
    }
}
