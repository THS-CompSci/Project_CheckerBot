package com.checkerbot.checkerbot;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;

import com.checkerbot.checkerbot.GameObjects.Board;
import com.checkerbot.checkerbot.GameObjects.Piece;
import com.checkerbot.checkerbot.GameObjects.Player;
import com.checkerbot.checkerbot.GameObjects.Referee;
import com.checkerbot.checkerbot.GameObjects.Square;
import com.checkerbot.checkerbot.Players.AdamAI;
import com.checkerbot.checkerbot.Players.BrianAI;
import com.checkerbot.checkerbot.Players.DamenAI;
import com.checkerbot.checkerbot.Players.DennisAI;
import com.checkerbot.checkerbot.Players.WilliamAI;
import com.checkerbot.checkerbot.Players.YasserAI;

import java.util.ArrayList;
import java.util.concurrent.RunnableFuture;

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
                p1 = new AdamAI();
                break;
            case "Damen AI":
                p1 = new DamenAI();
                break;
            case "Yasser AI":
                p1 = new YasserAI();
                break;
            case "Dennis AI":
                p1 = new DennisAI();
                break;
            case "Brian AI":
                p1 = new BrianAI();
                break;
            case "William AI":
                p1 = new WilliamAI();
                break;
        }

        switch (player2) {
            case "Adam AI":
                p2 = new AdamAI();
                break;
            case "Damen AI":
                p2 = new DamenAI();
                break;
            case "Yasser AI":
                p2 = new YasserAI();
                break;
            case "Dennis AI":
                p2 = new DennisAI();
                break;
            case "Brian AI":
                p2 = new BrianAI();
                break;
            case "William AI":
                p2 = new WilliamAI();
                break;
        }

        p1.setColor(Color.WHITE);
        p2.setColor(Color.BLACK);
        p1.setOtherPlayer(p2);
        p2.setOtherPlayer(p1);
        p1.setTurn(true);



    }


    private void referee(){
            //Have p1 choose which piece to play
            ArrayList<Square> p1Changed = new ArrayList<Square>();
            Square p1Play = p1.getTurn(board);
            p1Play.setColor(Color.GREEN);
            p1Changed.add(p1Play);

            //Have the board display the valid moves
            ArrayList<Square> p1ValidMoves = board.getValidMoves(p1Play, p1);
            for (Square s : p1ValidMoves) {
                s.setColor(Color.RED);
                p1Changed.add(s);
            }


            //Have p1 select from valid moves, and change selected square's color
            Square p1selected = p1.getTurn(board.getValidMoves(p1Play, p1).toArray(new Square[]{}));
            p1selected.setColor(Color.RED);
            p1Changed.add(p1selected);


            //Move the piece to the selected square, and change the squares back to original color
            Piece p1Piece = p1Play.getPiece();
            if (p1selected.getY() == 0) {
                p1selected.setPiece(new Piece(p1.getColor(), 1));
            } else {
                p1selected.setPiece(new Piece(p1.getColor(), p1Piece.getState()));
            }
            p1Play.setPiece(null);
            for (Square s : p1Changed) {
                s.setColor(Color.rgb(127, 174, 255));
            }


            //Have p2 choose which piece to play
            ArrayList<Square> p2Changed = new ArrayList<Square>();
            Square p2Play = p2.getTurn(board);
            p2Play.setColor(Color.GREEN);
            p2Changed.add(p2Play);

            //Have the board display the valid moves
            ArrayList<Square> p2ValidMoves = board.getValidMoves(p2Play, p2);
            for (Square s : p2ValidMoves) {
                s.setColor(Color.RED);
                p2Changed.add(s);
            }

            //Have p2 select from valid moves, and change selected square's color
            Square p2selected = p2.getTurn(board.getValidMoves(p2Play, p2).toArray(new Square[]{}));
            p2selected.setColor(Color.RED);
            p2Changed.add(p2selected);


            //Move the piece to the selected square, and change the squares back to original color
            Piece p2Piece = p2Play.getPiece();
            if (p2selected.getY() == 0) {
                p2selected.setPiece(new Piece(p2.getColor(), 1));
            } else {
                p2selected.setPiece(new Piece(p2.getColor(), p2Piece.getState()));
            }
            p2Play.setPiece(null);
            for (Square s : p2Changed) {
                s.setColor(Color.rgb(127, 174, 255));
            }

    }


    public void update() {
        boardView.update();
    }

    public boolean validMove(Player p, Square s) {
        return true;
    }

}