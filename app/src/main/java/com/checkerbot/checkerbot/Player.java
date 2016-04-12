package com.checkerbot.checkerbot;


import java.util.ArrayList;

public class Player {

    private boolean active = false;

    private Square play = new Square();

    private int Piece = -1;

    private Player otherPlayer;

    private boolean turn = false;

    private ArrayList<Square> validMoves = new ArrayList<>();

    public Player(String player) {
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

    public Square getPlay() {
        return play;
    }

    public int getPiece() {
        return Piece;
    }

    public void setPiece(int piece) {
        Piece = piece;
    }

    public void setPlay(Square play) {
        this.play = play;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public Player getOtherPlayer() {
        return otherPlayer;
    }

    public void setOtherPlayer(Player otherPlayer) {
        this.otherPlayer = otherPlayer;
    }

}
