package com.checkerbot.checkerbot.GameObjects.Players;

import android.graphics.Color;

import com.checkerbot.checkerbot.GameObjects.Board;
import com.checkerbot.checkerbot.GameObjects.Player;
import com.checkerbot.checkerbot.GameObjects.Square;

import java.util.ArrayList;

/**
 * Created by kyokyo on 5/12/2016.
 */
public class AdamAI extends Player {


    public AdamAI(Player otherPlayer, int color, Board board) {
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
