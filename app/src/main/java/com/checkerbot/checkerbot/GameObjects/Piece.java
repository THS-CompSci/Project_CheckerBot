package com.checkerbot.checkerbot.GameObjects;

import android.graphics.Color;

public class Piece {

    private int color = 0;

    private int state = 0;

    public Piece(int color, int state) {
        this.color = color;
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
