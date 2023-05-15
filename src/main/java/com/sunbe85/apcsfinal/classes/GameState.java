package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import com.sunbe85.apcsfinal.interfaces.Updatable;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private Canvas canvas;
    public GameState(Canvas cs) {
        canvas = cs;
    }
    private List<Renderable> rList = new ArrayList<Renderable>();
    private List<Updatable> uList = new ArrayList<Updatable>();
    private List<GameElement> gList = new ArrayList<GameElement>();

    public void drawAll() {
        for (Renderable r : rList) {
            r.draw(canvas);
        }
    }

    public void addRenderable(Renderable r) {
        rList.add(r);
    }
}
