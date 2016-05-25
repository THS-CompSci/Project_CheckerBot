package com.checkerbot.checkerbot.GameObjects.Players;

import android.graphics.Point;

import com.checkerbot.checkerbot.GameObjects.Board;
import com.checkerbot.checkerbot.GameObjects.Player;
import com.checkerbot.checkerbot.GameObjects.Square;

/**
 * Created by Damen on 5/11/2016.
 */
public class BrianAI extends Player {

    int[][] boardMat = new int[8][8];

    public Square getTurn(Board board){
        fillMatrix(board);

        Square[] squares= board.getPieceArray(this);
        while(true) {
            Square s = squares[(int) (Math.random() * squares.length)];
            if(!board.getValidMoves(s,this).isEmpty()){
                return s;
            }

        }

    }

    public Square getTurn(Square[] squares){
        Square s = squares[(int)(Math.random()*squares.length)];
        return s;
    }


    public void fillMatrix(Board board){
        for(int r=0;r<8;r++){
            for (int c=0;c<8;c++){
                if(r%2==0 && c%2==1){
                    if(board.getSquare(new Point(r,c)).getPiece().getColor() == this.getColor()){
                        boardMat[r][c] = 0;
                    }
                    else {
                        boardMat[r][c] = -2;
                    }
                }
                else if (r%2==1 && c%2==0){
                    if(board.getSquare(new Point(r,c)).getPiece().getColor() == this.getColor()){
                        boardMat[r][c] = 0;
                    }
                    else {
                        boardMat[r][c] = -2;
                    }
                }
            }
        }
    }
}
