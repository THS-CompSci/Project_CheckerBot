package com.checkerbot.checkerbot;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Board extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        this.drawBoard();
        Paint p = new Paint();
    }

    private void drawBoard() {
        ImageView i = (ImageView) this.findViewById(R.id.board);
        Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        Paint paint = new Paint();
        c.drawRect(100f,100f,100f,100f,paint);
        i.setImageDrawable(new BitmapDrawable(getResources(),b));
    }
}
