package com.checkerbot.checkerbot;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.checkerbot.checkerbot.GameObjects.Board;
import com.checkerbot.checkerbot.GameObjects.Player;
import com.checkerbot.checkerbot.GameObjects.Square;
import com.checkerbot.checkerbot.Players.AdamAI;
import com.checkerbot.checkerbot.Players.BrianAI;
import com.checkerbot.checkerbot.Players.DamenAI;
import com.checkerbot.checkerbot.Players.DennisAI;
import com.checkerbot.checkerbot.Players.WilliamAI;
import com.checkerbot.checkerbot.Players.YasserAI;

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

        switch(player1){
            case "Adam AI":
                p1= new AdamAI();
            break;
            case "Damen AI":
                p1= new DamenAI();
                break;
            case "Yasser AI":
                p1= new YasserAI();
                break;
            case "Dennis AI":
                p1= new DennisAI();
                break;
            case "Brian AI":
                p1= new BrianAI();
                break;
            case "William AI":
                p1= new WilliamAI();
                break;
        }

        switch(player2){
            case "Adam AI":
                p2= new AdamAI();
                break;
            case "Damen AI":
                p2= new DamenAI();
                break;
            case "Yasser AI":
                p2= new YasserAI();
                break;
            case "Dennis AI":
                p2= new  DennisAI();
                break;
            case "Brian AI":
                p2= new BrianAI();
                break;
            case "William AI":
                p2= new WilliamAI();
                break;
        }

        p1.setColor(Color.WHITE);
        p2.setColor(Color.BLACK);
        p1.setOtherPlayer(p2);
        p2.setOtherPlayer(p1);
        p1.setTurn(true);
        
        this.referee();

    }

    private void referee() {
    }


    public void update() {
        boardView.update();
    }

    public boolean validMove(Player p, Square s) {
        return true;
    }

}