package com.checkerbot.checkerbot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardView extends View {

    private Square[][] board = new Square[8][8];
    private int windowWidth;
    private int windowHeight;
    private boolean first = true;

    public BoardView(Context context) {
        super(context);
        //Get Screen Size
        Point point = new Point();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        display.getSize(point);

        // Get screen max x and y.
        windowWidth = point.x;
        windowHeight = point.y;
    }

    protected void onDraw(Canvas canvas) {
        if (first) {
            first = false;
            initBoard(canvas);
        }
    }


    private void initBoard(Canvas canvas) {
        for (Square[] row : board) {
            Arrays.fill(row, new Square());
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square current = board[i][j];
                current.setX(j);
                current.setY(i);
                current.setSide(windowWidth / 8);
                if ((i + j) % 2 != 0) {
                    current.setColor(Color.rgb(127, 174, 255));
                    if (i < 3) {
                        current.setPiece(1);
                    }
                    if (i > 4) {
                        current.setPiece(2);
                    }

                } else {
                    current.setColor(Color.rgb(3, 45, 119));
                }
                current.draw(canvas);
            }

        }

    }

    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                int side = windowWidth/8;
                int x = (int)event.getX();
                int y = (int)event.getY();
                if(y>windowWidth){
                    break;
                }
                x=x/side;
                y=y/side;
                System.out.println("X: "+x+" Y: "+y);

                return true;
        }
        return super.onTouchEvent(event);
    }

    public String save() {
        return null;
    }
}