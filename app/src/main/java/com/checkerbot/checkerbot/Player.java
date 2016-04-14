package com.checkerbot.checkerbot;


import android.graphics.Color;

import java.util.ArrayList;

public class Player {

    public boolean multi = false;

    private boolean active = false;

    private Square play = new Square();

    private int color = Color.WHITE;

    private Player otherPlayer;

    private boolean turn = false;

    private boolean lastJump = false;

    private ArrayList<Square> validMoves = new ArrayList<>();

    public Player(String player) {
    }

    public boolean isLastJump() {
        return lastJump;
    }

    public void setLastJump(boolean lastJump) {
        this.lastJump = lastJump;
    }

    public boolean isMulti() {
        return multi;
    }

    public void setMulti(boolean multi) {
        this.multi = multi;
    }

    public ArrayList<Square> getValidMoves() {
        return validMoves;
    }

    public void setValidMoves(ArrayList<Square> validMoves) {
        this.validMoves = validMoves;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public Square getPlay() {
        return play;
    }

    public void setPlay(Square play) {
        this.play = play;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Player getOtherPlayer() {
        return otherPlayer;
    }

    public void setOtherPlayer(Player otherPlayer) {
        this.otherPlayer = otherPlayer;
    }

}
