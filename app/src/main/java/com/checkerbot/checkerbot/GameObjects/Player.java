package com.checkerbot.checkerbot.GameObjects;


import android.graphics.Color;

import com.checkerbot.checkerbot.BoardView;

import java.util.ArrayList;

public abstract class Player {

    private Player otherPlayer;
    private int color;
    private Board board;


    public Player(Player otherPlayer, int color, Board board) {
        this.otherPlayer = otherPlayer;
        this.color = color;
    }

    public abstract Square getPlay();

    public abstract Square getMove();

    public Player getOtherPlayer() {
        return otherPlayer;
    }



}
