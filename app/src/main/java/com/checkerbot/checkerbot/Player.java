package com.checkerbot.checkerbot;


public class Player {

    private boolean active;

    private Square play;

    private int Piece;

    private boolean turn = false;

    private Square[][] validMoves;

    public Player(String player){


    }

    public Square[][] getValidMoves() {
        return validMoves;
    }

    public void setValidMoves(Square[][] validMoves) {
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


}
