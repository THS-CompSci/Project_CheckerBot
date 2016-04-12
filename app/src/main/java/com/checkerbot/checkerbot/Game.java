package com.checkerbot.checkerbot;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.Arrays;

public class Game extends AppCompatActivity {

    Board board;
    BoardView boardView;
    int windowWidth, windowHeight;
    Player p1;
    Player p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        board = new Board();
        boardView = new BoardView(this, board);
        setContentView(boardView);
        windowWidth = boardView.getWindowWidth();
        String player1 = getIntent().getStringExtra("Player1");
        String player2 = getIntent().getStringExtra("Player2");
        p1 = new Player(player1);
        p2 = new Player(player2);
        p1.setPiece(1);
        p2.setPiece(2);
        p1.setTurn(true);

    }

    public void logic(Point p){
        Player t = this.getTurn();
        Square s = board.get(p);
        if(t.isActive()){
            if(Arrays.asList(t.getValidMoves()).contains(s)){
                s.setColor(Color.rgb(127, 174, 255));
                s.setPiece(t.getPiece());
                t.getPlay().setPiece(0);
            }
        }else{
            if(this.validMove(t,s)){

            }
        }


    }

    public boolean onTouchEvent(MotionEvent event){
        logic(boardView.getPoint());

        return super.onTouchEvent(event);
    }

    public Player getTurn(){
        if(p1.isTurn()){
            return p1;
        }else{
            return p2;
        }
    }

    public boolean validMove(Player p, Square s){
        return true;
    }

}