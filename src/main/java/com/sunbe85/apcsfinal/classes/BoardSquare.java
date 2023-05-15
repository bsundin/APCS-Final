package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * The BoardSquare class, sets up each board square
 */
public class BoardSquare extends GameElement implements Renderable {

    private Color c;
    private Text t;
    private int x, y, textX, textY, colorX, colorY, colorHeight, colorWidth;
    private String name;
    private int direction;
    public BoardSquare() {
        super();
    }

    /**
     * @param name The text for this particular box
     * @param d The direction of the color, see Board class for details
     * @param c The color of the box, if white, nothing is rendered
     * @param x The x position
     * @param y The y position
     * @param canOwn Indicates whether the property is able to be purchased
     * @param canBuild Indicates whether the property can be built upon
     * @param root The Pane in use
     */
    public BoardSquare(String name, int d, Color c, int x, int y, boolean canOwn, boolean canBuild, Pane root) {
        super(98, 98, x, y);
        textY = y + 45;
        this.c = c;
        this.name = name;
        this.direction = d;
        calcColorData(x, y);
        DrawUtils.drawBoxWithInnerBorder(getX(), getY(), getWidth(), getHeight(), 1, 0, 0, Color.WHITE, Color.BLACK, root);
        DrawUtils.drawBoxWithInnerBorder(colorX, colorY, colorWidth, colorHeight, 0, 0,0, c, c, root);
        DrawUtils.drawText(name, "Verdana", 10, (int) DrawUtils.getCenteredX(name, "Verdana", 10, 98) + x, (int) DrawUtils.getCenteredY(name, "Verdana", 10, 98) + y + 7, root);
    }

    /**
     * Calculates the position of the colored box
     * @param x The x position of the box
     * @param y The y position of the box
     */
    private void calcColorData(int x, int y) {
        if (direction == 0) {
            this.colorHeight = 0;
            this.colorWidth = 0;
            this.colorX = x;
            this.colorY = y;
        } else if (direction == 1) {
            this.colorHeight = 10;
            this.colorWidth = 98;
            this.colorX = x;
            this.colorY = y;
        } else if (direction == 2) {
            this.colorHeight = 98;
            this.colorWidth = 10;
            this.colorX = x + 88;
            this.colorY = y;
        } else if (direction == 3) {
            this.colorHeight = 10;
            this.colorWidth = 98;
            this.colorX = x;
            this.colorY = y + 88;
        } else if (direction == 4) {
            this.colorHeight = 98;
            this.colorWidth = 10;
            this.colorX = x;
            this.colorY = y;
        }
    }

    @Override
    public void draw(Canvas cs) {

    }
}