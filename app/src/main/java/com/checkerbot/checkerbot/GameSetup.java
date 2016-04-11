package com.checkerbot.checkerbot;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class GameSetup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_setup);


        Spinner player1 = (Spinner) findViewById(R.id.player1);
        Spinner player2 = (Spinner) findViewById(R.id.player2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Player_name,android.R.layout.simple_spinner_dropdown_item);

        player1.setAdapter(adapter);
        player2.setAdapter(adapter);

    }

    public void StartGame(View view){
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
}
