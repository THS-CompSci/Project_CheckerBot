package com.checkerbot.checkerbot.GameObjects.Players;

import com.checkerbot.checkerbot.GameObjects.Board;
import com.checkerbot.checkerbot.GameObjects.Player;
import com.checkerbot.checkerbot.GameObjects.Square;

/**
 * Created by kyokyo on 5/12/2016.
 */
public class AdamAI extends Player {

    public Square getTurn(Board board) {
        Square[] squares = board.getValidPieceArray(this);
        for (Square sq : squares) {
            Square s = squares[(int) (Math.random() * squares.length)];
            if (!board.getValidMoves(s, this).isEmpty()) {
                return s;
            }
        }
    return null;

    }

    public Square getTurn(Square[] squares) {
        return squares[(int) (Math.random() * squares.length)];
    }
}
