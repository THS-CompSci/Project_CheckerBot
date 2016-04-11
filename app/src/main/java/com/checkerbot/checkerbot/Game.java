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
        this.game(getIntent().getStringExtra("Player1"), getIntent().getStringExtra("Player2"));

    }
    //http://stackoverflow.com/questions/17869353/turn-based-game-design-event-driven-vs-game-loop
    //https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller
    private void game(String player1, String player2) {

        /*
        Human turn
            ##################
            #      Model     #
            ##################
                Get location of Tap
                Is there a jump possible?
                    Yes
                        Did the player press a square with a possible jump?
                            Yes
                                Update View with Start and possible jumps
                            No
                                Notify Player "Must take possible jump"
                    No
                        Is the tap valid(On player's square)?
                            Yes
                                Is the tap new, or a continuation of the turn(Get the state of square tapped)?
                                    New
                                        Get Locations of valid moves
                                        Send View array of Squares(Where the player tapped, then valid moves).
                                    Continuing
                                        Is there an additional jump possible?
                                            Yes
                                                Send View array of Squares(Where the player tapped, then valid moves).
                                            No
                                                Next Turn.

                            No
                                Notify Player "Not a valid square".

            ##################
            #      View      #
            ##################
                Update board where specified with new colors.
                    [Where tapped, valid squares]
                Update View


            ##################
            #   Controller   #
            ##################
                When the screen is tapped go to Model

            AI Turn
            ##################
            #      Model     #
            ##################
                Get Location of Play
                Is there a jump possible?
                    Yes
                        Did the AI play a square with a possible jump?
                            Yes
                                Update View with Start and possible jumps
                                Send AI array of possible moves
                            Continuation
                                Did AI select a possible jump
                                    Yes
                                        Is there an additional jump possible?
                                                Yes
                                                    Send View array of Squares(Where the player tapped, then valid moves).
                                                No
                                                    Next Turn.
                                    No
                                        Notify AI
                            No
                                Notify AI "Must take possible jump"
                    No
                        Is the play valid(On AI's square)?
                            Yes
                                Is the play new, or a continuation of the turn(Get the state of square played)?
                                    New
                                        Get Locations of valid moves
                                        Send View array of Squares(Where the AI played, then valid moves).
                                        Send AI array of possible moves
                                    Continuing
                                        Is there an additional jump possible?
                                            Yes
                                                Send View array of Squares(Where the player tapped, then valid moves).
                                                Send AI array of possible moves
                                            No
                                                Next Turn.

                            No
                                Notify AI "Not a valid square".

            ##################
            #      View      #
            ##################
                Update board where specified with new colors.
                    [Where played, valid squares]
                Update View


            ##################
            #   Controller   #
            ##################
                When the AI Play Event is Fired go to Model

         */

    }


}