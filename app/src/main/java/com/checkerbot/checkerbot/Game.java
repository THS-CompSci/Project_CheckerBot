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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

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
        p1 = new Player(player1);
        p2 = new Player(player2);
        p1.setPiece(1);
        p2.setPiece(2);
        p1.setOtherPlayer(p2);
        p2.setOtherPlayer(p1);
        p1.setTurn(true);

    }

    public void logic(Point p) {
        Player t = this.getTurn();
        Square s = board.get(p);
        if ((p.x + p.y) % 2 != 0) {
            try {
                if (t.isActive()) {
                    if (t.getValidMoves().contains(s)) {
                        for (Square v : t.getValidMoves()) {
                            v.setColor(Color.rgb(127, 174, 255));
                        }
                        s.setPiece(t.getPiece());
                        t.getPlay().setPiece(0);
                        t.getPlay().setColor(Color.rgb(127, 174, 255));
                        if (board.isJump(s) && board.isJump(t.getPlay())) {

                        } else {
                            t.setActive(false);
                            t.setValidMoves(new ArrayList<Square>());
                            t.setPlay(new Square());
                            t.setTurn(false);
                            t.getOtherPlayer().setTurn(true);


                        }
                    } else {

                        t.getPlay().setColor(Color.rgb(127, 174, 255));
                        t.setActive(false);
                        for (Square v : t.getValidMoves()) {
                            v.setColor(Color.rgb(127, 174, 255));
                        }
                        this.logic(p);
                    }
                } else {
                    t.setPlay(s);
                    t.setActive(true);
                    t.setValidMoves(board.getValidMoves(s, t));
                    s.setColor(Color.rgb(127, 174, 100));
                    for (Square v : t.getValidMoves()) {
                        v.setColor(Color.rgb(50, 174, 100));
                    }
                }

            } catch (InvalidMoveException e) {
                Toast.makeText(this, "Invalid Move", Toast.LENGTH_SHORT).show();
                t.setPlay(new Square());
                if ((p.x + p.y) % 2 != 0) {
                    t.getPlay().setColor(Color.rgb(127, 174, 255));
                }
                for (Square v : t.getValidMoves()) {
                    v.setColor(Color.rgb(127, 174, 255));
                }

            }
        } else {
            Toast.makeText(this, "Invalid Move", Toast.LENGTH_SHORT).show();
            t.getPlay().setColor(Color.rgb(127, 174, 255));
            for (Square v : t.getValidMoves()) {
                v.setColor(Color.rgb(127, 174, 255));
            }


        }
        this.update();
    }


    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == 0) {
            logic(boardView.getPoint());
        }
        return super.onTouchEvent(event);

    }

    public Player getTurn() {
        if (p1.isTurn()) {
            return p1;
        } else {
            return p2;
        }
    }

    public void update() {
        boardView.update();
    }

    public boolean validMove(Player p, Square s) {
        return true;
    }

}