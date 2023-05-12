package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class BoardSquare extends GameElement implements Renderable {

    private Color c;
    private Text t;
    private int x, y, textX, textY, colorX, colorY, colorHeight, colorWidth;
    private String name;
    private int direction;
    public BoardSquare() {
        super();
    }

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

    private void calcColorData(int x, int y) {
        switch (direction) {
            case 0 -> {
                this.colorHeight = 0;
                this.colorWidth = 0;
                this.colorX = x;
                this.colorY = y;
            }
            case 1 -> {
                this.colorHeight = 10;
                this.colorWidth = 98;
                this.colorX = x;
                this.colorY = y;
            }
            case 2 -> {
                this.colorHeight = 98;
                this.colorWidth = 10;
                this.colorX = x + 88;
                this.colorY = y;
            }
            case 3 -> {
                this.colorHeight = 10;
                this.colorWidth = 98;
                this.colorX = x;
                this.colorY = y + 88;
            }
            case 4 -> {
                this.colorHeight = 98;
                this.colorWidth = 10;
                this.colorX = x;
                this.colorY = y;
            }
        }
    }

    @Override
    public void draw(Canvas cs) {

    }
}