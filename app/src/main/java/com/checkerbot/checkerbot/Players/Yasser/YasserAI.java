package com.checkerbot.checkerbot.Players.Yasser;

import com.checkerbot.checkerbot.GameObjects.Board;
import com.checkerbot.checkerbot.GameObjects.Player;
import com.checkerbot.checkerbot.GameObjects.Square;


public class YasserAI extends Player {

    public Square getTurn(Board board){
        Square[] squares= board.getPieceArray(this);
        while(true) {
            Square s = squares[(int) (Math.random() * squares.length)];
            if(!board.getValidMoves(s,this).isEmpty()){
                return s;
            }
        }
    }

    public Square getTurn(Square[] squares){
        return squares[(int)(Math.random()*squares.length)];
    }
}
