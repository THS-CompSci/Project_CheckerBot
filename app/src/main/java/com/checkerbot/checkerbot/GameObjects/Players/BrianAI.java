package com.checkerbot.checkerbot.GameObjects.Players;

import android.graphics.Color;
import android.graphics.Point;
import android.util.Log;

import com.checkerbot.checkerbot.GameObjects.Board;
import com.checkerbot.checkerbot.GameObjects.Player;
import com.checkerbot.checkerbot.GameObjects.Square;

/**
 * Created by Damen on 5/11/2016.
 */


public class BrianAI extends Player {

    int[][] boardMat;
    private int row;
    private int col;

    public BrianAI(){
        row=0;
        col=0;
        boardMat = new int[8][8];

    }

    public Square getTurn(Board board){
        Square s =null;
        if(board.getValidPieceArray(this)==null){
            fillMatrix(board);
            s = getBestMove(board);
        }
        else{
            s = getBestJump(board.getValidPieceArray(this));
        }

        return s;

    }

    public Square getTurn(Square[] squares){
        Square s = squares[(int) (Math.random() * squares.length)];
        for(int i=0;i<squares.length;i++){
            if(squares[i].getX()==row && squares[i].getY()==col){
                s = squares[i];

            }

        }
        return s;
    }



    public Square getBestJump(Square[] jumps){
        return jumps[0];
    }

    public Square getBestMove(Board board) {
        row = 0;
        col = 0;
        int num = 0;
        int pr = 0;
        int pc = 0;
        if (this.getColor() == Color.BLACK) {
            for (int r = 0; r < 8; r++) {
                for (int c = 1; c < 8; c++) {
                    if ((r % 2 == 0 && c % 2 == 1 && boardMat[r][c] > num) || (r % 2 == 1 && c % 2 == 0 && boardMat[r][c] > num)) {
                        if (boardMat[r + 1][c - 1] == 0) {
                            num = boardMat[r][c];
                            row = r;
                            col = c;
                            pr = r + 1;
                            pc = c - 1;
                        } else if (boardMat[r - 1][c - 1] == 0) {
                            num = boardMat[r][c];
                            row = r;
                            col = c;
                            pr = r - 1;
                            pc = c - 1;
                        }
                    }
                }

            }
        } else {
            for (int r = 1; r < 7; r++) {
                for (int c = 0; c < 7; c++) {
                    if ((r % 2 == 0 && c % 2 == 1 && boardMat[r][c] > num) || (r % 2 == 1 && c % 2 == 0 && boardMat[r][c] > num)) {
                        if (boardMat[r + 1][c + 1] == 0) {
                            num = boardMat[r][c];
                            row = r;
                            col = c;
                            pr = r + 1;
                            pc = c + 1;
                        } else if (boardMat[r - 1][c + 1] == 0) {
                            num = boardMat[r][c];
                            row = r;
                            col = c;
                            pr = r - 1;
                            pc = c + 1;
                        }
                    }
                }
            }
        }
        Square s = board.getSquare(new Point(pr, pc));
        return s;
    }




    public void fillMatrix(Board board){
        for(int r=1;r<7;r++){
            for (int c=0;c<8;c++) {
                if (board.getSquare(new Point(r, c)).getPiece() != null) {
                    if (r % 2 == 0 && c % 2 == 1) {
                        if (board.getSquare(new Point(r, c)).getPiece().getColor() == this.getColor()) {
                            boardMat[r][c] = 1;
                        } else {
                            boardMat[r][c] = -2;
                        }
                    } else if (r % 2 == 1 && c % 2 == 0) {
                        if (board.getSquare(new Point(r, c)).getPiece().getColor() == this.getColor()) {
                            boardMat[r][c] = 1;
                        } else {
                            boardMat[r][c] = -2;
                        }
                    }
                } else if (board.getSquare(new Point(r, c)).getPiece() == null) {
                    if (r % 2 == 0 && c % 2 == 1) {
                        boardMat[r][c] = 2;

                    } else if (r % 2 == 1 && c % 2 == 0) {
                        boardMat[r][c] = 2;
                    }
                }
            }
        }
        for(int r=1;r<7;r++) {
            for (int c = 1; c < 7; c++) {
                if(this.getColor() == Color.WHITE){
                    if(boardMat[r][c] == 2){
                        if(boardMat[r-1][c-1] == -2 || boardMat[r+1][c-1] == -2){
                            boardMat[r][c] = -1;
                        }
                        else{
                            if(c>3){
                                boardMat[r][c] = 7-c+r;
                            }
                            else {
                                boardMat[r][c] = c+r;
                            }
                        }
                    }
                }
                else{
                    if(boardMat[r][c] == 2){
                        if(boardMat[r-1][c+1] == -2 || boardMat[r+1][c+1] == -2){
                            boardMat[r][c] = -1;
                        }
                    }

                }
            }
        }


        for(int r=0;r<8;r++) {
            String str = "";

            for (int c = 0; c < 8; c++) {
                str +=boardMat[r][c] +"";
            }
            Log.i("brianai",str );
        }
        Log.i("brianai","_______________________" );

    }
}
