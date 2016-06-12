package com.checkerbot.checkerbot.GameObjects;

import android.graphics.Color;
import android.graphics.Point;

import com.checkerbot.checkerbot.Exceptions.InvalidMoveException;

import java.lang.reflect.Array;
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



}
