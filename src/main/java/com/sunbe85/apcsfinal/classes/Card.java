package com.sunbe85.apcsfinal.classes;

import com.sunbe85.apcsfinal.interfaces.Renderable;
import com.sunbe85.apcsfinal.interfaces.Updateable;

public abstract class Card extends GameElement implements Renderable, Updateable {
    private final String title;
    private final String content;
    public Card(String t, String c) {
        title = t;
        content = c;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
