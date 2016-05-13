package com.checkerbot.checkerbot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.checkerbot.checkerbot.GameObjects.Board;
import com.checkerbot.checkerbot.GameObjects.Square;

public class BoardView extends View {

    public Square[][] board;

    private int windowWidth;

    private int windowHeight;

    private boolean first = true;

    private Point pressPoint = new Point(-1, -1);

    public BoardView(Context context, Board board) {
        super(context);
        this.board = board.getBoard();

        //Get Screen Size
        Point point = new Point();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        display.getSize(point);

        // Get screen max x and y.
        if (point.x > point.y) {
            windowWidth = point.y;
            windowHeight = point.x;
        } else {
            windowWidth = point.x;
            windowHeight = point.y;
        }
        windowWidth = point.x;
        windowHeight = point.y;

    }

    protected void onDraw(Canvas canvas) {
        this.drawBoard(canvas);
    }

    private void drawBoard(Canvas canvas) {
        for (Square[] row : board) {
            for (Square s : row) {
                s.draw(canvas, windowWidth / 8);
            }
        }
    }

    public void update() {
        invalidate();
    }

    public int getWindowWidth() {
        return this.windowWidth;
    }

    public int getWindowHeight() {
        return this.windowHeight;
    }

    public boolean onTouchEvent(MotionEvent event) {

        pressPoint = this.getViewPoint(event);
        return super.onTouchEvent(event);
    }

    private Point getViewPoint(MotionEvent event) {

        Point point;
        int side = windowWidth / 8;
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (y > windowWidth) {
            point = new Point(-1, -1);
        } else {
            point = new Point(x / side, y / side);
        }
        return point;
    }

    public Point getPoint() {
        return pressPoint;
    }

}