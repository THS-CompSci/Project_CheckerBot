package com.checkerbot.checkerbot.GameObjects;

import android.graphics.Color;
import android.widget.Toast;

import java.util.ArrayList;

public class Referee implements Runnable {

    private Player p1;
    private Player p2;
    private Board board;

    private ArrayList<Square> changed = new ArrayList<Square>();
    private Square play;
    private Square selected;
    private Piece piece;


    public Referee(Board board, Player p1, Player p2) {
        this.board = board;
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public void run() {

    }

    private void getPlay(Player p) {
        changed = new ArrayList<Square>();
        play = p.getTurn(board);
        if (play != null) {
            play.setColor(Color.GREEN);
        }
        changed.add(play);


        ArrayList<Square> p1ValidMoves = board.getValidMoves(play, p);
        for (Square s : p1ValidMoves) {
            s.setColor(Color.RED);
            changed.add(s);
        }
    }

    private void getMove(Player p) {

        selected = p.getTurn(board.getValidMoves(play, p).toArray(new Square[]{}));
        selected.setColor(Color.RED);
        changed.add(selected);


    }

    private void move(Player p) {
        piece = play.getPiece();
        if (selected.getY() == p.getKing()) {
            selected.setPiece(new Piece(p.getColor(), 1));
        } else {
            selected.setPiece(new Piece(p.getColor(), piece.getState()));
        }
        play.setPiece(null);
        for (Square s : changed) {
            s.setColor(Color.rgb(127, 174, 255));
        }
        if (board.isMoveJump(play, selected)) {
            board.getBetween(play, selected).setPiece(null);
        }
    }



    public void referee() throws InterruptedException {
        while (true) {
            this.getPlay(p1);
            Thread.sleep(100);
            this.getMove(p1);
            Thread.sleep(100);
            this.move(p1);
            Thread.sleep(100);
            if (board.getPieceArray(p2).length == 0) {
                break;
            }
            this.getPlay(p2);
            Thread.sleep(100);
            this.getMove(p2);
            Thread.sleep(100);
            this.move(p2);
            Thread.sleep(100);
            if (board.getPieceArray(p1).length == 0) {
                break;
            }
        }
    }

}
