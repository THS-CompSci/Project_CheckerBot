package com.checkerbot.checkerbot;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.checkerbot.checkerbot.GameObjects.Board;
import com.checkerbot.checkerbot.GameObjects.Player;
import com.checkerbot.checkerbot.GameObjects.Players.Human;
import com.checkerbot.checkerbot.GameObjects.Players.Referee;
import com.checkerbot.checkerbot.GameObjects.Players.AdamAI;
import com.checkerbot.checkerbot.GameObjects.Players.DamenAI;

public class Game extends AppCompatActivity {

    Board board;

    BoardView boardView;

    Player p1;

    Player p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        board = new Board();
        boardView = new BoardView(this, board);
        setContentView(boardView);
        String player1 = getIntent().getStringExtra("Player1");
        String player2 = getIntent().getStringExtra("Player2");

        switch (player1) {
            case "Adam AI":
                p1 = new AdamAI(p2, Color.WHITE, board);
                break;
            case "Damen AI":
                p1 = new DamenAI(p2, Color.WHITE, board);
                break;
            case "Human":
                p1 = new Human(p2, Color.WHITE, board);
                break;
        }

        switch (player2) {
            case "Adam AI":
                p2 = new AdamAI(p1, Color.BLACK, board);
                break;
            case "Damen AI":
                p2 = new DamenAI(p1, Color.BLACK, board);
                break;
            case "Human":
                p1 = new Human(p1, Color.BLACK, board);
                break;
        }

        new Thread(new Referee(p1, p2, board) {
            @Override
            public void run() {

                try {
                    this.referee();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();


    }


}