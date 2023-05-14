package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Player extends GameElement implements Renderable {
    private Piece thisPiece;

    private int balance;

    private ArrayList<Property> propertiesOwned;

    private int locOnBoard;

    private int playerNum;

    private Pane root;

    public Player(Piece p, double whichOne, int height, Pane root) {
        super(400, height, 1520, (int) (height * whichOne));
        this.balance = 1500;
        this.propertiesOwned = new ArrayList<>();
        this.locOnBoard = 0;
        this.playerNum = (int) whichOne;
        this.root = root;
        DrawUtils.drawBoxWithInnerBorder(1520, height * whichOne, 400, height, 2, 0, 0, Color.WHITE, Color.BLACK, root);
        DrawUtils.drawText("Player " + (int) ((whichOne) + 1), "Verdana", 20, (int) DrawUtils.getCenteredX("Player" + (int) (whichOne) + 1, "Verdana", 20, 400) + 1520, (int) (height * whichOne + 25), root);
    }

    public Piece getThisPiece() {
        return thisPiece;
    }

    public int getBalance() {
        return balance;
    }

    public ArrayList<Property> getPropertiesOwned() {
        return propertiesOwned;
    }

    public int getLocOnBoard() {
        return locOnBoard;
    }

    @Override
    public void draw(Canvas cs) {
        DrawUtils.drawText("Player " + (int) ((playerNum) + 1), "Verdana", 20, (int) DrawUtils.getCenteredX("Player" + (int) (playerNum) + 1, "Verdana", 20, 400) + 1520, (int) (getHeight() * playerNum + 25), root);
    }
}
