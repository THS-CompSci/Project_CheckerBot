package com.checkerbot.checkerbot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Board extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BoardView b = new BoardView(this);
        setContentView(b);
    }
}
