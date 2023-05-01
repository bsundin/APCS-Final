package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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

    public BoardSquare(String name, int d, Color c, int x, int y) {
        super(98, 98, x, y);
        textX = x + 50;
        textY = y + 45;
        this.c = c;
        this.name = name;
        this.direction = d;
        calcColorData(x, y);
    }

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
        GraphicsContext gc = cs.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(getX(),getY(),getWidth(),getHeight());
        gc.setFill(c);
        gc.fillRect(colorX, colorY, colorWidth, colorHeight);
        gc.setFill(Color.BLACK);
        gc.setFont(Font.font ("Verdana", 10));
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText(name, textX, textY);
    }
}
