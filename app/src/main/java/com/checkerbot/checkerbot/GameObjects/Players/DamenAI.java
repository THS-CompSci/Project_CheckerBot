package com.checkerbot.checkerbot.GameObjects.Players;

import android.graphics.Color;

import com.checkerbot.checkerbot.GameObjects.Board;
import com.checkerbot.checkerbot.GameObjects.Player;
import com.checkerbot.checkerbot.GameObjects.Square;

import java.util.ArrayList;

/**
 * Created by Damen on 5/11/2016.
 */

public class DamenAI extends Player {

    public DamenAI(Player otherPlayer, int color, Board board) {
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
}
