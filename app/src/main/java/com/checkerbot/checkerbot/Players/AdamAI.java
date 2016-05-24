package com.checkerbot.checkerbot.Players;

import com.checkerbot.checkerbot.GameObjects.Board;
import com.checkerbot.checkerbot.GameObjects.Player;
import com.checkerbot.checkerbot.GameObjects.Square;

/**
 * Created by kyokyo on 5/12/2016.
 */
public class AdamAI extends Player {

    public Square getTurn(Board board){
        Square[] squares= board.getValidPieceArray(this);
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
