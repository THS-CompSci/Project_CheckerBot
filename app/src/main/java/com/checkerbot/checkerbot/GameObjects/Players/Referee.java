package com.checkerbot.checkerbot.GameObjects.Players;

import android.graphics.Color;
import android.widget.Toast;

import com.checkerbot.checkerbot.GameObjects.Board;
import com.checkerbot.checkerbot.GameObjects.Player;
import com.checkerbot.checkerbot.GameObjects.Square;

import java.sql.Ref;
import java.util.ArrayList;

public class Referee implements Runnable  {

    private Player p1;
    private Player p2;
    private Board board;

    public Referee(Player p1, Player p2, Board board) {
        this.p1 = p1;
        this.p2 = p2;
        this.board = board;
    }

    @Override
    public void run() {

    }

    public void referee() throws InterruptedException {

    }

}
