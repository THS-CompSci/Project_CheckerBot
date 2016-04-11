package com.checkerbot.checkerbot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void  NewGame(View view){
        Intent intent = new Intent(this, GameSetup.class);
        startActivity(intent);
    }
}