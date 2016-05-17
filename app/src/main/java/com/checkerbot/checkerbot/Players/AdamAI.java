package com.checkerbot.checkerbot.Players;

import com.checkerbot.checkerbot.GameObjects.Board;
import com.checkerbot.checkerbot.GameObjects.Player;
import com.checkerbot.checkerbot.GameObjects.Square;

/**
 * Created by kyokyo on 5/12/2016.
 */
public class AdamAI extends Player {

    //TODO: Eat food given to me by my master

    public Square getTurn(Board board){
        Square[] s= board.getPieceArray(this);
        for(Square t: s){
            if(!board.getValidMoves(t,this).isEmpty()){
                return t;
            }
        }
        return null;
    }

    public Square getTurn(Square[] squares){

        return squares[0];
    }

}
