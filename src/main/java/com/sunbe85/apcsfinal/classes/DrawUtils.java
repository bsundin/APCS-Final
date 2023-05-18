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


/**
 * A class with several utilities for rendering objects in the Pane more easily
 */
public class DrawUtils {
    /**
     * Draws text on the screen
     * @param t The drawable text
     * @param family The font family
     * @param size The font size
     * @param x The x position
     * @param y The y position
     * @param pane The Pane to add objects to
     */
    public static void drawText(String t, String family, int size, int x, int y, Pane pane) {
        Text text = new Text(t);
        text.setFont(Font.font(family, size));
        text.setX(x);
        text.setY(y);
        text.setTextAlignment(TextAlignment.CENTER);
        pane.getChildren().add(text);
    }

    /**
     * Draws text on the screen, centered on the x axis
     * @param drawableText The drawable text
     * @param family The font family
     * @param size The font size
     * @param y The y position
     * @param pane The Pane to add objects to
     * @return The text object that is created
     */
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

    /**
     * Renders an image on the screen
     * @param fileAddress The address of the image file, from the source root
     * @param x The x position of the image
     * @param y The y position of the image
     * @param fitWidth The width of the image
     * @param preserveRation Indicates whether the aspect ratio of the image should be preserved
     * @param root The Pane to add objects to
     * @return The ImageView that is created
     */
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

    /**
     * Renders a box on the screen with the border on the outside
     * @param x The x position of the inner box
     * @param y The y position of the inner box
     * @param width The width of the inner box
     * @param height The height of the inner box
     * @param borderWidth The width of the border, used in calculations for the x, y, width, and height of the border rect
     * @param arcDimension The radius of the rounded corners of the inner rect
     * @param borderArcDimension The radius of the rounded corners of the border rect, not calculated automatically because values seem inconsistent
     * @param boxColor The background color of the inner box
     * @param borderColor The color of the border
     * @param root The Pane to add objects to
     * @return The box with border that is created
     */
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

    /**
     * Renders a box on the screen with the border inside the parameters specified
     * @param x The x value of the border box
     * @param y The y value of the border box
     * @param width The width of the border box
     * @param height The height of the border box
     * @param borderWidth The Width of the border, used to calculate the x, y, width, and height of the inner box
     * @param arcDimension The radius of the rounded corners of the inner box
     * @param borderArcDimension The radius of the rounded corners of the border
     * @param boxColor The color of the box
     * @param borderColor The color of the border
     * @param root The Pane to add objects to
     * @return the box with border that is created
     */
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

    /**
     * Creates a new dropdown menu
     * @param options The options of the dropdown menu
     * @param y The y position of the box (x currently automatically centered)
     * @param root The Pane to add objects to
     * @return The ChoiceBox
     */
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

    /**
     * Clears the screen
     * @param root The Pane to clear
     */
    public static void clearScreen(Pane root) {
        root.getChildren().clear();
    }

    /**
     * Removes a certain object from the screen
     * @param nodes All parts of the object, everything that should be removed
     * @param root The Pane to remove objects from
     * @return The nodes that are removed
     */
    public static ArrayList<Node> remove(ArrayList<Node> nodes, Pane root) {
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

    /**
     * Returns the x value of text, so that it is horizontally centered in a container of specified width
     * @param drawableText The string that is being rendered
     * @param family The font family
     * @param size The font size
     * @param containerWidth The width of the container
     * @return The centered x value
     */
    public static double getCenteredX(String drawableText, String family, int size, int containerWidth) {
        Text text = new Text(drawableText);
        text.setFont(Font.font(family, size));
        new Scene(new Group(text));
        text.applyCss();
        double width = text.getLayoutBounds().getWidth();
        return (containerWidth - width) / 2;
    }

    /**
     * Returns the y value of text, so that it is horizontally centered in a container of specified height
     * @param drawableText The string that is being rendered
     * @param family The font family
     * @param size The font size
     * @param containerHeight The width of the container
     * @return The centered y value
     */
    public static double getCenteredY(String drawableText, String family, int size, int containerHeight) {
        Text text = new Text(drawableText);
        text.setFont(Font.font(family, size));
        new Scene(new Group(text));
        text.applyCss();
        double height = text.getLayoutBounds().getHeight();
        return (containerHeight - height) / 2;
    }
}