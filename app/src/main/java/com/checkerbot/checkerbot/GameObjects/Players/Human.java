package com.checkerbot.checkerbot.GameObjects.Players;

import com.checkerbot.checkerbot.BoardView;
import com.checkerbot.checkerbot.GameObjects.Board;
import com.checkerbot.checkerbot.GameObjects.Player;
import com.checkerbot.checkerbot.GameObjects.Square;

import java.util.ArrayList;

/**
 * Created by Damen on 5/28/2016.
 */
public class Human extends Player {



    public Human(Player otherPlayer, int color, Board board) {
        super(otherPlayer, color, board);
    }

    @Override
    public Square getPlay() {
        return null;
    }

    @Override
    public Square getMove() {
        return null;
    }

    public Square getSquareAtCoordinates(int x, int y){
        return null;
    }

}
