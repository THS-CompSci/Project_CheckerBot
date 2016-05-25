package com.checkerbot.checkerbot.GameObjects.Players;

import com.checkerbot.checkerbot.GameObjects.Board;
import com.checkerbot.checkerbot.GameObjects.Player;
import com.checkerbot.checkerbot.GameObjects.Square;

/**
 * Created by Damen on 5/11/2016.
 */

public class WilliamAI extends Player {


    public Square getTurn(Board board) {
        Square[] squares = board.getPieceArray(this);
        while (true) {
            Square s = squares[(int) (Math.random() * squares.length)];
            if (!board.getValidMoves(s, this).isEmpty()) {
                return s;
            }

        }

    }

    public Square getTurn(Square[] squares) {
        Square s = squares[(int) (Math.random() * squares.length)];
        return s;
    }
}