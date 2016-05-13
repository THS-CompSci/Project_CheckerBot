package com.checkerbot.checkerbot.GameObjects;

import android.graphics.Color;
import android.graphics.Point;

import com.checkerbot.checkerbot.Exceptions.InvalidMoveException;

import java.util.ArrayList;

public class Board {

    private Square[][] board = new Square[8][8];

    int forward;

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
                        current.setPiece(new Piece(Color.BLACK, 0));
                    }
                    if (row > 4) {
                        current.setPiece(new Piece(Color.WHITE, 0));
                    }

                } else {
                    current.setColor(Color.rgb(3, 45, 119));
                }
            }
        }
    }

    public Square[][] getBoard() {
        return board;
    }

    public ArrayList<Square> getValidMoves(Square play, Player p) throws InvalidMoveException {
        ArrayList<Square> valid = new ArrayList<Square>();
        valid.addAll(this.mainLogic(play, p));
        return valid;
    }

    public ArrayList<Square> mainLogic(Square play, Player p) throws InvalidMoveException {
        ArrayList<Square> valid = new ArrayList<Square>();
        //Main Logic
        if ((play.getX() + play.getY()) % 2 == 0) {
            throw new InvalidMoveException();
        }
        //test to see if player's piece
        if (play.getPiece() != null) {
            if (play.getPiece().getColor() == p.getColor()) {
                //get the direction a player should go
                if (play.getPiece().getColor() == Color.WHITE) {
                    forward = -1;
                } else {
                    forward = 1;
                }
                //add valid moves if piece is a king
                if (play.isKing()) {
                    valid.addAll(this.kingLogic(play, p));
                }
                valid.addAll(this.logic(play, p));
            } else {
                throw new InvalidMoveException();
            }
        } else {
            throw new InvalidMoveException();
        }
        return valid;
    }

    public ArrayList<Square> logic(Square play, Player p) {
        ArrayList<Square> valid = new ArrayList<>();

        try {
            if (board[play.getY() + forward][play.getX() - 1].getPiece() == null) {
                valid.add(board[play.getY() + forward][play.getX() - 1]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

        try {
            if (board[play.getY() + forward][play.getX() + 1].getPiece() == null)
                valid.add(board[play.getY() + forward][play.getX() + 1]);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        //jump logic
        valid.addAll(this.jumpLogic(play, p));
        return valid;
    }

    public ArrayList<Square> kingLogic(Square play, Player p) {
        ArrayList<Square> valid = new ArrayList<>();
        try {
            if (board[play.getY() - forward][play.getX() - 1].getPiece() == null) {
                valid.add(board[play.getY() - forward][play.getX() - 1]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

        try {
            try {
                if (board[play.getY() - forward][play.getX() + 1].getPiece() == null) {
                    valid.add(board[play.getY() - forward][play.getX() + 1]);
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }
        } catch (NullPointerException f) {

        }
        //jump logic
        valid.addAll(this.kingJumpLogic(play, p));
        return valid;
    }

    public ArrayList<Square> jumpLogic(Square play, Player p) {
        ArrayList<Square> valid = new ArrayList<Square>();
        try {
            if (board[play.getY() + (2 * forward)][play.getX() + 2].getPiece() == null) {
                if (board[play.getY() + forward][play.getX() + 1].getPiece() != null) {
                    if (board[play.getY() + forward][play.getX() + 1].getPiece().getColor() == p.getOtherPlayer().getColor()) {
                        valid.add(board[play.getY() + (2 * forward)][play.getX() + 2]);
                        p.setLastJump(true);
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

        try {
            if (board[play.getY() + (2 * forward)][play.getX() - 2].getPiece() == null) {
                if (board[play.getY() + forward][play.getX() - 1].getPiece() != null) {
                    if (board[play.getY() + forward][play.getX() - 1].getPiece().getColor() == p.getOtherPlayer().getColor()) {
                        valid.add(board[play.getY() + (2 * forward)][play.getX() - 2]);
                        p.setLastJump(true);
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return valid;
    }

    public ArrayList<Square> kingJumpLogic(Square play, Player p) {
        ArrayList<Square> valid = new ArrayList<Square>();
        System.out.println("here");
        try {
            if (board[play.getY() - (2 * forward)][play.getX() + 2].getPiece() == null) {
                if (board[play.getY() - forward][play.getX() + 1].getPiece() != null) {
                    if (board[play.getY() - forward][play.getX() + 1].getPiece().getColor() == p.getOtherPlayer().getColor()) {
                        valid.add(board[play.getY() - (2 * forward)][play.getX() + 2]);
                        System.out.println("valid");
//                        p.setLastJump(true);
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            if (board[play.getY() - (2 * forward)][play.getX() - 2].getPiece() == null) {
                if (board[play.getY() - forward][play.getX() - 1].getPiece() != null) {
                    if (board[play.getY() - forward][play.getX() - 1].getPiece().getColor() == p.getOtherPlayer().getColor()) {
                        valid.add(board[play.getY() - (2 * forward)][play.getX() - 2]);
//                        p.setLastJump(true);
                    }
                }

            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return valid;
    }

    public Square get(Point p) {
        try {
            return board[p.y][p.x];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public boolean isJump(Square s, Player p) {
        if (this.jumpLogic(s, p).size() > 0) {
            return true;
        }
        if (s.getPiece().getState() == 1) {
            if (this.kingJumpLogic(s, p).size() > 0) {
                return true;
            }
        }
        return false;
    }

    public Square getBetween(Square s, Square f) {
        return this.get(new Point((s.getX() + f.getX()) / 2, (s.getY() + f.getY()) / 2));
    }
}
