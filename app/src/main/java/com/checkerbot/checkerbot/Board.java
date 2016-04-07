package com.checkerbot.checkerbot;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.ImageView;

public class Board extends AppCompatActivity {
    DisplayMetrics metrics;
    int width = 0, height = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        height = metrics.heightPixels;
        width = metrics.widthPixels;
        super.onCreate(savedInstanceState);
        BoardView b = new BoardView(this);
        b.setDim(width,height);
        setContentView(b);
    }
}
