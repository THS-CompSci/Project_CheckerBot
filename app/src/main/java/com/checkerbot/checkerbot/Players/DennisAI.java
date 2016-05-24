package com.checkerbot.checkerbot.Players;

import com.checkerbot.checkerbot.GameObjects.Board;
import com.checkerbot.checkerbot.GameObjects.Player;
import com.checkerbot.checkerbot.GameObjects.Square;

import java.util.Random;

/**
 * Created by Damen on 5/11/2016.
 */

public class DennisAI extends Player {


    public Square getTurn(Board board) {
        Square[] squares = board.getPieceArray(this);
        while (true) {
            Square s = squares[(int) (Math.random() * squares.length)];
            if (!board.getValidMoves(s,this).isEmpty())
            return s;

        }
    }

    public Square getTurn(Square[] squares){
        Square s=squares[(int)(Math.random()*squares.length)];


        return s;
    }

}
