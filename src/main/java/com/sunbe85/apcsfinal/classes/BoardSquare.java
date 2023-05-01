package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BoardSquare extends GameElement implements Renderable {

    private Color c;
    private Text t;
    private int textX, textY;
    private String name;
    private int direction;
    public BoardSquare() {
        super();
    }

    public BoardSquare(String name, int d, Color c, int x, int y) {
        super(98, 98, x, y);
        textX = x;
        textY = y;
        this.c = c;
        this.name = name;
        this.direction = d;
    }

    @Override
    public void draw(Canvas cs) {
        GraphicsContext gc = cs.getGraphicsContext2D();
        gc.setFill(c);
        gc.fillRect(getX(),getY(),getWidth(),getHeight());
        gc.setFill(Color.BLACK);
        gc.setFont(Font.font ("Verdana", 10));
        gc.fillText(name, textX, textY + 10);
    }
}
