package com.checkerbot.checkerbot;

import android.graphics.Color;
import android.graphics.Point;

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

    public Square updateSquare(Point p ){
        return board[p.y][p.x];
    }

    public Square[][] getBoard() {
        return board;
    }

    public void updateSquare(Point p, int color) {
        board[p.y][p.x].setColor(color);
    }
}
