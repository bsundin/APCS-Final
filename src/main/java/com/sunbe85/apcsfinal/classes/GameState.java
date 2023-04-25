package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import com.sunbe85.apcsfinal.interfaces.Updateable;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private List<Renderable> rList = new ArrayList<Renderable>();
    private List<Updateable> uList = new ArrayList<Updateable>();
    private List<GameElement> gList = new ArrayList<GameElement>();
}
