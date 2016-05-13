package com.checkerbot.checkerbot.GameObjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.checkerbot.checkerbot.GameObjects.Piece;

public class Square {

    private int x = -1;

    private int y = -1;

    private int color = 0;

    private Piece piece;

    public Square() {
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void draw(Canvas canvas, int width) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(this.color);
        Rect r = new Rect(x * width, y * width, width + x * width, width + y * width);
        canvas.drawRect(r, paint);
        if(piece!=null){
            paint.setColor(piece.getColor());
            canvas.drawCircle(r.centerX(), r.centerY(), width / 3, paint);
        }
        if (this.isKing()) {
            if (piece.getColor() == Color.WHITE) {
                paint.setColor(Color.BLACK);

            } else {
                paint.setColor(Color.WHITE);
            }
            paint.setTextSize(width / 4);
            canvas.drawText("K", 0, 1, (width / 2 + x * width) - paint.getTextSize() / 3, (width / 2 + y * width) + paint.getTextSize()/3, paint);

        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String toString() {
        return "X: " + x + " Y: " + y;
    }

    public boolean isKing() {
        if(piece!=null) {
            if (piece.getState() == 1) {
                return true;
            }
        }
        return false;
    }
}

