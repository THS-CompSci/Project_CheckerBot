package com.checkerbot.checkerbot;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class GameSetup extends AppCompatActivity {
    Spinner player1;
    Spinner player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_setup);


        player1 = (Spinner) findViewById(R.id.player1);
        player2 = (Spinner) findViewById(R.id.player2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Player_name,android.R.layout.simple_spinner_dropdown_item);

        player1.setAdapter(adapter);
        player2.setAdapter(adapter);

    }

    public void StartGame(View view){
        String sp1 = player1.getSelectedItem().toString();
        String sp2 = player2.getSelectedItem().toString();
        Intent intent = new Intent(this, Game.class);
        intent.putExtra("Player1",sp1);
        intent.putExtra("Player2",sp2);
        startActivity(intent);
    }
}
