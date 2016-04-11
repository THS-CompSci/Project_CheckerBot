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

public class Game extends AppCompatActivity {

    Board board;
    BoardView boardView;
    int windowWidth, windowHeight;
    String player1;
    String player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        board = new Board();
        boardView = new BoardView(this, board);
        setContentView(boardView);
        windowWidth = boardView.getWindowWidth();
        player1 = getIntent().getStringExtra("Player1");
        player2 = getIntent().getStringExtra("Player2");
        Log.e("P1", player1);
        Log.e("P2", player2);

    }

    public boolean onTouchEvent(MotionEvent event) {
        Point p = boardView.getPoint();
        if(p.x>-1){
            this.gameLogic(p);
        }
        boardView.update();
        return super.onTouchEvent(event);
    }

    private void gameLogic(Point p) {

    }


}