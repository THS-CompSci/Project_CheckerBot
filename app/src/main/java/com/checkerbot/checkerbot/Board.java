package com.checkerbot.checkerbot;

import android.graphics.Color;
import android.graphics.Point;
import android.widget.Toast;

import java.util.ArrayList;

public class Board {

    private Square[][] board = new Square[8][8];

    public Board() {
        this.initBoard();
    }

    private void initBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = new Square();
                Square current = board[row][col];
                current.setX(col);
                current.setY(row);
                if ((row + col) % 2 != 0) {
                    current.setColor(Color.rgb(127, 174, 255));
                    if (row < 3) {
                        current.setPiece(2);
                    }
                    if (row > 4) {
                        current.setPiece(1);
                    }

                } else {
                    current.setColor(Color.rgb(3, 45, 119));
                }
            }
        }
    }

    public Square updateSquare(Point p) {
        return board[p.y][p.x];
    }

    public Square[][] getBoard() {
        return board;
    }

    public ArrayList<Square> getValidMoves(Square play, Player p) throws InvalidMoveException {
        ArrayList<Square> valid = new ArrayList<Square>();
        //Test to see if in correct square
        if ((play.getX() + play.getY()) % 2 == 0) {
            throw new InvalidMoveException();
        }
        //test to see if player's piece
        if (play.getPiece() == p.getPiece()) {
            int forward;
            if (play.getPiece() == 1) {
                forward = -1;
            } else {
                forward = 1;
            }
            //if the player is a king
            if (play.isKing()) {
                try {
                    if (board[play.getY() - forward][play.getX() - 1].getPiece() == 0) {
                        valid.add(board[play.getY() - forward][play.getX() - 1]);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                }

                try {
                    if (board[play.getY() - forward][play.getX() + 1].getPiece() == 0) {
                        valid.add(board[play.getY() - forward][play.getX() + 1]);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                }
                //jump logic

                try {
                    if (board[play.getY() - (2*forward)][play.getX() + 2].getPiece() == 0 && board[play.getY() - forward][play.getX() + 1].getPiece() == p.getOtherPlayer().getPiece()) {
                        valid.add(board[play.getY() - (2*forward)][play.getX() + 2]);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                }
                try {
                    if (board[play.getY() - (2*forward)][play.getX() - 2].getPiece() == 0 && board[play.getY() - forward][play.getX() - 1].getPiece() == p.getOtherPlayer().getPiece()) {
                        valid.add(board[play.getY() - (2*forward)][play.getX() - 2]);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                }

            }
            try {
                if (board[play.getY() + forward][play.getX() - 1].getPiece() == 0) {
                    valid.add(board[play.getY() + forward][play.getX() - 1]);
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }

            try {
                if (board[play.getY() + forward][play.getX() + 1].getPiece() == 0) {
                    valid.add(board[play.getY() + forward][play.getX() + 1]);
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }

            //jump logic
            try {
                if (board[play.getY() + (2*forward)][play.getX() + 2].getPiece() == 0 && board[play.getY() + forward][play.getX() + 1].getPiece() == p.getOtherPlayer().getPiece()) {
                    valid.add(board[play.getY() + (2*forward)][play.getX() + 2]);
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }
            try {
                if (board[play.getY() + (2*forward)][play.getX() - 2].getPiece() == 0 && board[play.getY() + forward][play.getX() - 1].getPiece() == p.getOtherPlayer().getPiece()) {
                    valid.add(board[play.getY() + (2*forward)][play.getX() - 2]);
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }
        } else {
            throw new InvalidMoveException();
        }

        return valid;
    }

    public Square get(Point p) {
        try {
            return board[p.y][p.x];
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return board[p.y][p.x];
    }

    public boolean isJump(Square s) {
        return false;
    }

    public Square getBetween(Square s, Square f) {
        return this.get(new Point((s.getX()+f.getX())/2,(s.getY()+f.getY())/2));
    }
}
