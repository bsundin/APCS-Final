package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import com.sunbe85.apcsfinal.interfaces.Updateable;
import javafx.scene.canvas.Canvas;

import java.io.File;

public class Piece extends GameElement implements Renderable, Updateable {

    private final String[] pieceNames = new String[] {"Dog", "Car", "Battleship", "Hat", "Thimble", "Cat", "Wheelbarrow", "Boot"};

    private final String[] fileLocs = new String[] {"", "", "", "", "", "", "", "", ""};

    private String name;

    private File imageFile;

    public Piece(int pieceNum) {
        this.name = pieceNames[pieceNum];
        this.imageFile = new File(fileLocs[pieceNum]);
    }

    @Override
    public void draw(Canvas cs) {

    }

    @Override
    public void update() {

    }
}
